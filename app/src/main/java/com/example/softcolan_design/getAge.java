package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shawnlin.numberpicker.NumberPicker;

public class getAge extends AppCompatActivity
{
    Button btn_next;
    NumberPicker number_picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_get_age);
        btn_next=findViewById(R.id.btn_next);
        number_picker=findViewById(R.id.number_picker);
        number_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                Toast.makeText(getAge.this, "Age is "+newVal, Toast.LENGTH_SHORT).show();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(getAge.this,getHeight.class);
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
        Intent backLogin=new Intent(getAge.this,signup_screen1.class);
        startActivity(backLogin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}