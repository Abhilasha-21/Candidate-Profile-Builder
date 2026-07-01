package com.eightfold.candidate_profile_builder.model;

public class Experience {

    private String company;
    private String title;
    private String start;
    private String end;

    public Experience() {
    }

    public Experience(String company, String title, String start, String end) {
        this.company = company;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}