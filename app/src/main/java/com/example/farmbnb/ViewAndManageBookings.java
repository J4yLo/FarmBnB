package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewAndManageBookings extends AppCompatActivity {
    // Variables to pass onto next view
    public static final String UserID = "com.example.farmbnb.UserID";

    //Variables for current page
    private Button btnLogOut5;
    private Button btnBack5;
    private Button btnCancelBooking;
    private Button btnViewHistory;
    private String UserName = "Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_manage_bookings);

        //Get Variables From previous Form
        Intent User_ID = getIntent();
        UserName = User_ID.getStringExtra(HomePage.UserID);

        btnLogOut5 = findViewById(R.id.btnLogOut5);
        btnBack5 = findViewById(R.id.btnBack5);
        btnCancelBooking = findViewById(R.id.btnCancelBooking);
        btnViewHistory = findViewById(R.id.btnViewHistory);



        Toast.makeText(ViewAndManageBookings.this, UserName, Toast.LENGTH_SHORT).show();


        //Code for initiating button links
        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHistory();
            }
        });

        btnLogOut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        btnBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHomePage();
            }
        });

        btnCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewAndManageBookings.this, "Booking Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
    }



    // Function for Button Links
    public void ViewHistory(){
        Intent ViewHistory = new Intent(ViewAndManageBookings.this, BookingHistory.class);
        startActivity(ViewHistory);
    }

    public void openLoginPage(){
        Intent MainActivity = new Intent(ViewAndManageBookings.this, MainActivity.class);
        startActivity(MainActivity);
    }


    public void OpenHomePage(){
        Intent OpenHomePage = new Intent(ViewAndManageBookings.this, HomePage.class);
        OpenHomePage.putExtra(UserID, UserName);
        startActivity(OpenHomePage);
    }
}