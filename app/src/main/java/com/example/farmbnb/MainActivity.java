package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnSignUp;
    boolean Login = false;
    private String Userinput_Username = "admin";
    private String Userinput_Password = "admin";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);


        // Method for Logging in using the input fields
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                // Code to check if input fields are empty
                if (user_name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "One or more fields are empty please type in all your details", Toast.LENGTH_SHORT).show();
                }

                // Code to check for successful login and to send them to the home screen
                else {
                    Login = LoginCheck(user_name, password);

                    if (Login) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent HomePage = new Intent(MainActivity.this, HomePage.class);
                        startActivity(HomePage);

                    }

                    // Code that returns error if login details are incorrect
                    else {
                        Login = false;
                        Toast.makeText(MainActivity.this, "Incorrect Login Details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });



    }

    public void openSignUpPage(){
        Intent Signup = new Intent(MainActivity.this, SignUp.class);
        startActivity(Signup);
    }

    private boolean LoginCheck (String Usrname, String UsrPassword){
        if (Usrname.equals(Userinput_Username) && UsrPassword.equals(Userinput_Password))
        {
            return true;
        }
        else
            {
            return false;
        }

    }


}