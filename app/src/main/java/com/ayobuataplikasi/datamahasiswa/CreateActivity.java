package com.ayobuataplikasi.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayobuataplikasi.datamahasiswa.responses.ApiEndPoint;
import com.ayobuataplikasi.datamahasiswa.responses.ReadResponse;
import com.ayobuataplikasi.datamahasiswa.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    private EditText nim, nama, fakultas, jurusan, prodi, seleksi;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        nim = findViewById(R.id.et_nim);
        nama = findViewById(R.id.et_nama);
        fakultas = findViewById(R.id.et_fakultas);
        jurusan = findViewById(R.id.et_jurusan);
        prodi = findViewById(R.id.et_prodi);
        seleksi = findViewById(R.id.et_seleksi);

        create = findViewById(R.id.btn_create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPerson();
            }
        });

    }

    private void createPerson() {
        final String key = "create";

        String c_nim = nim.getText().toString();
        String c_nama = nama.getText().toString();
        String c_fakultas = fakultas.getText().toString();
        String c_jurusan = jurusan.getText().toString();
        String c_prodi = prodi.getText().toString();
        String c_seleksi = seleksi.getText().toString();

        ApiEndPoint apiEndPoint = ApiClient.getClient().create(ApiEndPoint.class);
        Call<ReadResponse> call = apiEndPoint.createRequest(key, c_nim, c_nama, c_fakultas, c_jurusan, c_prodi, c_seleksi);

        call.enqueue(new Callback<ReadResponse>() {
            @Override
            public void onResponse(Call<ReadResponse> call, Response<ReadResponse> response) {
                Log.d("api create", response.body().toString());

                boolean status = response.body().getStatus();

                if (status) {
                    Toast.makeText(CreateActivity.this, "Berhasil Upload Data Baru", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ReadResponse> call, Throwable t) {

            }
        });

    }
}
