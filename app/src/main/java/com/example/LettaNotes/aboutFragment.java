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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class aboutFragment extends Fragment {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        viewPager = root.findViewById(R.id.pager);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Fragment> list = new ArrayList<>();
        list.add(new FirstAboutFragment());
        list.add(new SecondAboutFragment());
        list.add(new ThirdAboutFragment());

        pagerAdapter = new AboutViewModel(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }

}