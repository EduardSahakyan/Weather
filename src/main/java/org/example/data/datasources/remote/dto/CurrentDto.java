package org.example.data.datasources.remote.dto;

import com.google.gson.annotations.SerializedName;

public class CurrentDto {

    @SerializedName("temp_c")
    private Double tempC;
    @SerializedName("temp_f")
    private Double tempF;
    private ConditionDto condition;

    public Double getTempC() {
        return tempC;
    }

    public Double getTempF() {
        return tempF;
    }

    public ConditionDto getCondition() {
        return condition;
    }
}
