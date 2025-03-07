package com.example.afinal.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.afinal.Api.Data_Api;
import com.example.afinal.R;
import com.example.afinal.model.BannerModel;
import com.example.afinal.model.CatModel;
import com.example.afinal.model.CoupenModel;
import com.example.afinal.model.DataOutputModel;
import com.example.afinal.model.PincodeModel;
import com.example.afinal.model.ProModel;
import com.example.afinal.model.StoreModel;
import com.example.afinal.model.ToppingModel;
import com.example.afinal.utils.CatAdapter;
import com.example.afinal.utils.ConstantData;
import com.example.afinal.utils.ProAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    TextView tvUser;
    SharedPreferences sp;
    View v1;
    ImageSlider imageSlider;
    RecyclerView rcylCat,rcylPro;

    public ArrayList<BannerModel> banner;
    public ArrayList<CatModel> category;
    public ArrayList<ProModel> product;

    public HomeFragment(ArrayList<BannerModel> banner, ArrayList<CatModel> category, ArrayList<ProModel> product) {
        this.banner = banner;
        this.category = category;
        this.product = product;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v1= inflater.inflate(R.layout.fragment_home, container, false);
        return  v1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvUser = view.findViewById(R.id.tvUser);
        rcylCat = view.findViewById(R.id.rcylCat);
        rcylPro = view.findViewById(R.id.rcylPro);

        sp = getActivity().getSharedPreferences(ConstantData.SP_NAME, Context.MODE_PRIVATE);
        String user = sp.getString(ConstantData.KEY_SP_UNAME,"");
        tvUser.setText("Hello! "+user);

        imageSlider = view.findViewById(R.id.image_slider);
        setBanner();

    }

    public void setBanner() {

        ArrayList<SlideModel> imageList = new ArrayList<>();

        for (int i = 0;i < banner.size(); i++){
            imageList.add(
                    new SlideModel(
                            ConstantData.SERVER_ADDRESS + banner.get(i).getBanner_pic(),
                            null,
                            ScaleTypes.FIT
                    )
            );
        }
        imageSlider.setImageList(imageList);

        rcylCat.setLayoutManager(
                new LinearLayoutManager(
                        getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );
        rcylCat.setAdapter(new CatAdapter(category));

        rcylPro.setLayoutManager(
                new LinearLayoutManager(
                        getActivity(),
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );
        rcylPro.setAdapter(new ProAdapter(product));
    }

}