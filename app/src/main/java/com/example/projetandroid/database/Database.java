package com.example.projetandroid.database;

import com.example.projetandroid.model.User;

import java.util.ArrayList;

public class Database {


        private ArrayList<User> userDB;

        public Database (){
            ArrayList<User> uDB = new ArrayList<User>();
            this.userDB = uDB;
            this.userDB.add(new User("Adam", "pw", "Adam", "Asselin"));
        }

        public ArrayList<User> getUserDB() {
            return userDB;
        }

        public void addUser(User u){
            userDB.add(u);
        }

    }





