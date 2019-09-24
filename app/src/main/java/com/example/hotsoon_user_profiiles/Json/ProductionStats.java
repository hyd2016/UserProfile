package com.example.hotsoon_user_profiiles.Json;

import com.google.gson.annotations.SerializedName;

public class ProductionStats {
    @SerializedName("digg_count")
    private String diggCount;

    public String getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(String diggCount) {
        this.diggCount = diggCount;
    }
}
