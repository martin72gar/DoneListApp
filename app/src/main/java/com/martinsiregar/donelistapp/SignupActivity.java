package com.martinsiregar.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.martinsiregar.donelistapp.Adapter.DoneListAdapter;
import com.martinsiregar.donelistapp.Model.GetList;
import com.martinsiregar.donelistapp.Model.ListDone;
import com.martinsiregar.donelistapp.Model.PostUser;
import com.martinsiregar.donelistapp.Model.User;
import com.martinsiregar.donelistapp.Rest.ApiClient;
import com.martinsiregar.donelistapp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText etNama = findViewById(R.id.etNama);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPass = findViewById(R.id.etPass);
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Button btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostUser> postUserCall = mApiInterface.postUser(
                        etNama.getText().toString(),
                        etEmail.getText().toString(),
                        etPass.getText().toString());
                postUserCall.enqueue(new Callback<PostUser>() {
                    @Override
                    public void onResponse(Call<PostUser> call, Response<PostUser> response) {
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "User berhasil dibuat", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<PostUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}