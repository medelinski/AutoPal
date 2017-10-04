package com.example.mirko.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Register;
    private TextView Info;
    private int Counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.txtUsername);
        Password = (EditText)findViewById(R.id.txtPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Info = (TextView)findViewById(R.id.txtInfo);
        Register = (Button)findViewById(R.id.btnRegister);

        Info.setText("Number of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }

    private void validate (String userName, String userPassword){
        if((userName.equals("Mirko")) && (userPassword.equals("1234"))){
            Intent intent = new Intent (MainActivity.this,MyCar.class);
            startActivity(intent);
        }
        else{
            Counter--;

            Info.setText("Number of attempts remaining: "+String.valueOf(Counter));

            if(Counter == 0){
                Login.setEnabled(false);
            }
        }


    }
}
