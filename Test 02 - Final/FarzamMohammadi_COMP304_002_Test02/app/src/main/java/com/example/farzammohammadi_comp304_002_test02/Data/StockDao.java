package com.example.farzammohammadi_comp304_002_test02.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.farzammohammadi_comp304_002_test02.Models.StockInfo;

import java.util.List;

@Dao
public interface StockDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addStock(StockInfo stocks);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addStock2(StockInfo stocks);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addStock3(StockInfo stocks);

    @Query("SELECT * FROM stocks")
    List<StockInfo> getAllStockList();
}
