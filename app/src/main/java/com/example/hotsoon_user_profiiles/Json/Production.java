package com.example.hotsoon_user_profiiles.Json;

import com.google.gson.annotations.SerializedName;

/**
 * 用户作品信息
 */

public class Production {
    public ProductionData getProductionData() {
        return productionData;
    }

    public void setProductionData(ProductionData productionData) {
        this.productionData = productionData;
    }

    @SerializedName("data")
    private ProductionData productionData;
}
