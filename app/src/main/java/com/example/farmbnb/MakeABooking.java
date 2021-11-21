package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


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

    private Button btnBack;
    private Boolean ItemValidator = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_abooking);

        Adapter = new ArrayAdapter<>(this, R.layout.dropdownmenu,Accommodations);
        DropDownMenu = findViewById(R.id.DropDownMenu);

        DropDownMenu.setAdapter(Adapter);

        DropDownMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
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


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (ItemValidator)
                {
                    Intent MakeABooking2 = new Intent(MakeABooking.this, MakeABooking2.class);
                    startActivity(MakeABooking2);
                }
            }
        });



    }
}