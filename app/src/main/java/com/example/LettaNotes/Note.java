package com.example.LettaNotes;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


public class Note {
    private String id;
    private String judul;
    private String date;
    private String month;
    private String year;
    private String isi;

    public Note(String id, String judul,String isi, String date, String month, String year) {
        this.id = id;
        this.judul = judul;
        this.isi = isi;
        this.date = date;
        this.month = month;
        this.year = year;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }
    public String getYear() {
        return year;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
