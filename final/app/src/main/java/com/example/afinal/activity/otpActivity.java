package com.example.afinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.afinal.Api.Login_Register_Api;
import com.example.afinal.R;
import com.example.afinal.model.PersonModel;
import com.example.afinal.utils.ConstantData;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class otpActivity extends AppCompatActivity {

    EditText etOtp1,etOtp2,etOtp3,etOtp4;
    Button btnverify;
    String username, password, email, mobileno, verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        email = getIntent().getStringExtra("email");
        mobileno = getIntent().getStringExtra("mobileno");
        verificationId = getIntent().getStringExtra("verificationId");  // Ensure this is received

        etOtp1 = findViewById(R.id.etOtp1);
        etOtp2 = findViewById(R.id.etOtp2);
        etOtp3 = findViewById(R.id.etOtp3);
        etOtp4 = findViewById(R.id.etOtp4);

        btnverify = findViewById(R.id.btnverify);

        setBoX();
        btnverify.setOnClickListener(v -> {
            if(isOtpValid()){
                String code=getOtp();
                verifyOTP(code);
            }else {
                Toast.makeText(this, "Please enter code", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private boolean isOtpValid() {
        return !(etOtp1.getText().toString().trim().isEmpty() ||
                etOtp2.getText().toString().trim().isEmpty() ||
                etOtp3.getText().toString().trim().isEmpty() ||
                etOtp4.getText().toString().trim().isEmpty());
    }

    private String getOtp() {
        return etOtp1.getText().toString() +
                etOtp2.getText().toString() +
                etOtp3.getText().toString() +
                etOtp4.getText().toString();
    }

    public void verifyOTP(String code) {
        if (verificationId == null || verificationId.isEmpty()) {
            Toast.makeText(this, "Verification ID missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");

            Request request = new Request.Builder()
                    .url("https://cpaas.messagecentral.com/verification/v3/validateOtp?countryCode=91&mobileNumber=" +
                            mobileno + "&verificationId=" + verificationId + "&customerId="+ ConstantData.CUSTOMER_ID +"&code=" + code)
                    .method("GET", null)  // GET requests shouldn't have a body
                    .addHeader("authToken", ConstantData.AUTH_TOKEN )
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    runOnUiThread(() -> {
                        Toast.makeText(otpActivity.this, "Verification successful", Toast.LENGTH_SHORT).show();
                        //pending registeer api

                        new Login_Register_Api().registerUser(
                                this, new PersonModel("",username,email,mobileno,password,"","")
                        );
//                        Intent intent = new Intent(otpActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(otpActivity.this, "Invalid OTP. Try again!", Toast.LENGTH_SHORT).show());
                }
            } catch (IOException e) {
                Log.e("ERROR", e.getLocalizedMessage());
                runOnUiThread(() -> Toast.makeText(otpActivity.this, "Network error! Try again.", Toast.LENGTH_SHORT).show());
            }
        });
    }

    public  void setBoX(){

        etOtp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null){
                    if (editable.length() == 1){
                        etOtp2.requestFocus();
                    }
                }
            }
        });
        etOtp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null){
                    if (editable.length() == 1){
                        etOtp3.requestFocus();
                    }
                }
            }
        });
        etOtp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null){
                    if (editable.length() == 1){
                        etOtp4.requestFocus();
                    }
                }
            }
        });
        etOtp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                btnverify.setFocusable(true);
            }
        });

    }
}