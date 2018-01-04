package com.example.mirko.assignment1;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements OnClickListener{

    private EditText NewUser;
    private EditText Email;
    private EditText NewPass;
    private EditText ConPass;
    private Button SingUp;
    private TextView Error;
    private AppDatabase database;
    private String username;
	private String password;
	private String email;
	private String name;
    private int userCount;




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
                SingUp.setOnClickListener(this);
            }
        });



        database = AppDatabase.getDatabase(getApplicationContext());


    }
    private void validate (String user, String email, String password, String confirmPass){
        if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            Error.setText("Please enter a valid email address.");
        }
        else if(!password.equals(confirmPass)){
            Error.setText("The passwords do not match.");
        }
        else{
            Intent intent = new Intent(Register.this, OilChange.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
            username = NewUser.getText().toString();
        	password = NewPass.getText().toString();
        	email = Email.getText().toString();
        	name = ConPass.getText().toString();

            List<User> users = database.userDao().getAllUser();
            userCount = users.size() + 1;
            database.userDao().addUser(new User(userCount, username, password));
            Toast.makeText(Register.this,
                "Account created", Toast.LENGTH_SHORT).show();
            Intent prefIntent = new Intent(Register.this, PreferenceActivity.class);
            prefIntent.putExtra("usernameDetails", username);
            Register.this.startActivity(prefIntent);


    }
}
