package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class MakeABooking extends AppCompatActivity {

    String[] Accommodations = {
            "Farm House Bedroom 1",
            "Farm House Bedroom 2",
            "Farm House Bedroom 3",
            "Barn - Self Catering",
            "Hut - Self Catering",
            "Hut - Catering Included",
    };
    AutoCompleteTextView DropDownMenu;
    ArrayAdapter<String> Adapter;

    private Button btnBack2;
    private Button btnSelectBooking;
    private Boolean ItemValidator = false;
    private Button btnLogOut2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_abooking);

        btnBack2 = findViewById(R.id.btnBack2);
        btnLogOut2 = findViewById(R.id.btnLogOut2);
        btnSelectBooking = findViewById(R.id.btnSelectBooking);

        Adapter = new ArrayAdapter<>(this, R.layout.dropdownmenu,Accommodations);
        DropDownMenu = findViewById(R.id.DropDownMenu);

        DropDownMenu.setAdapter(Adapter);

        DropDownMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            // Code that changes boolean value to true, this is to validate if a user actually chose an item before they click a button
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Please Select Accommodation Type"))
                {
                    ItemValidator = false;
                }
                else
                {
                    ItemValidator = true;
                }

            }
        });


        // Code that takes user to set dates page if they have an Accommodation selected
        btnSelectBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (ItemValidator)
                {
                    Intent MakeABooking2 = new Intent(MakeABooking.this, MakeABooking2.class);
                    startActivity(MakeABooking2);
                }
                else
                {
                    Toast.makeText(MakeABooking.this, "Please Select An Accommodation", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Code that returns user to login page
        btnLogOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomePage();
            }
        });


    }

    public void openLoginPage(){
        Intent MainActivity = new Intent(MakeABooking.this, MainActivity.class);
        startActivity(MainActivity);
    }

    public void openHomePage(){
        Intent HomePage = new Intent(MakeABooking.this, HomePage.class);
        startActivity(HomePage);
    }
}