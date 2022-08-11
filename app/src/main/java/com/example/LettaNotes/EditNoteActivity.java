package com.example.LettaNotes;


/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EditNoteActivity extends AppCompatActivity {

    /* Deklarasi variable */
    private EditText judul_et, isi_et;
    private Date date;
    private SimpleDateFormat dateFormat, monthFormat, yearFormat;
    private Button submit_btn;
    private SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_form); /*Memanggil tampilan form*/

        Bundle bundle = getIntent().getExtras();

        /*Deklrasi tanggal*/
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        monthFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        /*Deklrasi button*/
        submit_btn = findViewById(R.id.btn_submit);
        judul_et = findViewById(R.id.et_judul);
        isi_et = findViewById(R.id.et_isi);

        judul_et.setText(bundle.getString("Judul"));
        isi_et.setText(bundle.getString("Isi"));

        /*Deklarasi SQLite sebagai variabel baru*/
        helper = new SQLite(this);

        /*Fungsi ketika button submit dipencet*/
        submit_btn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = bundle.getString("Id");
                String judul = judul_et.getText().toString();
                String isi = isi_et.getText().toString();
                String formattedDate = dateFormat.format(date);
                String formattedMonth = monthFormat.format(date);
                String formattedYear = yearFormat.format(date);

                if (TextUtils.isEmpty(judul)) {
                    judul_et.setError("Data tidak boleh kosong");
                    judul_et.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    isi_et.setError("Data tidak boleh kosong");
                    isi_et.requestFocus();
                } else {
                    boolean isSuccess = helper.updateData(id, judul, isi, formattedDate, formattedMonth, formattedYear);

                    if (isSuccess) {
                        Toast.makeText(EditNoteActivity.this, "Catatan berhasil diubah", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(EditNoteActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(EditNoteActivity.this, "Catatan gagal diubah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
