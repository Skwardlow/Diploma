package com.sibsutis.bachelor.diploma.api;

import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultUserDataHandler {

    public static ExternalUser getUserDataNA(){

        return null;
    }

    public static boolean getPredictionNA(){

        return false;
    }
}
