package com.example.afinal.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.afinal.activity.MainActivity;
import com.example.afinal.fragment.HomeFragment;
import com.example.afinal.model.DataOutputModel;
import com.example.afinal.utils.ConstantData;
import com.google.gson.Gson;

public class Data_Api {
    
    public void getData(Context context)  {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("Please Wait...");
        dialog.setCancelable(false);
        dialog.show();

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                ConstantData.DATA_METHOD,
                response -> {
                    dialog.dismiss();
                    DataOutputModel data = new Gson().fromJson(response,DataOutputModel.class);
                    if (data.getStatus()) {
                        ((MainActivity)context).getData(data);
                        Toast.makeText(context, "Data Get Success", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    dialog.dismiss();
                    Log.e("SERVER ERROR",error.toString());
                    Toast.makeText(context, "SERVER ERROR" + error, Toast.LENGTH_SHORT).show();
                }
        );
        queue.add(request);   
    }
}
