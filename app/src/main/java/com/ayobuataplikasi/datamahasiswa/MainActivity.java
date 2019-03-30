package com.ayobuataplikasi.datamahasiswa;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ayobuataplikasi.datamahasiswa.adapter.MhsItemAdapter;
import com.ayobuataplikasi.datamahasiswa.responses.ApiEndPoint;
import com.ayobuataplikasi.datamahasiswa.responses.Mhs;
import com.ayobuataplikasi.datamahasiswa.responses.ReadResponse;
import com.ayobuataplikasi.datamahasiswa.service.ApiClient;

import java.security.SecureRandom;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Mhs> list;
    private MhsItemAdapter mhsItemAdapter;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_mhs_list);
        floatingActionButton = findViewById(R.id.fab);

        getAllPerson();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("mhs", list.get(i));
                startActivity(intent);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getAllPerson() {
        final String key = "read_all";

        ApiEndPoint apiEndPoint = ApiClient.getClient().create(ApiEndPoint.class);
        Call<ReadResponse> call = apiEndPoint.readAllRequest(key);

        call.enqueue(new Callback<ReadResponse>() {
            @Override
            public void onResponse(Call<ReadResponse> call, Response<ReadResponse> response) {

                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());

                    boolean status = response.body().getStatus();

                    if (status) {
                        //tampung data response ke variable
                        list = response.body().getMhs();
                        //buat adapter untuk list view
                        mhsItemAdapter = new MhsItemAdapter(MainActivity.this, list);
                        listView.setAdapter(mhsItemAdapter);
                    }

                }

            }

            @Override
            public void onFailure(Call<ReadResponse> call, Throwable t) {

            }
        });
    }
}
