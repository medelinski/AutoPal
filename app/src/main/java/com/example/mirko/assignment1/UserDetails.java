package com.example.mirko.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by medelinski8813 on 11/29/2017.
 */

@Entity(tableName = "userDetails",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)

public class UserDetails {
    @PrimaryKey(autoGenerate = true)
    long id;

    public long userId;

    String description;

    public UserDetails(long userId, String description) {
        this.userId = userId;
        this.description = description;
    }
}
