package com.example.hotsoon_user_profiiles.Json;



import com.google.gson.annotations.SerializedName;

/**
 * Created by dreamtale on 16/3/4.
 */
public class RoomStats{

    @SerializedName("id")
    private long id;

    @SerializedName("fan_ticket")
    private long ticket;

    @SerializedName("money")
    private long money;

    @SerializedName("total_user")
    private int totalUser;

    @SerializedName("follow_count")
    private int followCount;

    @SerializedName("gift_uv_count")
    private int giftUVCount;

    @SerializedName("user_count_composition")
    public UserComposition userComposition;

    final int INT_32 = 32;
    final int INT_31 = 31;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTicket() {
        return ticket;
    }

    public void setTicket(long ticket) {
        this.ticket = ticket;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public int getGiftUVCount() {
        return giftUVCount;
    }

    public void setGiftUVCount(int giftUVCount) {
        this.giftUVCount = giftUVCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoomStats roomStats = (RoomStats) o;

        if (id != roomStats.id) {
            return false;
        }
        if (ticket != roomStats.ticket) {
            return false;
        }
        if (money != roomStats.money) {
            return false;
        }
        if (followCount != roomStats.followCount) {
            return false;
        }
        if (giftUVCount != roomStats.giftUVCount) {
            return false;
        }
        return totalUser == roomStats.totalUser;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> INT_32));
        result = INT_31 * result + (int) (ticket ^ (ticket >>> INT_32));
        result = INT_31 * result + (int) (money ^ (money >>> INT_32));
        result = INT_31 * result + totalUser;
        result = INT_31 * result + followCount;
        result = INT_31 * result + giftUVCount;
        return result;
    }

    public class UserComposition {

        @SerializedName("city")
        public float city;

        @SerializedName("video_detail")
        public float video;
    }
}

