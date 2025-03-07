package com.example.afinal.Api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.afinal.activity.LoginActivity;
import com.example.afinal.activity.MainActivity;
import com.example.afinal.model.PersonModel;
import com.example.afinal.model.PersonOutputModel;
import com.example.afinal.utils.ConstantData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Login_Register_Api {

    public void registerUser(Context context, PersonModel personModel) {
        String URL = ConstantData.REGISTER_METHOD;
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(
                Request.Method.POST,
                URL,
                response -> {
                    try {
                        Gson gson = new Gson();
                        PersonOutputModel p = gson.fromJson(response,PersonOutputModel.class);
                        if (p.isStatus()) {
                            Intent intent = new Intent(context, LoginActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(context, "ERROR" + e.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("SERVER ERROR",error.toString());
                    Toast.makeText(context, "SERVER ERROR : " + error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",personModel.getUsername());
                map.put("email",personModel.getEmail());
                map.put("password",personModel.getPassword());
                map.put("mobileno",personModel.getMobileno());

                return map;
            }
        };
        queue.add(request);
    }

    public void loginUser(Context context, PersonModel personModel) {
        String URL = ConstantData.LOGIN_METHOD;
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(
                Request.Method.POST,
                URL,
                response -> {
                    try {
                        Gson gson = new Gson();
                        PersonOutputModel p = gson.fromJson(response,PersonOutputModel.class);
                        if (p.isStatus()) {
                            SharedPreferences sp = context.getSharedPreferences(ConstantData.SP_NAME,Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor= sp.edit();
                            editor.putBoolean(ConstantData.KEY_SP_ISLOGIN,true);
                            editor.putString(ConstantData.KEY_SP_USER_ID,p.getPerson().getId());
                            editor.putString(ConstantData.KEY_SP_UNAME,p.getPerson().getUsername());
                            editor.putString(ConstantData.KEY_SP_EMAIL,p.getPerson().getEmail());
                            editor.putString(ConstantData.KEY_SP_MOBILE_NO,p.getPerson().getMobileno());
                            editor.commit();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                            Toast.makeText(context, p.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(context, "ERROR" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("SERVER ERROR",error.toString());
                    Toast.makeText(context, "SERVER ERROR : " + error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",personModel.getUsername());
                map.put("password",personModel.getPassword());

                return map;
            }
        };
        queue.add(request);
    }
}