package com.example.softcolan_design;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class profile_tab3 extends Fragment {
    View view;
    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile_tab3, container, false);
        img = view.findViewById(R.id.image_man_female);
        if (true)
        {
            img.setImageResource(R.drawable.man);
        }
        else
        {
            img.setImageResource(R.drawable.female);
        }


        return view;
    }
}