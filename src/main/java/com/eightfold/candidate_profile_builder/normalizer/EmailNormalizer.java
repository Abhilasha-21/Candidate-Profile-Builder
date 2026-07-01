package com.eightfold.candidate_profile_builder.normalizer;

public class EmailNormalizer {

    public static String normalize(String email){

        return email.trim().toLowerCase();

    }

}