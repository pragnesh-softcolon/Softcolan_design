package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setGoal extends AppCompatActivity
{
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        next=findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(setGoal.this,home.class);
                startActivity(home);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
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