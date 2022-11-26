package com.example.softcolan_design;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class profile_tab3 extends Fragment {
    View view;
    ImageView img,logout;
    LinearLayout device,setting;
    TextView gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_tab3, container, false);
        img = view.findViewById(R.id.image_man_female);
        device=view.findViewById(R.id.ln1);
        setting=view.findViewById(R.id.ln2);
        logout=view.findViewById(R.id.logout);
        gender=view.findViewById(R.id.gender);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(getContext(),signIn.class);
                startActivity(login);
                getActivity().finish();
            }
        });
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Dialog d=new Dialog(getContext());
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.device_bottome_sheet);
                d.show();
                d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                d.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                d.getWindow().setGravity(Gravity.BOTTOM);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog d=new Dialog(getContext());
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.device_bottome_sheet);
                d.show();
                d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                d.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                d.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

//        String sc1,sc;
//        sc1=gender.getText().toString();
//        sc=sc1.toLowerCase();
//        switch (sc)
//        {
//            case "male" :
//            {
//                img.setImageResource(R.drawable.man);
//                break;
//            }
//            case "female" :
//            {
//                img.setImageResource(R.drawable.female);
//                break;
//            }
//            default:
//            {
//                img.setImageResource(R.drawable.ic_launcher_background);
//                break;
//            }
//        }

        return view;
    }
}