package com.sibsutis.bachelor.diploma.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.sibsutis.bachelor.diploma.services.InternalUserService;
import com.sibsutis.bachelor.diploma.services.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Slf4j
public class InternalApi {
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private InternalUserService internalUserService;

    @PostMapping(value = "/parse_user")
    @ResponseBody
    public JsonNode parseUserInfo(@RequestParam(name = "username") String username){
        JsonNode answer = userDataService.predictByUserLink(username);
        log.info(username);
        log.info(answer.asText());
        return answer;
    }
    @GetMapping(value = "/get_previous")
    @ResponseBody
    public JsonNode getPreviousUsers(){
        return internalUserService.findLastFiveUsers();
    }
}
