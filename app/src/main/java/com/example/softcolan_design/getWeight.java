package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class getWeight extends AppCompatActivity
{
    Button next;
    TextView tv_weight;
    TextInputEditText ed_weight;
    float weight_tv,weight_ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_get_weight);
        next=findViewById(R.id.btn_next);
        tv_weight=findViewById(R.id.tv_weight);
        ed_weight=findViewById(R.id.ed_weight);
        Thread t = new Thread() {
            @Override
            public void run()
            {
                try {
                    while (!isInterrupted())
                    {
                        Thread.sleep(10);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run()
                            {
                                if(ed_weight.getText().toString().equals(""))
                                {
                                        tv_weight.setText("");
                                }
                                else
                                {
                                    updateTextView();
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
                Intent next=new Intent(getWeight.this,setGoal.class);
                startActivity(next);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
    }
    private void updateTextView()
    {
        weight_ed=Float.parseFloat(ed_weight.getText().toString());
        weight_tv= (float) (weight_ed*2.2);
        tv_weight.setText(ed_weight.getText().toString()+" KG "+"("+weight_tv+"  LB)");
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent backLogin=new Intent(getWeight.this,getHeight.class);
        startActivity(backLogin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}