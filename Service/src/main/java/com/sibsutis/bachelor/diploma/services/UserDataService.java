package com.sibsutis.bachelor.diploma.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.sibsutis.bachelor.diploma.api.DefaultUserDataHandler;
import com.sibsutis.bachelor.diploma.api.InternalRequestHandler;
import com.sibsutis.bachelor.diploma.dao.UsersRepository;
import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import com.sibsutis.bachelor.diploma.entity.InternalUser;
import com.sibsutis.bachelor.diploma.utils.PythonPredictorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDataService {
    private DefaultUserDataHandler defaultUserDataHandler;
    private InternalRequestHandler botApi;
    @Autowired
    private UsersRepository usersRepository;

    public JsonNode predictByUserLink(String userLink){
        ExternalUser user = DefaultUserDataHandler.getUserDataWA(userLink);
        JsonNode answer = InternalRequestHandler.predictorRequest(PythonPredictorUtil.getCSVFromUserData(user));
        usersRepository.save(new InternalUser(userLink,answer.findValue("answer").asBoolean(),answer.findValue("prob").asText()));
        log.info(PythonPredictorUtil.getCSVFromUserData(user));
        return answer;
    }
}
