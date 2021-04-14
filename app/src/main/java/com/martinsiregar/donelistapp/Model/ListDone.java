package com.martinsiregar.donelistapp.Model;

import com.google.gson.annotations.SerializedName;

public class ListDone {
    @SerializedName("id")
    private String id;
    @SerializedName("listname")
    private String listname;

    public ListDone(){}

    public ListDone(String id, String nama, String nomor) {
        this.id = id;
        this.listname = listname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return listname;
    }

    public void setNama(String nama) {
        this.listname = listname;
    }
}
