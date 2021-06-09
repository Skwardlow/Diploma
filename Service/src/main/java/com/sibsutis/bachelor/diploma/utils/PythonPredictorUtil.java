package com.sibsutis.bachelor.diploma.utils;

import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import org.springframework.stereotype.Component;

@Component
public class PythonPredictorUtil {

    public static String getCSVFromUserData(ExternalUser user){
        return (user.getProfile_pic() != null ? "1":"0") + "," +
                user.getNumsLength_username() + "," +
                user.getFullname_words() + "," +
                user.getNumsLength_fullname() + "," +
                (user.getUsername() == user.getFullname() ? "1" : "0") + "," +
                user.getDescription().length() + "," +
                (user.getExternal_url() != null ? "1" : "0") + "," +
                (user.getIs_private() != null ? "1" : "0") + "," +
                user.getPosts_count() + "," +
                user.getFollowers_count() + "," +
                user.getFollows_count();
    }

}
