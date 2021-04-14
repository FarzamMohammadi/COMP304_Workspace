package com.example.farzammohammadi_comp304_002_test02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.farzammohammadi_comp304_002_test02.Data.StockDao;
import com.example.farzammohammadi_comp304_002_test02.Data.StocksDatabase;
import com.example.farzammohammadi_comp304_002_test02.Models.StockInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    Button insertButton;
    Button displayButton;
    RadioButton googleRadio;
    RadioButton amazonRadio;
    RadioButton ssnlfRadio;
    TextView displayCase;
    List<StockInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        insertButton = findViewById(R.id.insertStocksBtn);
        displayButton = findViewById(R.id.displayStocksBtn);
        googleRadio = findViewById(R.id.googRadioBtn);
        amazonRadio = findViewById(R.id.amznRadioBtn);
        ssnlfRadio = findViewById(R.id.ssnlfRadioBtn);
        displayCase = findViewById(R.id.displayStockTxt);
        StocksDatabase appDB = StocksDatabase.getInstance(this);
        StocksDatabase appDB2 = StocksDatabase.getInstance(this);
        StocksDatabase appDB3 = StocksDatabase.getInstance(this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                List<StockInfo> stockList = new ArrayList<StockInfo>();
                StockInfo newAmazonStock  = new StockInfo("AMZN", "Amazon", 3399.92);
                StockInfo newGoogleStock = new StockInfo("GOOG", "Google", 2267.27);
                StockInfo newSamsungStock = new StockInfo("SSNLF", "Samsung", 44.20);

                Executor myExecutor = Executors.newSingleThreadExecutor();
                myExecutor.execute(() -> {
                    appDB3.stockDao().addStock3(newSamsungStock);
                    appDB.stockDao().addStock(newAmazonStock);
                    appDB2.stockDao().addStock2(newGoogleStock);
                    getEntries();
                });

            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                List<StockInfo> listOfEntries = new ArrayList<StockInfo>();
                String currentDBPath=getDatabasePath("stocks_db").getAbsolutePath();
                try {
                    for (StockInfo item : list) {
                        if (googleRadio.isChecked() && item.getCompanyName().equalsIgnoreCase("Google")) {
                            String myMessage =("Company Name: " + item.getCompanyName() +
                                    "\nStock Quote: $" + item.getStockQuote());
                            displayCase.setText(myMessage);
                            sendSMS(myMessage);
                        } else if (amazonRadio.isChecked() && item.getCompanyName().equalsIgnoreCase("Amazon")) {
                            String myMessage =("Company Name: " + item.getCompanyName() +
                                    "\nStock Quote: $" + item.getStockQuote());
                            displayCase.setText(myMessage);
                            sendSMS(myMessage);
                        } else if (ssnlfRadio.isChecked() && item.getCompanyName().equalsIgnoreCase("Samsung")) {
                            String myMessage =("Company Name: " + item.getCompanyName() +
                                    "\nStock Quote: $" + item.getStockQuote());
                            displayCase.setText(myMessage);
                            sendSMS(myMessage);
                        }
                    }
                }
                catch(Exception e){
                    displayCase.setText("MUST INSERT DATA FIRST!");
                }
            }
        });
    }
    public void sendSMS(String message){
        String myMessage = message;
        SmsManager smsManager = SmsManager.getDefault();
        String sendTo = "5554";
        smsManager.sendTextMessage(sendTo, null, myMessage, null, null);

    }
    public List<StockInfo> getEntries(){

        StocksDatabase appDB = StocksDatabase.getInstance(this);
        List<StockInfo> listOfEntries = new ArrayList<StockInfo>();
        this.list = appDB.stockDao().getAllStockList();
        return(this.list);
    }
}
