package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {


    private Button btnViewAndManageBookings;
    private Button btnMakeABooking;
    private Button btnLogOut;
    private Button btnViewBookingHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        btnViewAndManageBookings = findViewById(R.id.btnViewAndManageBookings);
        btnMakeABooking = findViewById(R.id.btnMakeABooking);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnViewBookingHistory = findViewById(R.id.btnViewBookingHistory);

        // Code that returns user to login page
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        // Code that takes the user to the view and manage bookings page
        btnViewAndManageBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewAndManageBookingsPage();
            }
        });

        // Code that takes the user to the make a booking page
        btnMakeABooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeABooking();
            }
        });


        // Code that takes the user to the History page
        btnViewBookingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHistory();
            }
        });

    }


    public void openLoginPage(){
        Intent MainActivity = new Intent(HomePage.this, MainActivity.class);
        startActivity(MainActivity);
    }

    public void openViewAndManageBookingsPage(){
        Intent ViewAndManageBookings = new Intent(HomePage.this, ViewAndManageBookings.class);
        startActivity(ViewAndManageBookings);
    }

    public void MakeABooking(){
        Intent MakeABooking = new Intent(HomePage.this, MakeABooking.class);
        startActivity(MakeABooking);
    }

    public void ViewHistory(){
        Intent ViewHistory = new Intent(HomePage.this, BookingHistory.class);
        startActivity(ViewHistory);
    }
}