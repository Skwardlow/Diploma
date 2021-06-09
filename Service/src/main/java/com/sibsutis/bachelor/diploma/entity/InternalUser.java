package com.sibsutis.bachelor.diploma.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class InternalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private Boolean answer;
    private String prob;

    public InternalUser(String username, Boolean answer, String prob){
        this.username = username;
        this.answer = answer;
        this.prob = prob;
    }

    public String toJsonStringForCarousel(){
        String buf = this.answer?"Бот":"Не Бот";
        return "{\"username\":\""+username+"\",\"answer\":\""+buf+"\"}";
    }
}
