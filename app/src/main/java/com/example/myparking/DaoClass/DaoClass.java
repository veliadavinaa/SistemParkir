package com.example.myparking.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myparking.EntityClass.UserModel;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    //Select All Data
    @Query("select * from inputdata")
    List<UserModel> getAllData();
}
