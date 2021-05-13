package com.sibsutis.bachelor.diploma.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Slf4j
public class InternalApi {

    @RequestMapping(value = "/parse_user", method = RequestMethod.POST)
    public Boolean parseUserInfo(@RequestBody String object){
        return true;
    }

    @RequestMapping(value = "get_prediction", method = RequestMethod.POST)
    public Boolean getFakePrediction(@RequestBody String object){
        return false;
    }
}
