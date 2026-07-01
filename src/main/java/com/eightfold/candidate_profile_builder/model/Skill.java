package com.eightfold.candidate_profile_builder.model;

public class Skill {

    private String name;
    private double confidence;

    public Skill() {
    }

    public Skill(String name, double confidence) {
        this.name = name;
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}