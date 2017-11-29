package com.example.mirko.assignment1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by medelinski8813 on 11/29/2017.
 */

@Dao
public interface UserDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTrophy(UserDetails trophy);

    @Query("SELECT * FROM trophy WHERE userId=:userId")
    List<UserDetails> findTrophiesForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTrophy(UserDetails userDetails);

    @Query("delete from trophy where id = :id")
    void delete(long id);
}
