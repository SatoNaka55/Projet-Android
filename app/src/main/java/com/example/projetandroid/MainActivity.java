package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetandroid.database.Database;
import com.example.projetandroid.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goLogin(View myView) {
       Database uDB = new Database();



        Intent empListIntent = new Intent(this, EmployeeListActivity.class);
        Intent loginErrorIntent = new Intent(this, LoginErrorActivity.class);
        EditText inputU = (EditText) findViewById(R.id.usernameInput);
        EditText inputP = (EditText) findViewById(R.id.passwordInput);
        TextView loginError = (TextView) findViewById(R.id.loginError);
        String username = inputU.getText().toString();
        String password = inputP.getText().toString();

        //Validate that text fields are filled
        if (username.equals("") || password.equals("")) {
            loginError.setText("Please fill in your username and password");
        }
        //Validate if username is alphanumeric
       /* else if(!username.matches("^[a-zA-Z0-9]+$")){
            loginError.setText("Invalid Username. Only alphanumeric entries are accepted");
        }*/
        //Validate password length
        else if(password.length() < 8){
            loginError.setText("Password is too short. Please enter at least 8 characters");
        }
        //Validate password characters
      /*  else if(!password.matches("[$&+,:;=?@#|'<>.^_()%!-]")) {
            loginError.setText("Password invalid. Please use a special character: $&+,:;=?@#|'<>.^\\_()%!-");
        }*/

        else if(!password.matches("[a-z]+?")){
            loginError.setText("Password invalid. Please use at least one lowercase character");
        }

        else {

            for (User u : uDB.getUserDB()) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    startActivity(empListIntent);
                }
            }
            loginErrorIntent.putExtra("username",username);
            loginErrorIntent.putExtra("password",password);
            startActivity(loginErrorIntent);
        }
        }
    }

