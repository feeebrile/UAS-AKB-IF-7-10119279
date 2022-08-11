package com.example.LettaNotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText eT_email, eT_kataSandi;
    private Button btn_masuk;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        eT_email = findViewById(R.id.eT_login_email);
        eT_kataSandi = findViewById(R.id.eT_login_kataSandi);
        btnDaftar = findViewById(R.id.btn_login_daftar);
        btn_masuk = findViewById(R.id.btn_login_masuk);

        btn_masuk.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                login();
            }
        });

        btnDaftar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(login.this, daftar.class));
            }
        });




    }


    private void login(){
        String user = eT_email.getText().toString().trim();
        String pass = eT_kataSandi.getText().toString().trim();

        if (user.isEmpty()){
            eT_email.setError("Email can not be empty..");
        }if(pass.isEmpty()){
            eT_kataSandi.setError("Password can not be empty");
        }else{
            mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login.this,"Login Successfully..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, MainActivity.class));
                    }else{
                        Toast.makeText(login.this,"Login Failed!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

}