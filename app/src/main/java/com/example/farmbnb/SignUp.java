package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private Button btnBack;
    private Button btnSubmit;
    private EditText editSignUpUsrName;
    private EditText editSignUpPassword;
    private EditText editSignUpPhone;
    private EditText editSignUpAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);





        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnSubmit);
        editSignUpUsrName = findViewById(R.id.editSignUpUsrName);
        editSignUpPassword = findViewById(R.id.editSignUpPassword);
        editSignUpPhone = findViewById(R.id.editSignUpPhone);
        editSignUpAddress = findViewById(R.id.editSignUpAddress);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginPage();
            }
        });

        // Code responsible for Signing up to the system
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                // Variables
                String Username = editSignUpUsrName.getText().toString();
                String Password = editSignUpPassword.getText().toString();
                String Phone = editSignUpPhone.getText().toString();
                String Address = editSignUpAddress.getText().toString();
                boolean ValidPhoneNumber = false;

                // Code to convert and check if numbers were put into the phone number section
                try{
                    int phone = Integer.parseInt(Phone);
                    if (phone != 0){
                        ValidPhoneNumber = true;
                    }
                }
                catch (Exception e){

                    ValidPhoneNumber = false;
                }

                // Check for empty fields if there are any an error would return
                if (Username.isEmpty() || Password.isEmpty() || Phone.isEmpty() || Address.isEmpty()){
                    Toast.makeText(SignUp.this, "One or more fields are empty please type in all your details", Toast.LENGTH_SHORT).show();
                }

                // Code that checks if a valid phone number has been put in then signs user upto the system and returns them to the login page
                else if (ValidPhoneNumber == true)
                {
                    openLoginPage();
                    Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                }

                // code that returns an error if phone number is invalid
                else
                {
                    Toast.makeText(SignUp.this, "Please Enter A Valid Phone Number", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

    public void openLoginPage(){
        Intent MainActivity = new Intent(SignUp.this, MainActivity.class);
        startActivity(MainActivity);
    }
}