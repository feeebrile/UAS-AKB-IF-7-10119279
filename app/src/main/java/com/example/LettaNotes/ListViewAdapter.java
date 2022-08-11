package com.example.LettaNotes;

/**
 * NIM      : 10119279
 * Nama     : Martua Febrianto
 * Kelas    : IF-7
 */


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Note> listNote;
    private Context context;
    private TextView judul, date, month, year, isi;
    private ImageView opt;
    private Button edit_btn, delete_btn;
    private SQLite helper;


    public ListViewAdapter(List<Note> listNote, Context context) {
        this.listNote = listNote;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listNote.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public android.view.View getView(int position, android.view.View convertView, ViewGroup parent) {
        android.view.View view = LayoutInflater.from(context).inflate(R.layout.note_card,null);


        judul = view.findViewById(R.id.card_Judul);
        date = view.findViewById(R.id.card_date);
        month = view.findViewById(R.id.card_month);
        year = view.findViewById(R.id.card_year);
        isi = view.findViewById(R.id.card_isi);
        opt = view.findViewById(R.id.options);
        helper = new SQLite(view.getContext());

        judul.setText(listNote.get(position).getJudul());
        date.setText(listNote.get(position).getDate());
        month.setText(listNote.get(position).getMonth());
        isi.setText(listNote.get(position).getIsi());
        String id = listNote.get(position).getId();

        opt.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(view.getContext(), v);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuDelete:
                                Toast.makeText(view.getContext(),"Catatan berhasil dihapus", Toast.LENGTH_SHORT).show();
                                helper.deteleData(id);
                                listNote.remove(position);
                                notifyDataSetChanged();
                                return true;
                            case R.id.menuUpdate:
                                Intent intent = new Intent(context, EditNoteActivity.class);
                                intent.putExtra("Id", listNote.get(position).getId());
                                intent.putExtra("Judul", listNote.get(position).getJudul());
                                intent.putExtra("Isi", listNote.get(position).getIsi());
                                intent.putExtra("Date", listNote.get(position).getDate());
                                intent.putExtra("Month", listNote.get(position).getMonth());
                                intent.putExtra("Year", listNote.get(position).getYear());

                                context.startActivity(intent);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.inflate(R.menu.menu);
                popup.show();
            }

        });
        return view;
    }


}
