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
import android.widget.Toast;

import java.util.Calendar;

public class MakeABooking2 extends AppCompatActivity {

    private DatePickerDialog Date;
    private Button btnSelectDeparture;
    private Button btnLogOut3;
    private Button btnBack3;
    private TextView ArrivalDate;
    private TextView txtSelectedAccomodation2;
    private String SelectedDate = "None Selected Error";
    private String Acc = "None Selected Error";
    private String UserName = "Error";

    // Variables to pass onto next view
    public static final String DateOfArrival = "com.example.farmbnb.DateOfArrival";
    public static final String Accommodation = "com.example.farmbnb.Accommodation";
    public static final String UserID = "com.example.farmbnb.UserID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_abooking2);




        //Get Variables From Login To Display UserName On Page
        Intent AccommodationType = getIntent();
        String Accom = AccommodationType.getStringExtra(MakeABooking.AccommodationType);


        ArrivalDate = findViewById(R.id.ArrivalDate);
        btnSelectDeparture = findViewById(R.id.btnSelectDeparture);
        btnLogOut3 = findViewById(R.id.btnLogOut3);
        btnBack3 = findViewById(R.id.btnBack3);
        txtSelectedAccomodation2 = findViewById(R.id.txtSelectedAccomodation2);


        //Get Variables From Previous View
        Intent UserID = getIntent();
        UserName = UserID.getStringExtra(MakeABooking.UserID);
        //Toast.makeText(MakeABooking2.this, UserName, Toast.LENGTH_SHORT).show();






        // Display Selected Accommodation in View
        txtSelectedAccomodation2.setText(Accom);


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
                Acc = Accom;
                SelectedDate = ArrivalDate.getText().toString();
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
                SelectedDate = chosenDate;

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
        HomePage.putExtra(UserID, UserName);
        startActivity(HomePage);
    }

    public void openDepartureDates(){
        Intent openDepartureDates = new Intent(MakeABooking2.this, MakeABooking3.class);
        openDepartureDates.putExtra(Accommodation, Acc);
        openDepartureDates.putExtra(DateOfArrival, SelectedDate);
        openDepartureDates.putExtra(UserID, UserName);
        startActivity(openDepartureDates);

    }

}