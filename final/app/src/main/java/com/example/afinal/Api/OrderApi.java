package com.example.afinal.Api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.afinal.activity.CartActivity;
import com.example.afinal.model.OrderModel;
import com.example.afinal.model.OrderOutputModel;
import com.example.afinal.utils.ConstantData;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class OrderApi {

    public void addOrder(Context context, OrderModel model) {

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(
                Request.Method.POST,
                ConstantData.ADD_ORDER_METHOD,
                response -> {
                    try {
                        OrderOutputModel o = new Gson().fromJson(response,OrderOutputModel.class);
                        if (o.isStatus()) {
                            //((CartActivity)context).setRcylCart(o);
                            Toast.makeText(context, "Added To Cart", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Log.e("CATCH", e.toString());
                        Toast.makeText(context, "CATCH" + e, Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("SERVER ERROR",error.toString() );
                    Toast.makeText(context, "SERVER ERROR : " + error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("uid",model.getUid());
                map.put("pid",model.getPid());
                map.put("discount",String.valueOf(model.getC_discount()));
                map.put("date",model.getDate());
                map.put("time",model.getTime());
                map.put("cod",model.getC_o());
                map.put("c_code",model.getC_code());
                return map;
            }
        };
        queue.add(request);
    }

    public void getOrder(Context context,String uid,String status) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(
                Request.Method.POST,
                ConstantData.GET_ORDER_METHOD,
                response -> {
                    try {
                        OrderOutputModel o = new Gson().fromJson(response,OrderOutputModel.class);
                        if (o.isStatus()) {
                            Toast.makeText(context, "Added To Cart", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Log.e("CATCH", e.toString());
                        Toast.makeText(context, "CATCH" + e, Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.e("SERVER ERROR",error.toString() );
                    Toast.makeText(context, "SERVER ERROR : " + error, Toast.LENGTH_SHORT).show();
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("uid",uid);
                map.put("status",status);
                return map;
            }
        };
        queue.add(request);
    }
}
