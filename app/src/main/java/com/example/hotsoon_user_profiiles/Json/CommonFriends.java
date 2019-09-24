package com.example.hotsoon_user_profiiles.Json;




import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pengzipei on 2017/11/9.
 */

public class CommonFriends {
    @SerializedName("total")
    private int total;

    @SerializedName("friends")
    private List<String> friendsList;
    private static final int HASH_CODE_PARAM = 31;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<String> friendsList) {
        this.friendsList = friendsList;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommonFriends that = (CommonFriends) o;

        if (total != that.total) {
            return false;
        }
        return friendsList != null ? friendsList.equals(that.friendsList) : that.friendsList == null;
    }

    @Override
    public int hashCode() {
        int result = total;
        result = HASH_CODE_PARAM * result + (friendsList != null ? friendsList.hashCode() : 0);
        return result;
    }
}
