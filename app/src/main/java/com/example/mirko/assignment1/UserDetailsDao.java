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
    void addUserDetails(UserDetails userDetails);

    @Query("SELECT * FROM userDetails WHERE userId=:userId")
    List<UserDetails> findUserDetailsForUser(int userId);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUserDetails(UserDetails userDetails);

    @Query("delete from userDetails where id = :id")
    void delete(long id);
}
