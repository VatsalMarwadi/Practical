package com.example.sharedprefrences_example.utils;

public class Validation {

    public static boolean isValidEmail(String email){
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailPattern);
    }

    public static boolean isValidPass(String pass){
        String passPattern = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
        return pass.matches(passPattern);
    }

}
