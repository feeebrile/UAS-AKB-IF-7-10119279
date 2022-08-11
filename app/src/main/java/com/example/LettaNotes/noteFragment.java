package com.example.LettaNotes;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class noteFragment extends Fragment {

    /* Deklarasi variable */
    private FloatingActionButton add_btn;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private ArrayList<Note> listTask = new ArrayList<>();
    private SQLite helper;

    @Nullable
    @Override
    /*Fungsi membuat view dan menampilkan data*/
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_note, container, false);

        add_btn = root.findViewById(R.id.btn_add);
        listView = root.findViewById(R.id.listView);

        helper = new SQLite(this.getActivity());

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreateNoteActivity.class));
            }
        });

        showData();

        return root;
    }

    /*Fungsi menampilkan data*/
    public void showData() {
        listTask.clear();
        Cursor res = helper.getAllData();
        while (res.moveToNext()) {
            String id = res.getString(0);
            String judul = res.getString(1);
            String isi = res.getString(2);
            String date = res.getString(3);
            String month = res.getString(4);
            String year = res.getString(5);

            listTask.add(new Note(id, judul, isi, date, month, year));
        }

        listViewAdapter = new ListViewAdapter(listTask, getActivity());
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }

}