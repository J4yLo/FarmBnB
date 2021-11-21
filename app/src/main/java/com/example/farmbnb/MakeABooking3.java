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

public class MakeABooking3 extends AppCompatActivity {

    private DatePickerDialog Date2;
    private Button btnSelectDeparture;
    private Button btnLogOut4;
    private Button btnBack4;
    private Button btnConfirmBooking;
    private TextView DepartureDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_abooking3);


        DepartureDate = findViewById(R.id.DepartureDate);
        btnSelectDeparture = findViewById(R.id.btnSelectDeparture);
        btnConfirmBooking = findViewById(R.id.btnConfirmBooking);
        btnBack4 = findViewById(R.id.btnBack4);
        btnLogOut4 = findViewById(R.id.btnLogOut4);


        DepartureDate.setText(getdate());
        DepartureDateSelector();

        // Btn functions to redirect to a different page
        btnLogOut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLoginPage();
            }
        });

        btnBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomePage();
            }
        });

        btnConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomePage();
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

    // open up calender to choose date and sets date to today so no Departure can be made in the past
    private void DepartureDateSelector(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String chosenDate = dateFormat(day, month, year);
                DepartureDate.setText(chosenDate);
            }
        };


        Calendar calendar = Calendar.getInstance();
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        int Month = calendar.get(Calendar.MONTH);
        int Year = calendar.get(Calendar.YEAR);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        Date2 = new DatePickerDialog (this, style, dateSetListener, Year, Month, Day);
        Date2.getDatePicker().setMinDate(System.currentTimeMillis() + 432000000);


    }

    // format date into a readable format
    private String dateFormat(int day, int month, int year)
    {
        return day + "/" + month + "/" + year;
    }

    public void openDatePicker(View view)
    {
        Date2.show();
    }


    // functions for the buttons
    public void openLoginPage(){
        Intent MainActivity = new Intent(MakeABooking3.this, MainActivity.class);
        startActivity(MainActivity);
    }

    public void openHomePage(){
        Intent HomePage = new Intent(MakeABooking3.this, HomePage.class);
        startActivity(HomePage);
    }


}