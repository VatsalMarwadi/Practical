package com.example.afinal.fragment;

import static android.app.Activity.RESULT_OK;
import static android.widget.Toast.LENGTH_SHORT;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;
import com.example.afinal.activity.LoginActivity;
import com.example.afinal.activity.MainActivity;
import com.example.afinal.utils.ConstantData;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class ProfileFragment extends Fragment {

    TextView tvLogout,tvAbout,tvContact,tvUname,tvEmail,tvFaqs,tvPrivacy;
    LinearLayout tvEditProfile;
    View view;
    SharedPreferences sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLogout = view.findViewById(R.id.tvLogout);
        tvEditProfile = view.findViewById(R.id.tvEditProfile);
        tvFaqs = view.findViewById(R.id.tvFaqs);
        tvPrivacy = view.findViewById(R.id.tvPrivacy);
        tvAbout = view.findViewById(R.id.tvAbout);
        tvContact = view.findViewById(R.id.tvContact);
        tvUname = view.findViewById(R.id.tvUname);
        tvEmail = view.findViewById(R.id.tvEmail);

        sp = getActivity().getSharedPreferences(ConstantData.SP_NAME, Context.MODE_PRIVATE);
        String uname = sp.getString(ConstantData.KEY_SP_UNAME,"");
        String email = sp.getString(ConstantData.KEY_SP_EMAIL,"");
        tvUname.setText(uname);
        tvEmail.setText(email);

        tvLogout.setOnClickListener(v -> {

            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.apply();

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Exit")
                    .setMessage("Are You Sure To Exit?")
                    .setPositiveButton("Yes",(dialog, which) -> {
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                    })
                    .setNegativeButton("No",(dialog, which) -> {

                    }).show();
        });

        tvAbout.setOnClickListener(v -> {
            ((MainActivity)getActivity()).addFragment(new AboutFragment());
        });

        tvContact.setOnClickListener(v -> {
            ((MainActivity)getActivity()).addFragment(new ContactFragment());
        });

        tvFaqs.setOnClickListener(v -> {
            ((MainActivity)getActivity()).addFragment(new FaqsFragment());
        });

        tvPrivacy.setOnClickListener(v -> {
            ((MainActivity)getActivity()).addFragment(new PrivacyPolicyFragment());
        });

        tvEditProfile.setOnClickListener(v -> {
            ((MainActivity)getActivity()).addFragment(new EditProfileFragment());
        });

    }
}