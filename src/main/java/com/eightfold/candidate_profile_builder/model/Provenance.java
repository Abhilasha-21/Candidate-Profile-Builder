package com.eightfold.candidate_profile_builder.model;

public class Provenance {

    private String field;
    private String source;

    public Provenance() {
    }

    public Provenance(String field, String source) {
        this.field = field;
        this.source = source;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}