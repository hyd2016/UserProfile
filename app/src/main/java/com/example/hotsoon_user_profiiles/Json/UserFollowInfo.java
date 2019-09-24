package com.example.hotsoon_user_profiiles.Json;


import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangxin on 2018/12/19.
 * 返回我的关注,关注我的,相互关注的数量
 */
public class UserFollowInfo {

    private static final int SHIFT = 31;


    @SerializedName("followings")
    public int followings;


    @SerializedName("followers")
    public int followers;


    @SerializedName("friends")
    public int friends;

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserFollowInfo that = (UserFollowInfo) o;
        return followings == that.followings
                && followers == that.followers
                && friends == that.friends;
    }

    @Override
    public int hashCode() {
        int result = (followings ^ (followings >>> SHIFT));
        result = SHIFT * result + followers;
        result = SHIFT * result + friends;
        return result;
    }
}
