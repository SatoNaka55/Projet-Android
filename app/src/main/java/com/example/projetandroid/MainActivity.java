package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goLogin(View myView) {
       /* UserDatabase uDB = new UserDatabase();

        User u1 = new User("Adam", "pw", "Adam", "Asselin");
        uDB.addUser(u1);*/

        Intent myIntent1 = new Intent(this, EmployeeListActivity.class);
        EditText inputU = (EditText) findViewById(R.id.usernameInput);
        EditText inputP = (EditText) findViewById(R.id.passwordInput);
        TextView loginError = (TextView) findViewById(R.id.loginError);

        if (inputU.equals(null) || inputP.equals(null)) {
            loginError.setText("Please fill in your username and password");
        }/* else {
            for (User u : uDB.getUserDB()) {
                if (u.getUsername().equals(inputU) && u.getPassword().equals(inputP)) {
                    myIntent1.putExtra("user", u);
                    startActivity(myIntent1);
                }
            }
            loginError.setText("Username and/or password not found");
        }*/
    }
}
