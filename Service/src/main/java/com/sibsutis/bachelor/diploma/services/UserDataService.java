package com.sibsutis.bachelor.diploma.services;

import com.sibsutis.bachelor.diploma.api.DefaultUserDataHandler;
import com.sibsutis.bachelor.diploma.api.InternalRequestHandler;
import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import com.sibsutis.bachelor.diploma.utils.PythonPredictorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDataService {
    private DefaultUserDataHandler defaultUserDataHandler;
    private InternalRequestHandler botApi;

    public String predictByUserLink(String userLink){
        ExternalUser user = this.defaultUserDataHandler.getUserDataWA(userLink);
        PythonPredictorUtil.getCSVFromUserData(user);
        log.info(PythonPredictorUtil.getCSVFromUserData(user));
        botApi.predictorRequest(PythonPredictorUtil.getCSVFromUserData(user));
        return null;
    }
}
