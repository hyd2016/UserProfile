package com.example.hotsoon_user_profiiles.Json;
import com.google.gson.annotations.SerializedName;


/**
 * author: zhangxin
 * time: 2019-08-09
 */

class UserSocialRelation{

    @SerializedName("relation_type")
    private String relationType;

    @SerializedName("text")
   private String text;

    @SerializedName("users")
    private String users;
}
