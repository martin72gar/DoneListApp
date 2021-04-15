package com.martinsiregar.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.martinsiregar.donelistapp.Model.PostUser;
import com.martinsiregar.donelistapp.Rest.ApiClient;
import com.martinsiregar.donelistapp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText textEmail, textPassword;
    Button btnLogin;
    Intent intent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = findViewById(R.id.etEmail);
        textPassword = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        sharedPreferences.contains("email");
        sharedPreferences.contains("password");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textEmail.getText().toString();
                String pass = textPassword.getText().toString();
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

                Call<PostUser> loginCall = mApiInterface.loginUser(
                        email,
                        pass);
                loginCall.enqueue(new Callback<PostUser>() {
                    @Override
                    public void onResponse(Call<PostUser> call, Response<PostUser> response) {
                        Intent intent = new Intent(LoginActivity.this, DoneListActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<PostUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
//
//                if (email.equals("martin") && pass.equals("android")) {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("email", email);
//                    editor.putString("password", pass);
//                    editor.apply();
//                    intent = new Intent(LoginActivity.this, DoneListActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}