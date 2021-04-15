package com.martinsiregar.donelistapp.Model;

import com.google.gson.annotations.SerializedName;

public class PostDonelist {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Donelist mDonelist;
    @SerializedName("message")
    String message;
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
    public Donelist getDonelist() {
        return mDonelist;
    }
    public void setDonelistt(Donelist donelist) {
        mDonelist = donelist;
    }
}
