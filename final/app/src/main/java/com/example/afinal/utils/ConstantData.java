package com.example.afinal.utils;

public class ConstantData {

    //OTP
    public static final String CUSTOMER_ID="C-048F27C356244B3";
    public static final String AUTH_TOKEN="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJDLTA0OEYyN0MzNTYyNDRCMyIsImlhdCI6MTczODU3Mjk3MywiZXhwIjoxODk2MjUyOTczfQ.H8PTvcWrtDXgC8iAL3F9Mx6YIkB4EjEgjE--1sU0rPKnjsQVkqM9Gn8xq-drdjKIM2k5ZoNWzDlt_gdtb-qhVg";

    //API
    public static final String SERVER_ADDRESS = "http://192.168.1.84:8000";
    public static final String REGISTER_METHOD = SERVER_ADDRESS + "/api_register";
    public static final String LOGIN_METHOD = SERVER_ADDRESS + "/api_login";
    public static final String DATA_METHOD = SERVER_ADDRESS + "/api_data";
    public static final String ADD_ORDER_METHOD = SERVER_ADDRESS + "/api_addorder";
    public static final String GET_ORDER_METHOD = SERVER_ADDRESS + "/api_getorder";

    //shared prefrences
    public static final String SP_NAME = "sp";
    public static final String KEY_SP_EMAIL = "email";
    public static final String KEY_SP_UNAME = "unmae";
    public static final String KEY_SP_MOBILE_NO = "mobileno";
    public static final String KEY_SP_ISLOGIN = "is_login";
    public static final String KEY_SP_USER_ID = "id";

}