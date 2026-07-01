package com.eightfold.candidate_profile_builder.merger;

import com.eightfold.candidate_profile_builder.model.*;

import java.util.ArrayList;
import java.util.List;

public class CandidateMerger {

    public Candidate merge(Candidate csvCandidate,
                           Candidate resumeCandidate){

        Candidate finalCandidate = new Candidate();

        finalCandidate.setCandidateId("C001");

        finalCandidate.setFullName(csvCandidate.getFullName());

        finalCandidate.setEmails(csvCandidate.getEmails());

        finalCandidate.setPhones(csvCandidate.getPhones());

        finalCandidate.setHeadline(resumeCandidate.getHeadline());

        finalCandidate.setSkills(resumeCandidate.getSkills());

        // ==========================
        // Provenance
        // ==========================

        List<Provenance> provenanceList = new ArrayList<>();

        provenanceList.add(new Provenance(
                "fullName",
                "Recruiter CSV"
        ));

        provenanceList.add(new Provenance(
                "emails",
                "Recruiter CSV"
        ));

        provenanceList.add(new Provenance(
                "phones",
                "Recruiter CSV"
        ));

        provenanceList.add(new Provenance(
                "headline",
                "Resume"
        ));

        provenanceList.add(new Provenance(
                "skills",
                "Resume"
        ));

        finalCandidate.setProvenance(provenanceList);

        return finalCandidate;

    }

}