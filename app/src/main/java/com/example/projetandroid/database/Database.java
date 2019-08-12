package com.example.projetandroid.database;

import com.example.projetandroid.model.User;

import java.util.ArrayList;

public class Database {


        private ArrayList<User> userDB;

        public ArrayList<User> getUserDB() {
            return userDB;
        }

        public void addUser(User u){
            userDB.add(u);
        }

    }





