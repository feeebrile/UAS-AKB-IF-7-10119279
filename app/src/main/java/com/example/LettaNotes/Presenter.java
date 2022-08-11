package com.example.LettaNotes;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


public interface Presenter <T extends View>{

    void onAttach(T view);
    void onDetach();

}
