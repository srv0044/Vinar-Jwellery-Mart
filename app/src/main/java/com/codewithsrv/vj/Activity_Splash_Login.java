package com.codewithsrv.vj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_Splash_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_login);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText loginEmail=findViewById(R.id.login_email);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final EditText loginPassword=findViewById(R.id.login_password);

        final Button loginBtn=findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Bottom_Nav.class);
                startActivity(intent);
            }
        });

        final TextView registerClick=findViewById(R.id.tv_register);
        registerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Splash_Login.this,Activity_Registeration.class);
                startActivity(intent);

            }
        });

    }
}