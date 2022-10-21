package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup_screen1 extends AppCompatActivity
{
    Button male,female,female2,btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_signup_screen1);
        male=findViewById(R.id.btn_gendar_male);
        female=findViewById(R.id.btn_gendar_female);
        female2=findViewById(R.id.btn_gendar_female2);
        btn_next=findViewById(R.id.btn_next);
        male.setBackground(getResources().getDrawable(R.drawable.buttone_style));
        male.setTextColor(getResources().getColor(R.color.white));
        female.setBackground(getResources().getDrawable(R.drawable.gender_inactive));
        female.setTextColor(getResources().getColor(R.color.blue));
        male.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                female2.setVisibility(View.GONE);
                male.setBackground(getResources().getDrawable(R.drawable.buttone_style));
                male.setTextColor(getResources().getColor(R.color.white));
                female.setBackground(getResources().getDrawable(R.drawable.gender_inactive));
                female.setTextColor(getResources().getColor(R.color.blue));
            }
        });
        female.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                female2.setVisibility(View.VISIBLE);
                male.setBackground(getResources().getDrawable(R.drawable.gender_inactive));
                male.setTextColor(getResources().getColor(R.color.blue));
                female.setBackground(getResources().getDrawable(R.drawable.buttone_style));
                female.setTextColor(getResources().getColor(R.color.white));
                female2.setBackground(getResources().getDrawable(R.drawable.buttone_style));
                female2.setTextColor(getResources().getColor(R.color.white));
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(signup_screen1.this,getAge.class);
                startActivity(next);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent backLogin=new Intent(signup_screen1.this,signIn.class);
        startActivity(backLogin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}