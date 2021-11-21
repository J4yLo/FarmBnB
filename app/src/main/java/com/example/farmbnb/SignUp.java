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

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                String Username = editSignUpUsrName.getText().toString();
                String Password = editSignUpPassword.getText().toString();
                String Phone = editSignUpPhone.getText().toString();
                String Address = editSignUpAddress.getText().toString();

                if (Username.isEmpty() || Password.isEmpty() || Phone.isEmpty() || Address.isEmpty()){
                    Toast.makeText(MainActivity.this, "One or more fields are empty please type in all your details", Toast.LENGTH_SHORT).show();
                }


                Intent MainActivity = new Intent(SignUp.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }
}