package com.example.mirko.assignment1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Mirko on 2017-12-12.
 */

@Dao
public interface CarInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCarInfo(CarInfo carInfo);

    @Query("SELECT * FROM carInfo WHERE userId=:userId")
    List<CarInfo> findTrophiesForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCarInfo(CarInfo carInfo);

    @Query("delete from carInfo where id = :id")
    void delete(long id);

}
