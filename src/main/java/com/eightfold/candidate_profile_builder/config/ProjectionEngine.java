package com.eightfold.candidate_profile_builder.config;

import com.eightfold.candidate_profile_builder.model.Candidate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.InputStream;

public class ProjectionEngine {

    private final ObjectMapper mapper = new ObjectMapper();

    public void generateOutput(Candidate candidate) throws Exception {

        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream("config.json");

        JsonNode config = mapper.readTree(inputStream);

        JsonNode fields = config.get("fields");

        ObjectNode output = mapper.createObjectNode();

        for (JsonNode node : fields) {

            String field = node.get("path").asText();

            switch (field) {

                case "candidate_id":
                    output.put("candidate_id", candidate.getCandidateId());
                    break;

                case "full_name":
                    output.put("full_name", candidate.getFullName());
                    break;

                case "emails":
                    output.putPOJO("emails", candidate.getEmails());
                    break;

                case "phones":
                    output.putPOJO("phones", candidate.getPhones());
                    break;

                case "headline":
                    output.put("headline", candidate.getHeadline());
                    break;

                case "skills":
                    output.putPOJO("skills", candidate.getSkills());
                    break;

                case "provenance":
                    output.putPOJO("provenance", candidate.getProvenance());
                    break;
            }

        }

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("output.json"), output);

        System.out.println("\n===== GENERATED JSON =====");

        System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(output)
        );

        System.out.println("\noutput.json created successfully.");

    }

}