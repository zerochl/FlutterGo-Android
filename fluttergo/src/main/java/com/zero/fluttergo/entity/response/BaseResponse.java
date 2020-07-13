package com.zero.fluttergo.entity.response;

import com.zero.gson.annotations.SerializedName;

public class BaseResponse <T> {
    @SerializedName("result_code")
    private int resultCode;
    @SerializedName("result_message")
    private String resultMessage;
    @SerializedName("result_data")
    private T resultData;

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public T getResultData() {
        return resultData;
    }
}
