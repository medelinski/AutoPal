package com.example.mirko.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.SharedSQLiteStatement;

/**
 * Created by medelinski8813 on 11/29/2017.
 */

@Entity
public class User {

        @PrimaryKey
        public final int id;
        public String name;
        public String password;
        public int level;
        public long skillPoints;


        public User(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.level = 0;
        }

    }

