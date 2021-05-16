package com.sibsutis.bachelor.diploma.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalUser {

    private String profile_pic;
    private String username;
    private Integer numsLength_username;
    private Integer fullname_words;
    private Integer numsLength_fullname;
    private String external_url;
    private Boolean is_private;
    private Integer posts_count;
    private Integer followers_count;
    private Integer follows_count;
    public ExternalUser(){

    }


}
