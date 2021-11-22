package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {


    private Button btnViewAndManageBookings;
    private Button btnMakeABooking;
    private Button btnLogOut;
    private Button btnViewBookingHistory;
    private TextView txtUser;
    private String User_ID = "Error";

    // Variables to pass onto next form
    public static final String UserID = "com.example.farmbnb.UserID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);





        //Get Variables From Login To Display UserName On Page
        Intent UserID = getIntent();
        String UserName = UserID.getStringExtra(MainActivity.UserID);

        Toast.makeText(HomePage.this, "Selected Accommodation ", Toast.LENGTH_SHORT).show();
        Toast.makeText(HomePage.this, "Arrival ", Toast.LENGTH_SHORT).show();
        Toast.makeText(HomePage.this, "Departure ", Toast.LENGTH_SHORT).show();



        btnViewAndManageBookings = findViewById(R.id.btnViewAndManageBookings);
        btnMakeABooking = findViewById(R.id.btnMakeABooking);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnViewBookingHistory = findViewById(R.id.btnViewBookingHistory);
        txtUser = findViewById(R.id.txtUser);

        // Display User ID in View
        txtUser.setText(UserName);

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
            public void onClick(View v)
            {
                User_ID = UserName;
                openViewAndManageBookingsPage();
            }
        });

        // Code that takes the user to the make a booking page
        btnMakeABooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_ID = UserName;
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
        ViewAndManageBookings.putExtra(UserID, User_ID);
        startActivity(ViewAndManageBookings);
    }

    public void MakeABooking(){
        Intent MakeABooking = new Intent(HomePage.this, MakeABooking.class);
        MakeABooking.putExtra(UserID, User_ID);
        startActivity(MakeABooking);
    }

    public void ViewHistory(){
        Intent ViewHistory = new Intent(HomePage.this, BookingHistory.class);
        startActivity(ViewHistory);
    }
}