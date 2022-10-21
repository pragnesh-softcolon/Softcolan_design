package com.example.softcolan_design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class home extends AppCompatActivity
{
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_home);
        bnView=findViewById(R.id.bn_view);
        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id=item.getItemId();
                final int tab1=R.id.page_1;
                final int tab2=R.id.page_2;
                final int tab3=R.id.page_3;
                switch (id)
                {
                    case tab1:
                    {
                        loadFrag(new home_tab1(),true);

                        break;
                    }
                    case tab2:
                    {
                        loadFrag(new training_tab2(),false);
                        break;
                    }
                    case tab3:
                    {
                        loadFrag(new profile_tab3(),false);
                        break;
                    }
                    default:
                    {

                        break;
                    }
                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.page_1);
    }
    public void loadFrag(Fragment fragment,Boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.containar,fragment);
        else
            ft.replace(R.id.containar,fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }
}