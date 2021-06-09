package com.sibsutis.bachelor.diploma.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class InternalApiAnswer {
    private String answer;
    private Float prob;
}
