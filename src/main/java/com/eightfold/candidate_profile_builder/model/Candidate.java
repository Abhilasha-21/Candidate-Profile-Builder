package com.eightfold.candidate_profile_builder.model;

import java.util.List;

public class Candidate {

    private String candidateId;
    private String fullName;
    private List<String> emails;
    private List<String> phones;
    private String headline;
    private List<Skill> skills;
    private List<Experience> experience;
    private List<Provenance> provenance;

    public Candidate() {
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Provenance> getProvenance() {
        return provenance;
    }

    public void setProvenance(List<Provenance> provenance) {
        this.provenance = provenance;
    }
}