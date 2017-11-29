package com.example.mirko.assignment1;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by medelinski8813 on 11/29/2017.
 */

@Entity
public class User {

        @PrimaryKey
        public final int id;
        public String name;
        public int level;
        public long skillPoints;


        public User(int id, String name, long skillPoints) {
            this.id = id;
            this.name = name;
            this.skillPoints  = skillPoints;
            this.level = 0;
        }

    }

