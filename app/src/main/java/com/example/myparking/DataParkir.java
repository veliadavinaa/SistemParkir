package com.example.myparking;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DataParkir extends AppCompatActivity {
    TextView nm_lokasi, nm_lokasi2, nm_lokasi3, nm_lokasi4;
    Button btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_parkir);

        nm_lokasi = findViewById(R.id.nm_lokasi);
        nm_lokasi2 = findViewById(R.id.nm_lokasi2);
        nm_lokasi3 = findViewById(R.id.nm_lokasi3);
        nm_lokasi4 = findViewById(R.id.nm_lokasi4);
        btn_kembali =findViewById(R.id.btn_kembali);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        
        TampilData();
        
    }

    private void TampilData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://localhost:3000/lahan/1";
        JSONObject jsonObject = new JSONObject();
        final String requestBody = jsonObject.toString();

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jo = new JSONObject(response.toString());
                    String lokasi = jo.getString("kodepertama");
                    String lokasi2 = jo.getString("kodekedua");
                    String lokasi3 = jo.getString("kodeketiga");
                    String lokasi4 = jo.getString("dipakai");

                    nm_lokasi.setText(lokasi);
                    nm_lokasi2.setText(lokasi2);
                    nm_lokasi3.setText(lokasi3);
                    nm_lokasi4.setText(lokasi4);
                    Toast.makeText(DataParkir.this, "Berhasil Memuat", Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DataParkir.this, "Gagal ambil REST API " + error, Toast.LENGTH_SHORT).show();
            }
        }
        );

        queue.add(stringRequest);
    }
}