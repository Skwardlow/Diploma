package com.sibsutis.bachelor.diploma.entity;

import com.sibsutis.bachelor.diploma.api.entities.RawUserData;
import com.sibsutis.bachelor.diploma.utils.UserUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExternalUser {

    private String profile_pic;
    private String username;
    private Float numsLength_username;
    private Integer fullname_words;
    private Float numsLength_fullname;
    private String fullname;
    private String description;
    private String external_url;
    private Boolean is_private;
    private Integer posts_count;
    private Integer followers_count;
    private Integer follows_count;

    public ExternalUser(RawUserData userData){
        this.profile_pic = userData.getProfile_pic_url();
        this.username = userData.getUsername();
        this.numsLength_username = UserUtils.getNumsRatio(userData.getUsername());
        this.fullname_words = UserUtils.getWordsCount(userData.getFull_name());
        this.numsLength_fullname = UserUtils.getNumsRatio(userData.getFull_name());
        this.fullname = userData.getFull_name();
        this.description = userData.getBiography();
        this.external_url = userData.getExternal_url();
        this.is_private = userData.getIs_private();
        this.posts_count = userData.getEdge_owner_to_timeline_media().getCount();
        this.followers_count = userData.getEdge_followed_by().getCount();
        this.follows_count = userData.getEdge_follow().getCount();
    }

}
