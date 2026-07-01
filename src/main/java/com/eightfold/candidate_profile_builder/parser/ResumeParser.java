package com.eightfold.candidate_profile_builder.parser;

import com.eightfold.candidate_profile_builder.model.Candidate;
import com.eightfold.candidate_profile_builder.model.Skill;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResumeParser {

    public Candidate parse() throws Exception {

        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream("resume.txt");

        if (inputStream == null)
            throw new RuntimeException("resume.txt not found");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(inputStream));

        Candidate candidate = new Candidate();

        List<Skill> skills = new ArrayList<>();

        String line;

        int lineNumber = 0;

        boolean readingSkills = false;

        while ((line = reader.readLine()) != null) {

            line = line.trim();

            if(line.isEmpty())
                continue;

            lineNumber++;

            if(lineNumber==1)
                candidate.setFullName(line);

            else if(lineNumber==2)
                candidate.setHeadline(line);

            else if(line.equalsIgnoreCase("Skills"))
            {
                readingSkills=true;
                continue;
            }

            else if(line.equalsIgnoreCase("Experience"))
            {
                readingSkills=false;
                continue;
            }

            if(readingSkills)
            {
                skills.add(new Skill(line,0.85));
            }

        }

        candidate.setSkills(skills);

        return candidate;

    }

}