package com.ayobuataplikasi.datamahasiswa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ayobuataplikasi.datamahasiswa.R;
import com.ayobuataplikasi.datamahasiswa.responses.Mhs;

import java.util.List;

public class MhsItemAdapter extends ArrayAdapter<Mhs> {

    private List<Mhs> list;
    private Context context;
    private LayoutInflater layoutInflater;


    public MhsItemAdapter(@NonNull Context context, @NonNull List<Mhs> list) {
        super(context, R.layout.item_mhs, list);
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Mhs getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = layoutInflater.inflate(R.layout.item_mhs, null);

        TextView nim = view.findViewById(R.id.tv_nim);
        TextView nama = view.findViewById(R.id.tv_nama);
        TextView fakultas = view.findViewById(R.id.tv_fakultas);
        TextView jurusan = view.findViewById(R.id.tv_jurusan);
        TextView prodi = view.findViewById(R.id.tv_prodi);
        TextView seleksi = view.findViewById(R.id.tv_seleksi);

        Mhs mhs = getItem(position);

        //beri nilai ke person_item layout
        nim.setText("NIM : " + mhs.getNim());
        nama.setText("Nama : " + mhs.getNama());
        fakultas.setText("Fakultas : " + mhs.getFakultas());
        jurusan.setText("Jurusan : " + mhs.getJurusan());
        prodi.setText("Prodi : " + mhs.getProdi());
        seleksi.setText("Seleksi : " + mhs.getSeleksi());

        return view;
    }
}
