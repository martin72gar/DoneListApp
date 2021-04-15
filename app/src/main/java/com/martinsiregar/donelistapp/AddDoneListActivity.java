package com.martinsiregar.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.martinsiregar.donelistapp.Model.PostDonelist;
import com.martinsiregar.donelistapp.Model.SendKontak;
import com.martinsiregar.donelistapp.Rest.ApiClient;
import com.martinsiregar.donelistapp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDoneListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_done_list);

        EditText etDonelist = findViewById(R.id.etDoneList);
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Button btnAdd = findViewById(R.id.btnAddDoneList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostDonelist> postDonelistCall = mApiInterface.postDonelist(etDonelist.getText().toString());
                postDonelistCall.enqueue(new Callback<PostDonelist>() {
                    @Override
                    public void onResponse(Call<PostDonelist> call, Response<PostDonelist> response) {
                        DoneListActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostDonelist> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}