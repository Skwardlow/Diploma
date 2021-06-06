package com.sibsutis.bachelor.diploma.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sibsutis.bachelor.diploma.api.entities.RawRequestData;
import com.sibsutis.bachelor.diploma.entity.ExternalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
@Component
public class RequestHandlerWA {

    public static RawRequestData getAllUserInfoWA(String username) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://www.instagram.com/" + username + "/?__a=1";
        url = new String(url.getBytes(), StandardCharsets.UTF_8);
        //log.error(url);
        //log.error(restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody(),RawRequestData.class);
        try {
            return objectMapper.readValue(restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody(),RawRequestData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
