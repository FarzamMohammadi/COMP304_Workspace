package com.example.farzammohammadi_comp304_002_test02.Data;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farzammohammadi_comp304_002_test02.Models.StockInfo;

import java.util.ArrayList;
import java.util.List;

public class StocksRepository {
    private StockDao stockDao;

    public List<StockInfo> readAllData(){
        List<StockInfo> getData = new ArrayList<StockInfo>();
        stockDao.getAllStockList();
        return getData;
    }
    public void addStockInfo(StockInfo stock){
        List<StockInfo> getData = new ArrayList<StockInfo>();
        stockDao.addStock(stock);
    }
    private MutableLiveData<List<StockInfo>> searchResults =
            new MutableLiveData<>();

    private void addStock(List<StockInfo> results) {
        searchResults.setValue(results);
    }


}
