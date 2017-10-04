package com.example.mirko.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText NewUser;
    private EditText Email;
    private EditText NewPass;
    private EditText ConPass;
    private Button SingUp;
    private TextView Error;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        NewUser = (EditText)findViewById(R.id.txtNewName);
        Email = (EditText)findViewById(R.id.txtEmail);
        NewPass = (EditText)findViewById(R.id.txtNewPassword);
        ConPass = (EditText)findViewById(R.id.txtConPass);
        SingUp = (Button)findViewById(R.id.btnSignUp);
        Error = (TextView)findViewById(R.id.txtError2);

        SingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(NewUser.getText().toString(),Email.getText().toString(),NewPass.getText().toString()
                ,ConPass.getText().toString());


            }
        });

    }
    private void validate (String user, String email, String password, String confirmPass){
        if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            Error.setText("Please enter a valid email address.");
        }
        else if(!password.equals(confirmPass)){
            Error.setText("The passwords do not match.");
        }
        else{
            Intent intent = new Intent(Register.this, MyCar.class);
            startActivity(intent);
        }
    }
}
