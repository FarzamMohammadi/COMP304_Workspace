package com.example.farzammohammadi_comp304_002_test02.Models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stocks")
public class StockInfo {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int stockid;

    @ColumnInfo(name = "stock_symbol")
    private String stockSymbol; //primary key
    @ColumnInfo(name = "company_name")
    private String companyName;
    @ColumnInfo(name = "stock_quote")
    private double stockQuote; // stock value

    public StockInfo(String stockSymbol, String companyName, double stockQuote){
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.stockQuote = stockQuote;
    }
    //Getters
    public String getStockSymbol() {
        return stockSymbol;
    }
    public double getStockQuote() {
        return stockQuote;
    }
    public String getCompanyName() {
        return companyName;
    }
    //Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setStockQuote(double stockQuote) {
        this.stockQuote = stockQuote;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}
