package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MakeABooking2 extends AppCompatActivity {

    private DatePickerDialog Date;
    private Button btnSelectDeparture;
    private Button btnLogOut3;
    private Button btnBack3;
    private TextView ArrivalDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_abooking2);


        ArrivalDate = findViewById(R.id.ArrivalDate);
        btnSelectDeparture = findViewById(R.id.btnSelectDeparture);
        btnLogOut3 = findViewById(R.id.btnLogOut3);
        btnBack3 = findViewById(R.id.btnBack3);

        ArrivalDate.setText(getdate());
        arrivalDateSelector();


        // Btn functions to redirect to a different page
        btnLogOut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLoginPage();
            }
        });

        btnBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomePage();
            }
        });

        btnSelectDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDepartureDates();
            }
        });

    }



    // Gets todays Date
    private String getdate() {
        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);
        Month = Month + 1;
        return dateFormat(Day, Month, Year);
    }

    // open up calender to choose date and sets date to today so no booking can be made in the past
    private void arrivalDateSelector(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String chosenDate = dateFormat(day, month, year);
                ArrivalDate.setText(chosenDate);
            }
        };


        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        Date = new DatePickerDialog (this, style, dateSetListener, Year, Month, Day);
        Date.getDatePicker().setMinDate(System.currentTimeMillis() -1000);


    }

    // format date into a readable format
    private String dateFormat(int day, int month, int year)
    {
        return day + "/" + month + "/" + year;
    }

    public void openDatePicker(View view)
    {
        Date.show();
    }


    // functions for the buttons
    public void openLoginPage(){
        Intent MainActivity = new Intent(MakeABooking2.this, MainActivity.class);
        startActivity(MainActivity);
    }

    public void openHomePage(){
        Intent HomePage = new Intent(MakeABooking2.this, HomePage.class);
        startActivity(HomePage);
    }

    public void openDepartureDates(){
        Intent MakeABooking3 = new Intent(MakeABooking2.this, MakeABooking3.class);
        startActivity(MakeABooking3);
    }

}