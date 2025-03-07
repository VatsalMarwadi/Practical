package com.example.afinal.utils;

public class Validation {

    public static boolean isValidUsername(String username) {
        String usernamePattern = "^[a-zA-Z0-9._]{2,15}$";
        return username.matches(usernamePattern);
    }

    public static boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
        return password.matches(passwordPattern);
    }

    public static boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailPattern);
    }

    public static boolean isValidPhoneNumber(String mobno) {
        String mobPattern = "^[0-9]{10}$";
        return mobno.matches(mobPattern);
    }

}
