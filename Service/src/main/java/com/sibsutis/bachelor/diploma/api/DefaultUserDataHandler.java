package com.sibsutis.bachelor.diploma.api;

import com.sibsutis.bachelor.diploma.api.entities.RawRequestData;
import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultUserDataHandler {

    public static ExternalUser getUserDataWA(String userName){
        RawRequestData rawUserData = RequestHandlerWA.getAllUserInfoWA("nasa");
        ExternalUser userObj = new ExternalUser(rawUserData.getGraphql().getUser());
        return userObj;
    }

    public static boolean getPredictionWA(){
        return false;
    }
}
