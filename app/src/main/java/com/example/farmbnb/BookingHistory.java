package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BookingHistory extends AppCompatActivity {

    ListView lstHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);


        lstHistory= findViewById(R.id.lstHistory);
        ArrayList<String> Bookings = new ArrayList<>();

        Bookings.add("FarmHouse Bedroom 1: 19/07/2021 - 20/07/2021");
        Bookings.add("FarmHouse Bedroom 2: 25/07/2021 - 26/07/2021");
        Bookings.add("FarmHouse Bedroom 3: 26/07/2021 - 27/07/2021");

        ArrayAdapter ada =new ArrayAdapter(this, android.R.layout.simple_list_item_1,Bookings);
        lstHistory.setAdapter(ada);

    }
}