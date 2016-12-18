package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AssessmentActivity extends FragmentActivity {


    ViewPager viewpagerTopmenu;

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new SwipeAdapter(getSupportFragmentManager()));
    }


    /////////////////////////////////
    /////////   MENU   /////////////
    /////////////////////////////////


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId() == R.id.logout_menu) {
            startActivity(new Intent(AssessmentActivity.this, LoginActivity.class));

        }
        return super.onOptionsItemSelected(item);

    }
}
