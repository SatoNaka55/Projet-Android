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
        Boolean areFieldsEmpty = true;
        Boolean isUserAlphaNumeric = false;
        Boolean isPwLengthOk = false;
        Boolean isPwAtLeastOneNumber = false;
        Boolean isPwAtLeastOneUppercase = false;
        Boolean isPwAtLeastOneLowercase = false;
        Boolean isPwAtLeastOneSpecial = false;
        Boolean isValidationOk = false;

        areFieldsEmpty = username.equals("") || password.equals("");
        isUserAlphaNumeric = username.matches("^[a-zA-Z0-9_]*$");
        isPwLengthOk = password.length() >= 8;
        isPwAtLeastOneNumber = password.matches(".*[0-9].*");
        isPwAtLeastOneUppercase = password.matches(".*[A-Z].*");
        isPwAtLeastOneLowercase = password.matches(".*[a-z].*");
        isPwAtLeastOneSpecial = password.matches(".*[$&+,:;=?@#|'<>.^_()%!-].*");

        isValidationOk = !areFieldsEmpty &&
                isUserAlphaNumeric &&
                isPwLengthOk &&
                isPwAtLeastOneNumber &&
                isPwAtLeastOneUppercase &&
                isPwAtLeastOneLowercase &&
                isPwAtLeastOneSpecial;

        if(areFieldsEmpty) {
            loginError.setText("Please fill in your username and password.");
        }
        else if(!isUserAlphaNumeric) {
            loginError.setText("Please use only letters and numbers for the username.");
        }
        else if(!isPwAtLeastOneUppercase) {
            loginError.setText("Password invalid. Please use at least one upper character.");
        }
        else if(!isPwAtLeastOneLowercase) {
            loginError.setText("Password invalid. Please use at least one lower character.");
        }
        else if(!isPwAtLeastOneNumber) {
            loginError.setText("Password invalid. Please use at least one number.");
        }
        else if(!isPwAtLeastOneSpecial) {
            loginError.setText("Password invalid. Please use at least one special character ($&+,:;=?@#|'<>.^\\\\_()%!-).");
        }
        else if(!isPwLengthOk) {
            loginError.setText("Password length invalid. Please use at least 8 characters.");
        }
        else if(isValidationOk){

            Boolean isFound = false;
            for (User u : uDB.getUserDB()) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    isFound = true;
                    break;
                }
            }
            if(isFound) {
                startActivity(empListIntent);
            } else {
                loginErrorIntent.putExtra("username",username);
                loginErrorIntent.putExtra("password",password);
                startActivity(loginErrorIntent);
            }

        }
    }
}

