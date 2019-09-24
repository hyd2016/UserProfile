package com.example.hotsoon_user_profiiles.Json;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shilei on 16/2/19.
 */
public class UserStats {
    @SerializedName("id")
    private long id;

    @SerializedName("item_count")
    private int publishCount;

    @SerializedName("record_count")
    private int recordCount;

    @SerializedName("following_count")
    private int followingCount;

    @SerializedName("follower_count")
    private int followerCount;

    @SerializedName("diamond_consumed_count")
    private long diamondConsumedCount;

    @SerializedName("total_duration")
    private long totalDuration;

    @SerializedName("daily_fan_ticket_count")
    private int dailFanTicketCount;

    @SerializedName("daily_income")
    private int dailyIncome;

    @SerializedName("favorite_item_count")
    private int favoriteItemCount;


    @SerializedName("circle_item_count")
    private int circleItemCount;  //圈子作品数量


    public int getDailFanTicketCount() {
        return dailFanTicketCount;
    }

    public void setDailFanTicketCount(int dailFanTicketCount) {
        this.dailFanTicketCount = dailFanTicketCount;
    }

    public int getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(int dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getDiamondConsumedCount() {
        return diamondConsumedCount;
    }

    public void setDiamondConsumedCount(long diamondConsumedCount) {
        this.diamondConsumedCount = diamondConsumedCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(int publishCount) {
        this.publishCount = publishCount;
    }

    public int getFavoriteItemCount() {
        return favoriteItemCount;
    }

    public void setFavoriteItemCount(int favoriteItemCount) {
        this.favoriteItemCount = favoriteItemCount;
    }

    public int getCircleItemCount() {
        return circleItemCount;
    }

    public void setCircleItemCount(int circleItemCount) {
        this.circleItemCount = circleItemCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserStats userStats = (UserStats) o;

        if (id != userStats.id) {
            return false;
        }
        if (publishCount != userStats.publishCount) {
            return false;
        }
        if (recordCount != userStats.recordCount) {
            return false;
        }
        if (followingCount != userStats.followingCount) {
            return false;
        }
        if (followerCount != userStats.followerCount) {
            return false;
        }
        if (diamondConsumedCount != userStats.diamondConsumedCount) {
            return false;
        }
        if (totalDuration != userStats.totalDuration) {
            return false;
        }
        if (dailFanTicketCount != userStats.dailFanTicketCount) {
            return false;
        }
        if (dailyIncome != userStats.dailyIncome) {
            return false;
        }
        if (circleItemCount != userStats.circleItemCount) {
            return false;
        }
        return favoriteItemCount == userStats.favoriteItemCount;
    }

}
