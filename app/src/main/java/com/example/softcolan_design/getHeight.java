package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class getHeight extends AppCompatActivity
{
    Button next;
    TextView heightcm_tv,heightfoot_tv;
    SeekBar seekBar;
    double cm;
    double ft;
    String before,after;
    double input,ans1,ans2;
    final int n1=1,n10=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_get_height);
        next=findViewById(R.id.btn_next);
        seekBar=findViewById(R.id.seekBar);
        heightcm_tv=findViewById(R.id.tv_heightcm);
        heightfoot_tv=findViewById(R.id.tv_heightfoot);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                input=Double.parseDouble(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    while (!isInterrupted())
                    {
                        Thread.sleep(1);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                if(!(input==0))
                                {
                                    updateTextView();

                                }
                                else
                                {
                                    String zero=0+"'"+0+"'' ";
                                    heightfoot_tv.setText(zero);
                                    heightcm_tv.setText(" (0 cm)");
//                                    Snackbar snackbar = Snackbar.make(layout,"CM is 00",Snackbar.LENGTH_SHORT);
//                                    snackbar.show();
                                }
                            }
                        });
                    }
                }
                catch (InterruptedException e)
                {
                    Log.e("TAG","****"+e);
                }
            }
        };
        t.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(getHeight.this,getWeight.class);
                startActivity(next);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void updateTextView()
    {
        ans1=input+n10;
        ans2=ans1-n1;
        ft=ans2/10;
        cm=ft*30.48;
        DecimalFormat d=new DecimalFormat("#");
        String s=""+d.format(cm);
        heightcm_tv.setText("("+s+ " cm)");
        String str=""+ft;
        try
        {
            StringTokenizer tokens = new StringTokenizer(str, "\\.");
            before = tokens.nextToken();
            after = tokens.nextToken();
            String finel_ans=before+"'"+after+"'' ";
            heightfoot_tv.setText(finel_ans);

        }
        catch (Exception e)
        {
            Log.e("TAG","Exeption is "+e);
        }
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent backLogin=new Intent(getHeight.this,getAge.class);
        startActivity(backLogin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}