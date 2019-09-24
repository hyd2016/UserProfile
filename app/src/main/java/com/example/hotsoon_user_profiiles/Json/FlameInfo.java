package com.example.hotsoon_user_profiiles.Json;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * created by liudeyu and the date is 2019/5/9
 */
public class FlameInfo {
    @SerializedName("top_contributors")
    private List<User> topContributors;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String des;

    @SerializedName("title_flame")
    private String titleFlameNoUserList;



    public String getTitleFlameNoUserList() {
        return titleFlameNoUserList;
    }

    public void setTitleFlameNoUserList(String titleFlameNoUserList) {
        this.titleFlameNoUserList = titleFlameNoUserList;
    }

    public List<User> getTopContributors() {
        return topContributors;
    }

    public void setTopContributors(List<User> topContributors) {
        this.topContributors = topContributors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
