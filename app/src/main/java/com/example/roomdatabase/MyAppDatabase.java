package com.example.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class,version = 2)
public abstract class MyAppDatabase extends RoomDatabase
{
    public abstract  MyDao myDao();
}
