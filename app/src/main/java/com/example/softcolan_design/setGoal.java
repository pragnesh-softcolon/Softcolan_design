package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class setGoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent back=new Intent(setGoal.this,getWeight.class);
        startActivity(back);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}