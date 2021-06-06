package com.sibsutis.bachelor.diploma.controller;

import com.sibsutis.bachelor.diploma.services.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Slf4j
public class InternalApi {
    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/parse_user", method = RequestMethod.POST)
    public Boolean parseUserInfo(@RequestBody String object){
        log.info(object);
        return true;
    }

    @RequestMapping(value = "/get_prediction", method = RequestMethod.GET)
    public Float getFakePrediction(){
        userDataService.predictByUserLink("nasa");
        return 0.00f;
    }
}
