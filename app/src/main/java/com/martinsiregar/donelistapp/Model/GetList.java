package com.martinsiregar.donelistapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetList {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<ListDone> listDonelist;
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
    public List<ListDone> getListDataDone() {
        return listDonelist;
    }
    public void setListDataKontak(List<ListDone> listDonelist) {
        this.listDonelist = listDonelist;
    }
}
