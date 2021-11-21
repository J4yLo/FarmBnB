package com.example.farmbnb;

import androidx.appcompat.app.AppCompatActivity;

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






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                if (user_name.isEmpty() || password.isEmpty())
                {
                    Toast.makeText( MainActivity.this, "One or more fields are empty please type in all your details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (user_name == password)
                    {
                        Toast.makeText( MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText( MainActivity.this, "Incorrect Login Details",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


}