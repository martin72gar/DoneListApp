package com.martinsiregar.donelistapp.Rest;


/**
 * Created by root on 2/3/17.
 */


import com.martinsiregar.donelistapp.Model.GetKontak;
import com.martinsiregar.donelistapp.Model.GetList;
import com.martinsiregar.donelistapp.Model.SendKontak;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("kontak_android")
    Call<GetKontak> getKontak();

    @GET("donelist")
    Call<GetList> getListDone();

    @FormUrlEncoded
    @POST("kontak")
    Call<SendKontak> postKontak(@Field("nama") String nama,
                                @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("kontak")
    Call<SendKontak> putKontak(@Field("id") String id,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<SendKontak> deleteKontak(@Field("id") String id);
}