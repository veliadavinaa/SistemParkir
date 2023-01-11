package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myparking.EntityClass.UserModel;


public class MainActivity extends AppCompatActivity {
    EditText kodelahan, namalengkap, merkmobil, warnamobil, platnomor;
    Button simpan,getData, Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kodelahan=findViewById(R.id.kodelahan);
        namalengkap=findViewById(R.id.namalengkap);
        merkmobil=findViewById(R.id.merkmobil);
        warnamobil=findViewById(R.id.warnamobil);
        platnomor=findViewById(R.id.platnomor);
        simpan=findViewById(R.id.btn_simpan);
        getData=findViewById(R.id.btn_getData);
        Data=findViewById(R.id.btn_data);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

            }
        });

        Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DataParkir.class));
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GetData.class));
            }
        });

    }

    private void saveData()
    {
        String kdlahan_txt = kodelahan.getText().toString().trim();
        String nama_txt = namalengkap.getText().toString().trim();
        String merkmbl_txt = merkmobil.getText().toString().trim();
        String warnambl_txt = warnamobil.getText().toString().trim();
        String plat_txt = platnomor.getText().toString().trim();

            UserModel model=new UserModel();

            model.setKd_lahan(kdlahan_txt);
            model.setNmpemilik(nama_txt);
            model.setMerkmobil(merkmbl_txt);
            model.setWarnamobil(warnambl_txt);
            model.setPlatnomor(plat_txt);

            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(model);

            kodelahan.setText("");
            namalengkap.setText("");
            merkmobil.setText("");
            warnamobil.setText("");
            platnomor.setText("");

            Toast.makeText(this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();
        }

    }
