package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    LinearLayout laymain;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        laymain=findViewById(R.id.laymain);
        laymain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,slider.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
//        Handler hdlr=new Handler();
//        new Thread(new Runnable()
//        {
//            public void run()
//            {
//                while (i < 100)
//                {
//                    i += 2;
//                    hdlr.post(new Runnable()
//                    {
//                        public void run()
//                        {
//                            if(i==10)
//                            {
////                                if(Globals.saveFirstTimeLaunch(false))
////                                {
////                                    Globals.saveFirstTimeLaunch(false);
////                                    Intent i1=new Intent(MainActivity.this,slider.class);
////                                    startActivity(i1);
////                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
////                                }
////                                else
////                                {
////                                    Intent i2=new Intent(MainActivity.this,signIn.class);
////                                    startActivity(i2);
////                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
////                                    finish();
////                                }
//
//                            }
//                        }
//                    });
//                    try
//                    {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e)
//                    {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}