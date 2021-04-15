package com.martinsiregar.donelistapp.Model;

import com.google.gson.annotations.SerializedName;

public class Donelist {
    @SerializedName("id")
    private String id;
    @SerializedName("listname")
    private String listname;

    public Donelist(){}

    public Donelist(String id, String listname) {
        this.id = id;
        this.listname = listname;
    }
}
