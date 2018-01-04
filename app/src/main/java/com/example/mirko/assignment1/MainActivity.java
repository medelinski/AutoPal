package com.example.mirko.assignment1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.List;
import java.util.jar.*;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Register;
    private TextView Info;
    private int Counter = 5;
    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(getApplicationContext());




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

        // cleanup for testing some initial data
        database.userDao().removeAllUsers();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Mirko", "1234"));
            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            UserDetails userDetails = new UserDetails(user.id, "Learned to use 3");
            database.userDetailsDao().addUserDetails(userDetails);
            database.userDao().addUser(new User(2, "Igor", "1234"));
            database.userDao().addUser(new User(3, "John", "1234"));
        }
        updateFirstUserData();
    }



    private void validate (String userName, String userPassword){
        if((userName.equals(user.name)) && (userPassword.equals("1234"))){
            Intent intent = new Intent (MainActivity.this,OilChange.class);
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
    public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
        @Override
        public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d("myfirebaseid", "Refreshed token: " + refreshedToken);

            // If you want to send messages to this application instance or
            // manage this apps subscriptions on the server side, send the
            // Instance ID token to your app server.
            //sendRegistrationToServer(refreshedToken);
        }
    }
    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<UserDetails> userDetailsForUser = database.userDetailsDao().findUserDetailsForUser(user.get(0).id);
        TextView textView = findViewById(R.id.txtUsername);
        Toast.makeText(this, userDetailsForUser.toString(), Toast.LENGTH_SHORT).show();
        if (user.size()>0 || user.size() <20){
            textView.setText(user.get(0).name);
        }
    }

    public void onClick(View view){
        if (view.getId()==R.id.btnSignUp) {
            // TODO add trophy
            // TODO call updatefirstUserData
            Toast.makeText(this,String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            UserDetails userDetails = new UserDetails(user.id, "More stuff");
            database.userDetailsDao().addUserDetails(userDetails);
        }
        //not needed for now
        //if (view.getId()==R.id.increaseskills ){
           // user.skillPoints++;
            //database.userDao().updateUser(user);
            // TODO to skillpoints

        //}
        // TODO call updatefirstUserData
        updateFirstUserData();

    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
