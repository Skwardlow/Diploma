package com.sibsutis.bachelor.diploma.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sibsutis.bachelor.diploma.dao.UsersRepository;
import com.sibsutis.bachelor.diploma.entity.InternalUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InternalUserService {
    final
    UsersRepository usersRepository;

    public InternalUserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public JsonNode findLastFiveUsers(){
        ObjectMapper om = new ObjectMapper();
        JsonNode result = null;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (InternalUser internalUser:usersRepository.findTop5ByOrderByIdDesc()) {
            sb.append(internalUser.toJsonStringForCarousel()).append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        log.info(sb.toString());
        try {
            result = om.readValue(sb.toString(), JsonNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("Ошибка при обработке коллекции из базы данных");
        }
        return result;
    }
}
