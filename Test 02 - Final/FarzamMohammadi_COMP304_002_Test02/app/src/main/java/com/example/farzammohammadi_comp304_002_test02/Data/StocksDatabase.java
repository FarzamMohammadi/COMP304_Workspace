package com.example.farzammohammadi_comp304_002_test02.Data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.farzammohammadi_comp304_002_test02.Models.StockInfo;

@Database(entities = StockInfo.class, version = 3, exportSchema = false)
public abstract class StocksDatabase extends RoomDatabase {
    private static final String DB_NAME = "stocks_db";
    private static StocksDatabase instance;

    public static synchronized StocksDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), StocksDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract StockDao stockDao();
}
