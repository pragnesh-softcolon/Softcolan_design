package com.example.softcolan_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class slider extends AppCompatActivity implements View.OnClickListener
{
    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    int[] layouts = new int[]{R.layout.hms1, R.layout.hms2, R.layout.hms3,R.layout.hms4};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        // Checking for first time launch - before calling setContentView()
        if (!Globals.shouldShowSlider())
        {
            launchHomeScreen();
            finish();
        }
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            if (window != null)
            {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
        setContentView(R.layout.activity_slider);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        addBottomDots();
        updateBottomDots(0, 0);
        setOnClickListener(R.id.tv4);
        viewPager.setAdapter(new MyViewPagerAdapter());
        viewPager.addOnPageChangeListener(pageChangeListener);

        // adding bottom dots

        // By default, select dot in the first position


    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
    private void setOnClickListener(int id)
    {
        TextView tv = (TextView) findViewById(id);
        if (tv != null)
        {
            tv.setOnClickListener(this);
        }
    }
    private void launchHomeScreen()
    {
        Globals.saveFirstTimeLaunch(true);
//        Globals.saveFirstTimeLaunch(false);
        Intent signin=new Intent(slider.this,signIn.class);
        startActivity(signin);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        finish();
    }


    private void addBottomDots()
    {
        if ((dotsLayout == null) || (layouts == null))
            return;
        int dotSize = layouts.length;
        dotsLayout.removeAllViews();
        dots = new TextView[dotSize];
        for (int i = 0; i < dots.length-1; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        dots[0].setTextColor(this.getResources().getColor(R.color.dot_active));
        dots[1].setTextColor(this.getResources().getColor(R.color.dot_inactive));
        dots[2].setTextColor(this.getResources().getColor(R.color.dot_inactive));
    }

    private void updateBottomDots(int prevPosition, int curPosition)
    {
        if (dots == null)
            return;
        int dotLength = dots.length-1;
        if ((dotLength > prevPosition) && (dotLength > curPosition))
        {
            dots[prevPosition].setTextColor(getResources().getColor(R.color.dot_inactive));
            dots[curPosition].setTextColor(getResources().getColor(R.color.dot_active));
        }
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener()
    {
        int prevPos = 0;
        @Override
        public void onPageSelected(int position)
        {
            updateBottomDots(prevPos, position);
            boolean isLastPage = (position == (layouts.length-1));
            if(isLastPage==true)
            {
                Intent i=new Intent(slider.this,signIn.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();

            }
            prevPos = position;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {
        }
    };

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv4:
            {
                Intent i=new Intent(slider.this,signIn.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
                break;
            }
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter
    {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter()
        {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount()
        {
            return (layouts != null) ? layouts.length : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj)
        {
            return (view == obj);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}