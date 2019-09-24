package com.example.hotsoon_user_profiiles.Json;

import com.google.gson.annotations.SerializedName;

/**
 * 用户作品信息数据
 */

public class ProductionData {
    @SerializedName("stats")
    private ProductionStats productionStats;

    @SerializedName("video")
    private UserVideo userVideo;

    @SerializedName("song")
    private Song song;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductionStats getProductionStats() {
        return productionStats;
    }

    public void setProductionStats(ProductionStats productionStats) {
        this.productionStats = productionStats;
    }

    public UserVideo getUserVideo() {
        return userVideo;
    }

    public void setUserVideo(UserVideo userVideo) {
        this.userVideo = userVideo;
    }
}
