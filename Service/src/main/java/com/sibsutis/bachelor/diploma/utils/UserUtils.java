package com.sibsutis.bachelor.diploma.utils;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class UserUtils {
    public static Float getNumsRatio(String data){
        DecimalFormat df = new DecimalFormat("#.##");
        int a = data.length();
        int b = data.replaceAll("\\D", "").length();
        return Float.valueOf(df.format((float)b/a));
    }

    public static Integer getWordsCount(String data){
        String trimmedData = data.trim();
        if (trimmedData.isEmpty()){
            return 0;
        }
        return trimmedData.split("\\s+").length;
    }
}
