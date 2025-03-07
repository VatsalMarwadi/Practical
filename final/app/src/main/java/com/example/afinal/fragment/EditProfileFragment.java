package com.example.afinal.fragment;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.afinal.R;
import com.example.afinal.activity.LoginActivity;
import com.example.afinal.activity.MainActivity;
import com.example.afinal.utils.ConstantData;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class EditProfileFragment extends Fragment {

    SharedPreferences sp;
    ImageView ivuser;
    EditText etUname,etEmail,etContact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etUname = view.findViewById(R.id.etUname);
        etEmail = view.findViewById(R.id.etEmail);
        etContact = view.findViewById(R.id.etContact);

        sp = getActivity().getSharedPreferences(ConstantData.SP_NAME, Context.MODE_PRIVATE);
        String uname = sp.getString(ConstantData.KEY_SP_UNAME,"");
        String email = sp.getString(ConstantData.KEY_SP_EMAIL,"");
        String mobile = sp.getString(ConstantData.KEY_SP_MOBILE_NO,"");
        etUname.setText(uname);
        etEmail.setText(email);
        etContact.setText(mobile);

        ivuser = view.findViewById(R.id.ivuser);

        ivuser.setOnClickListener(v -> {
            ImagePicker.with(this)
                    .crop()	    			//Crop image(Optional), Check Customization for more option
                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start(1001);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {
                    ivuser.setImageURI(uri);
                }
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                String error = ImagePicker.Companion.getError(data);
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Task Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

}