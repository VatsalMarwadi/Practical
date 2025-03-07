package com.example.afinal.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.afinal.R;
import com.example.afinal.utils.ConstantData;
import com.example.afinal.utils.Validation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etuname, etemail, etpass, etmno;
    TextView btnreg,tvRes;

    String username,password,email,mobileno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etuname = findViewById(R.id.etuname);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        etmno = findViewById(R.id.etmno);

        tvRes = findViewById(R.id.tvRes);
        btnreg = findViewById(R.id.btnreg);

        Intent intent = getIntent();

        tvRes.setOnClickListener(v -> {
            Intent i1 = new Intent(this, LoginActivity.class);
            startActivity(i1);
        });

        btnreg.setOnClickListener(v -> {
            username = etuname.getText().toString().trim();
            email = etemail.getText().toString().trim();
            mobileno = etmno.getText().toString().trim();
            password = etpass.getText().toString().trim();

            if (username.isEmpty()) {
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidUsername(username)) {
                Toast.makeText(this, "Enter Valid  Username", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(this, "Enter mail", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidEmail(email)) {
                Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
            } else if (mobileno.isEmpty()) {
                Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidPhoneNumber(mobileno)) {
                Toast.makeText(this, "Enter Valid Mobile Number", Toast.LENGTH_SHORT).show();
            }
//            else if (password.isEmpty()) {
//                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
//            } else if (!Validation.isValidPassword(password)) {
//                Toast.makeText(this, "Enter Valid password", Toast.LENGTH_SHORT).show();
//            }
            else {
//                sp = getSharedPreferences(ConstantData.SP_NAME, MODE_PRIVATE);
//                SharedPreferences.Editor ed = sp.edit();
//                ed.putBoolean(ConstantData.KEY_SP_ISLOGIN, true);
//                ed.putString(ConstantData.KEY_SP_EMAIL, etemail.getText().toString().trim());
//                ed.commit();
                generateOTP(mobileno);
            }
        });
    }


    public void generateOTP(String mobileno) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // Run in background thread
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");

            Request request = new Request.Builder()
                    .url("https://cpaas.messagecentral.com/verification/v3/send?countryCode=91&customerId=" + ConstantData.CUSTOMER_ID + "&flowType=SMS&mobileNumber=" + mobileno)
                    .method("POST", body)
                    .addHeader("authToken", ConstantData.AUTH_TOKEN)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    String responseBody = response.body().string();

                    JSONObject jsonResponse = new JSONObject(responseBody);

                    // Extract verificationId from the response
                    JSONObject data = jsonResponse.getJSONObject("data");
                    String verificationId = data.getString("verificationId");

                    // Send data to OTPActivity
                    runOnUiThread(() -> {
                        Intent intent = new Intent(RegisterActivity.this, otpActivity.class);
                        intent.putExtra("mobileno", mobileno);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password
                        );
                        intent.putExtra("email", email);
                        intent.putExtra("verificationId", verificationId); // Pass verificationId
                        startActivity(intent);
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(RegisterActivity.this, "OTP request failed", Toast.LENGTH_SHORT).show());
                }
            } catch (IOException | JSONException e) {
                Log.e("ERROR", e.getLocalizedMessage());
                runOnUiThread(() -> Toast.makeText(RegisterActivity.this, "Network error! Try again.", Toast.LENGTH_SHORT).show());
            }
        });

    }
}