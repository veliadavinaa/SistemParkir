package com.example.myparking.EntityClass;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "inputdata")
public class UserModel {

    //Primary key
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "kd_lahan")
    private String kd_lahan;

    @ColumnInfo(name = "nmpemilik")
    private String nmpemilik;

    @ColumnInfo(name = "merkmobil")
    private String merkmobil;

    @ColumnInfo(name = "warnamobil")
    private String warnamobil;

    @ColumnInfo(name = "platnomor")
    private String platnomor;

    public int getKey() { return key; }

    public void setKey(int key) {
        this.key = key;
    }

    public String getKd_lahan() {
        return kd_lahan;
    }

    public void setKd_lahan(String kd_lahan) {
        this.kd_lahan = kd_lahan;
    }

    public String getNmpemilik() {
        return nmpemilik;
    }

    public void setNmpemilik(String nmpemilik) {
        this.nmpemilik = nmpemilik;
    }

    public String getMerkmobil() {
        return merkmobil;
    }

    public void setMerkmobil(String merkmobil) {
        this.merkmobil = merkmobil;
    }

    public String getWarnamobil() {
        return warnamobil;
    }

    public void setWarnamobil(String warnamobil) {
        this.warnamobil = warnamobil;
    }

    public String getPlatnomor() {
        return platnomor;
    }

    public void setPlatnomor(String platnomor) {
        this.platnomor = platnomor;
    }
}
