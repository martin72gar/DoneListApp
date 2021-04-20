package com.martinsiregar.donelistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.martinsiregar.donelistapp.Adapter.DoneListAdapter;
import com.martinsiregar.donelistapp.Model.GetList;
import com.martinsiregar.donelistapp.Model.ListDone;
import com.martinsiregar.donelistapp.Rest.ApiClient;
import com.martinsiregar.donelistapp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DoneListActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DoneListActivity ma;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_list);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", null);
        String name = sharedPreferences.getString("name", "and welcome");

        TextView labelName = findViewById(R.id.tvName);
        labelName.setText(email);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoneListActivity.this, AddDoneListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void refresh() {
        Call<GetList> donelistCall = mApiInterface.getListDone();
        donelistCall.enqueue(new Callback<GetList>() {
            @Override
            public void onResponse(Call<GetList> call, Response<GetList>
                    response) {
                List<ListDone> DoneList = response.body().getListDataDone();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(DoneList.size()));
                mAdapter = new DoneListAdapter(DoneList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetList> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}