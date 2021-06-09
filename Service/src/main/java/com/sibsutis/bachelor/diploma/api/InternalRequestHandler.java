package com.sibsutis.bachelor.diploma.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sibsutis.bachelor.diploma.api.entities.InternalApiAnswer;
import com.sibsutis.bachelor.diploma.api.entities.RawRequestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
@Slf4j
public class InternalRequestHandler {
    public static JsonNode predictorRequest(String username) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "http://localhost:8097/predictFakeUser/"+username+",0";
        url = new String(url.getBytes(), StandardCharsets.UTF_8);
        log.error(url);
        log.error(restTemplate.exchange(url, HttpMethod.POST, entity,String.class).getBody());
        try {
            return objectMapper.readValue(restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody(), JsonNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
