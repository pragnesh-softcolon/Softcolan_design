package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class forgotPassword extends AppCompatActivity
{
    Button btnSend;
    TextView go_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btnSend=findViewById(R.id.btn_sent);
        go_signin=findViewById(R.id.go_signin);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent sentRequest=new Intent(forgotPassword.this,requestSent.class);
                startActivity(sentRequest);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });
        go_signin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent backLogin=new Intent(forgotPassword.this,signIn.class);
                startActivity(backLogin);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent backLogin=new Intent(forgotPassword.this,signIn.class);
        startActivity(backLogin);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        finish();
    }
}