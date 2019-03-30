package com.ayobuataplikasi.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ayobuataplikasi.datamahasiswa.responses.ApiEndPoint;
import com.ayobuataplikasi.datamahasiswa.responses.Mhs;
import com.ayobuataplikasi.datamahasiswa.responses.ReadResponse;
import com.ayobuataplikasi.datamahasiswa.service.ApiClient;

import java.security.SecureRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private Mhs mhs;
    private EditText nama, fakultas, jurusan, prodi, seleksi;
    private TextView nim;
    private Button update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_edit);

        Intent intent = getIntent();
        mhs = (Mhs) intent.getSerializableExtra("mhs");

        nim = findViewById(R.id.tv_nim);
        nama = findViewById(R.id.et_nama);
        fakultas = findViewById(R.id.et_fakultas);
        jurusan = findViewById(R.id.et_jurusan);
        prodi = findViewById(R.id.et_prodi);
        seleksi = findViewById(R.id.et_seleksi);

        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);

        nim.setText(mhs.getNim());
        nama.setText(mhs.getNama());
        fakultas.setText(mhs.getFakultas());
        jurusan.setText(mhs.getJurusan());
        prodi.setText(mhs.getProdi());
        seleksi.setText(mhs.getSeleksi());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePerson();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePerson();
            }
        });
    }

    private void deletePerson() {
        final String key = "delete";

        String d_nim = nim.getText().toString();

        ApiEndPoint apiEndPoint = ApiClient.getClient().create(ApiEndPoint.class);
        Call<ReadResponse> call = apiEndPoint.deleteRequest(key, d_nim);

        call.enqueue(new Callback<ReadResponse>() {
            @Override
            public void onResponse(Call<ReadResponse> call, Response<ReadResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("api delete", response.body().toString());

                    boolean status = response.body().getStatus();

                    if (status) {
                        Toast.makeText(DetailActivity.this, "Delete Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<ReadResponse> call, Throwable t) {

            }
        });
    }

    private void updatePerson() {
        final String key = "update";

        String u_nim = nim.getText().toString();
        String u_nama = nama.getText().toString();
        String u_fakultas = fakultas.getText().toString();
        String u_jurusan = jurusan.getText().toString();
        String u_prodi = prodi.getText().toString();
        String u_seleksi = seleksi.getText().toString();

        ApiEndPoint apiEndPoint = ApiClient.getClient().create(ApiEndPoint.class);
        Call<ReadResponse> call = apiEndPoint.updateRequest(key ,u_nim, u_nama, u_fakultas, u_jurusan, u_prodi, u_seleksi);

        call.enqueue(new Callback<ReadResponse>() {
            @Override
            public void onResponse(Call<ReadResponse> call, Response<ReadResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("api update", response.body().toString());

                    boolean status = response.body().getStatus();

                    if (status) {
                        Toast.makeText(DetailActivity.this, "Update Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<ReadResponse> call, Throwable t) {

            }
        });
    }
}
