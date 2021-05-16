package com.sibsutis.bachelor.diploma.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawUserData {
    private String profile_pic_url;
    private String username;
    private String full_name;
    private String biography;
    private String external_url;
    private Boolean is_private;
    private EdgePosts edge_owner_to_timeline_media;
    private EdgeFollowed edge_followed_by;
    private EdgeFollow edge_follow;

}
