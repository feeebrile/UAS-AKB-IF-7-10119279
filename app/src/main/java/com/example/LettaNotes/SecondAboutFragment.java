package com.example.LettaNotes;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondAboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondAboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_second_about, container, false);

        return root;
    }

}