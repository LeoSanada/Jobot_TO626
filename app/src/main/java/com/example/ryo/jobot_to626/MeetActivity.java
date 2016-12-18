package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MeetActivity extends FragmentActivity {
    ViewPager viewpagerTopmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));


        //still to code


    }
}
