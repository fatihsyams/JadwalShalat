package com.fatihsyams.jadwalshalat.response;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }
}
