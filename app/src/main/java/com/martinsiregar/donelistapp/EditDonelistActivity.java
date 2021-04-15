package com.martinsiregar.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.martinsiregar.donelistapp.Model.PostDonelist;
import com.martinsiregar.donelistapp.Rest.ApiClient;
import com.martinsiregar.donelistapp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDonelistActivity extends AppCompatActivity {
    EditText edtId, edtNama;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_donelist);

        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostDonelist> updateDonelistCall = mApiInterface.putDonelist(
                        edtNama.getText().toString());
                updateDonelistCall.enqueue(new Callback<PostDonelist>() {
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
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostDonelist> deleteDonelist = mApiInterface.deleteDonelist(edtId.getText().toString());
                    deleteDonelist.enqueue(new Callback<PostDonelist>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoneListActivity.ma.refresh();
                finish();
            }
        });
    }
}