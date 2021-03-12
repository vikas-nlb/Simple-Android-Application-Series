package com.abc.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    DatePicker start, end;
    Button calculate;
    String startDate, endDate;
    Dialog datePopUp;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        start = findViewById(R.id.calenderOne);
        end = findViewById(R.id.calenderTwo);
        calculate = findViewById(R.id.calculateButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDate = getCurrentDate(start);
                endDate = getCurrentDate(end);
                Log.d("Dates", "Start:" + startDate + " End: " + endDate);
                String difference = getDateDifference(startDate, endDate);
                getDialog(difference);
            }
        });


    }


    public String getCurrentDate(DatePicker picker) {
        StringBuilder builder = new StringBuilder();
        ;
        builder.append((picker.getMonth() + 1) + "/");//month is 0 based
        builder.append(picker.getDayOfMonth() + "/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    public String getDateDifference(String start, String end) {
        try {
            String CurrentDate = start;
            String FinalDate = end;

            Date date1;
            Date date2;

            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);

            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);

            String dayDifference = Long.toString(differenceDates);
            return dayDifference;
        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
        }
        return null;
    }

    public void getDialog(String difference){

        datePopUp = new Dialog(MainActivity.this);
        datePopUp.setContentView(R.layout.pop_up);
        linearLayout = datePopUp.findViewById(R.id.linearLayout);
        TextView days = datePopUp.findViewById(R.id.dateDifferenceText);
        days.setText(difference);
        linearLayout.setBackgroundColor(Color.rgb(0,100,0));
        datePopUp.show();

    }
}

