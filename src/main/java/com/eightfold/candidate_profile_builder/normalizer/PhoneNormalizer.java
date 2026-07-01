package com.eightfold.candidate_profile_builder.normalizer;

public class PhoneNormalizer {

    public static String normalize(String phone) {

        phone = phone.replaceAll("[^0-9]", "");

        if(phone.length()==10)
            phone="+91"+phone;

        return phone;
    }

}