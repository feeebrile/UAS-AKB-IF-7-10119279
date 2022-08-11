package com.example.LettaNotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class daftar extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText eT_email, eT_kataSandi;
    private Button btn_daftar;
    private ImageButton imgBtn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        mAuth = FirebaseAuth.getInstance();
        eT_email = findViewById(R.id.eT_daftar_email);
        eT_kataSandi = findViewById(R.id.eT_daftar_kataSandi);
        btn_daftar = findViewById(R.id.btn_daftar_daftar);
        imgBtn_back = findViewById(R.id.imgBtn_daftar_kembali);

        btn_daftar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        imgBtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(daftar.this, login.class));
            }
        });



    }

    private void Register(){
        String user = eT_email.getText().toString().trim();
        String pass = eT_kataSandi.getText().toString().trim();

        if (user.isEmpty()){
            eT_email.setError("Email can not be empty..");
        }if(pass.isEmpty()){
            eT_kataSandi.setError("Password can not be empty");
        }else{
            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(daftar.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(daftar.this, MainActivity.class));
                    }else{
                        Toast.makeText(daftar.this,"Registration Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}