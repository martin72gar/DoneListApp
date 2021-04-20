package com.martinsiregar.donelistapp.Model;

import com.google.gson.annotations.SerializedName;

public class PostUser {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("result")
    User result;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public User getResult() {return result;}
    public void setResult(User user) {
        this.result = user;
    }
}
