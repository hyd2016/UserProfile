package com.example.hotsoon_user_profiiles.Util;

import android.graphics.Paint;
import android.util.Log;

import com.example.hotsoon_user_profiiles.Json.Production;
import com.example.hotsoon_user_profiiles.Json.ProductionExtra;
import com.example.hotsoon_user_profiiles.Json.RecommendUser;
import com.example.hotsoon_user_profiiles.Json.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /**
     * 处理用户json数据
     * @param response
     * @return
     */

    public static User handleUserJson(String response){
        Gson gson = new Gson();
        User user = gson.fromJson(response,User.class);
        return user;
    }

    /**
     * 处理推荐用户json数据
     * @param response
     * @return
     */

    public static List<RecommendUser> handleRecommendJson(String response){
        List<RecommendUser> recommendUserList = new ArrayList<>();

        //拿到数组
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");

        //循环遍历数组
        for (JsonElement user : jsonArray) {
            RecommendUser userBean = new Gson().fromJson(user, new TypeToken<RecommendUser>() {
            }.getType());

            recommendUserList.add(userBean);

        }

        return recommendUserList;
    }

    /**
     * 处理用户视频列表数据
     * @param
     * @return
     */

    public static void handleProductionJson(String response, List<Production> productionList){

        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");

        for(JsonElement production:jsonArray){
            Production productionBean = new Gson().fromJson(production,new TypeToken<Production>(){
            }.getType());

            productionList.add(productionBean);
        }

    }
    public static ProductionExtra handleProductionHasMore(String response){
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        Gson gson = new Gson();
        ProductionExtra productionExtra = gson.fromJson(jsonObject.getAsJsonObject("extra"), ProductionExtra.class);
        return productionExtra;

    }
}
