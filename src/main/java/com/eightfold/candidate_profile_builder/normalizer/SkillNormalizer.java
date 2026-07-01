package com.eightfold.candidate_profile_builder.normalizer;

import java.util.HashMap;
import java.util.Map;

public class SkillNormalizer {

    static Map<String,String> skillMap = new HashMap<>();

    static{

        skillMap.put("JAVA","Java");
        skillMap.put("SPRINGBOOT","Spring Boot");
        skillMap.put("MYSQL","MySQL");
        skillMap.put("DOCKER","Docker");

    }

    public static String normalize(String skill){

        return skillMap.getOrDefault(
                skill.replace(" ","").toUpperCase(),
                skill
        );

    }

}