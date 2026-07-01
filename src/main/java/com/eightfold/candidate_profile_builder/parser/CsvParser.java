package com.eightfold.candidate_profile_builder.parser;

import com.eightfold.candidate_profile_builder.model.Candidate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public Candidate parse() throws Exception {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("recruiter.csv");

        if (inputStream == null) {
            throw new RuntimeException("recruiter.csv not found!");
        }

        InputStreamReader reader = new InputStreamReader(inputStream);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(reader);

        Candidate candidate = new Candidate();

        List<String> emails = new ArrayList<>();
        List<String> phones = new ArrayList<>();

        for (CSVRecord record : records) {

            candidate.setFullName(record.get("Name"));

            emails.add(record.get("Email"));

            phones.add(record.get("Phone"));

            candidate.setEmails(emails);

            candidate.setPhones(phones);

            candidate.setHeadline(record.get("Title"));
        }

        return candidate;
    }
}