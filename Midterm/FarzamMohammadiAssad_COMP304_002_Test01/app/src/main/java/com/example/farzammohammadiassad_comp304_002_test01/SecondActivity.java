package com.example.farzammohammadiassad_comp304_002_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ImageView reusableImageView;
    private TextView titleTextView;
    ImageView imageStock1;
    LinearLayout lLayout1;
    ImageView imageStock2;
    LinearLayout lLayout2;
    ImageView imageStock3;
    LinearLayout lLayout3;
    ImageView imageStock4;
    LinearLayout lLayout4;
    ImageView imageStock5;
    LinearLayout lLayout5;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx= 20;
    private int endy= 20;

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    private Canvas primaryCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get Passed String of Checked Stocks
        String passedStockNames = "Showing Graphs of Stocks:\n";
        // Setting Text For Title
        titleTextView = findViewById(R.id.chartsToShow);
        String[] stockNamesToGraph = getIntent().getStringExtra("stocksToShow").split(",");

        for(String name : stockNamesToGraph){
            passedStockNames += "-" + name;
        }
        titleTextView.setText(passedStockNames);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), 1100, Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        primaryCanvas = new Canvas(bitmap);
        //set the background for your drawings
        primaryCanvas.drawColor(Color.BLACK);
        //setup the image view
        reusableImageView = findViewById(R.id.chartImageView);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);


        for (String stock : stockNamesToGraph) {

            if (stock.equalsIgnoreCase("IBM")) {
                TextView nameOfStock = findViewById(R.id.stockNameTxt1);
                nameOfStock.setText(stock);
                lLayout1 = findViewById(R.id.lLayout1);
                lLayout1.setVisibility(View.VISIBLE);

                paint = new Paint();
                paint.setStrokeWidth(10);
                startx = 0;
                starty = 0;
                paint.setColor(Color.BLUE);


                String[] stockValues = getResources().getStringArray(R.array.ibmStockValues);
                for (String value : stockValues) {
                    endx += 200;
                    endy = Integer.parseInt(value);
                    drawLine(primaryCanvas);
                }
                endx = 20;
                endy = 20;
                //creating a bitmap as content view for the image
                bitmap = Bitmap.createBitmap(200, 50, Bitmap.Config.ARGB_8888);
                //tell canvas about the content view
                canvas = new Canvas(bitmap);
                //set the background for your drawings
                canvas.drawColor(Color.BLUE); //background
                //setup the image view
                imageStock1 = findViewById(R.id.lineColor1);
                //tell image view for the bitmap format/content
                imageStock1.setImageBitmap(bitmap);
                imageStock1.setVisibility(View.VISIBLE);
            }

            if (stock.equalsIgnoreCase("MSFT")) {
                TextView nameOfStock = findViewById(R.id.stockNameTxt2);
                nameOfStock.setText(stock);
                lLayout2 = findViewById(R.id.lLayout1);
                lLayout2.setVisibility(View.VISIBLE);

                paint = new Paint();
                paint.setStrokeWidth(10);
                startx = 0;
                starty = 0;
                paint.setColor(Color.LTGRAY);


                String[] stockValues = getResources().getStringArray(R.array.microsoftStockValues);
                for (String value : stockValues) {
                    endx += 200;
                    endy = Integer.parseInt(value);
                    drawLine(primaryCanvas);
                }
                endx = 20;
                endy = 20;
                //creating a bitmap as content view for the image
                bitmap = Bitmap.createBitmap(200, 50, Bitmap.Config.ARGB_8888);
                //tell canvas about the content view
                canvas = new Canvas(bitmap);
                //set the background for your drawings
                canvas.drawColor(Color.LTGRAY); //background
                //setup the image view
                imageStock2 = findViewById(R.id.lineColor2);
                //tell image view for the bitmap format/content
                imageStock2.setImageBitmap(bitmap);
                imageStock2.setVisibility(View.VISIBLE);
            }


            if (stock.equalsIgnoreCase("GOOG")) {
                TextView nameOfStock = findViewById(R.id.stockNameTxt3);
                nameOfStock.setText(stock);
                lLayout3 = findViewById(R.id.lLayout1);
                lLayout3.setVisibility(View.VISIBLE);

                paint = new Paint();
                paint.setStrokeWidth(10);
                startx = 0;
                starty = 0;
                paint.setColor(Color.GREEN);


                String[] stockValues = getResources().getStringArray(R.array.googleStockValues);
                for (String value : stockValues) {
                    endx += 200;
                    endy = Integer.parseInt(value);
                    drawLine(primaryCanvas);
                }
                endx = 20;
                endy = 20;
                //creating a bitmap as content view for the image
                bitmap = Bitmap.createBitmap(200, 50, Bitmap.Config.ARGB_8888);
                //tell canvas about the content view
                canvas = new Canvas(bitmap);
                //set the background for your drawings
                canvas.drawColor(Color.GREEN); //background
                //setup the image view
                imageStock3 = findViewById(R.id.lineColor3);
                //tell image view for the bitmap format/content
                imageStock3.setImageBitmap(bitmap);
                imageStock3.setVisibility(View.VISIBLE);
            }

            if (stock.equalsIgnoreCase("AAPL")) {
                TextView nameOfStock = findViewById(R.id.stockNameTxt4);
                nameOfStock.setText(stock);
                lLayout4 = findViewById(R.id.lLayout1);
                lLayout4.setVisibility(View.VISIBLE);

                paint = new Paint();
                paint.setStrokeWidth(10);
                startx = 0;
                starty = 0;
                paint.setColor(Color.RED);


                String[] stockValues = getResources().getStringArray(R.array.appleStockValues);
                for (String value : stockValues) {
                    endx += 200;
                    endy = Integer.parseInt(value);
                    drawLine(primaryCanvas);
                }
                endx = 20;
                endy = 20;
                //creating a bitmap as content view for the image
                bitmap = Bitmap.createBitmap(200, 50, Bitmap.Config.ARGB_8888);
                //tell canvas about the content view
                canvas = new Canvas(bitmap);
                //set the background for your drawings
                canvas.drawColor(Color.RED); //background
                //setup the image view
                imageStock4 = findViewById(R.id.lineColor4);
                //tell image view for the bitmap format/content
                imageStock4.setImageBitmap(bitmap);
                imageStock4.setVisibility(View.VISIBLE);
            }

            if (stock.equalsIgnoreCase("ORCL")) {
                TextView nameOfStock = findViewById(R.id.stockNameTxt5);
                nameOfStock.setText(stock);
                lLayout5 = findViewById(R.id.lLayout1);
                lLayout5.setVisibility(View.VISIBLE);
                paint = new Paint();
                paint.setStrokeWidth(10);
                startx = 0;
                starty = 0;
                paint.setColor(Color.YELLOW);


                String[] stockValues = getResources().getStringArray(R.array.oracleStockValues);
                for (String value : stockValues) {
                    endx += 200;
                    endy = Integer.parseInt(value);
                    drawLine(primaryCanvas);
                }
                endx = 20;
                endy = 20;
                //creating a bitmap as content view for the image
                bitmap = Bitmap.createBitmap(200, 50, Bitmap.Config.ARGB_8888);
                //tell canvas about the content view
                canvas = new Canvas(bitmap);
                //set the background for your drawings
                canvas.drawColor(Color.YELLOW); //background
                //setup the image view
                imageStock5 = findViewById(R.id.lineColor5);
                //tell image view for the bitmap format/content
                imageStock5.setImageBitmap(bitmap);
                imageStock5.setVisibility(View.VISIBLE);
            }
        }
    }

    public void startDrawing(View v)
    {
        canvas.drawPoint(15,15,paint);

    }
    public void drawLine (Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;
    }
}