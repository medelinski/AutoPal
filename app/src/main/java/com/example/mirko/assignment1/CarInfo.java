package com.example.mirko.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 *
 * Created by Mirko on 2017-12-12.
 */

@Entity(tableName = "carInfo",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)

public class CarInfo {
    @PrimaryKey(autoGenerate = true)
    long id;

    public long userId;

    String car;

    public CarInfo(long userId, String car) {
        this.userId = userId;
        this.car = car;
    }
}
