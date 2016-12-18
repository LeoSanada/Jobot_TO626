package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SchedulingActivity extends FragmentActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    Integer Butt;
    ViewPager viewpagerTopmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        setupButton();
        Butt = 5;
        mAuth = FirebaseAuth.getInstance();
    }


    //-----------------------------------------------
    //------------  RADIO BUTTON  -------------------
    //-----------------------------------------------

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.option_one:
                if (checked)
                    Butt = 1;
                break;
            case R.id.option_two:
                if (checked)
                    Butt = 2;
                break;
            case R.id.option_three:
                if (checked)
                    Butt = 3;
                break;
            case R.id.option_four:
                if (checked)
                    Butt = 4;
                break;

        }
    }

    //-----------------------------------------------
    //-----------   LOGIN BUTTON  -------------------
    //-----------------------------------------------

    private void setupButton() {
        // 1. Create a reference to the button
        Button scheduleButton = (Button) findViewById(R.id.schedule_butt);

        // 2. Set the click listener to run my code

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Setup User Name Input Read

                // If the Password is correct the Button will send you to either Settings Screen or

                if (Butt.equals(1)) {

//                    FirebaseDatabase database = FirebaseDatabase.getInstance();
//                    DatabaseReference dataTweets = database.getReference("users");
//                    DatabaseReference dataNewTweets = dataTweets.push();
//
//                    String tweet_n = tweet.getText().toString();
//                    String name = mAuth.getCurrentUser().getEmail();
//
//                    tweets tweet = new tweets(tweet_n, name);
//                    dataNewTweets.setValue(tweet);


                    Toast toast = Toast.makeText(SchedulingActivity.this, "Your Call has Been Scheduled!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent newPage = new Intent(SchedulingActivity.this, CallActivity.class);
                    startActivity(newPage);

                }

                if (Butt.equals(2)) {
                    Toast toast = Toast.makeText(SchedulingActivity.this, "Your Call has Been Scheduled!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent newPage = new Intent(SchedulingActivity.this, CallActivity.class);
                    startActivity(newPage);
                }

                if (Butt.equals(3)) {
                    Toast toast = Toast.makeText(SchedulingActivity.this, "Your Call has Been Scheduled!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent newPage = new Intent(SchedulingActivity.this, CallActivity.class);
                    startActivity(newPage);
                }

                if (Butt.equals(4)) {
                    Toast toast = Toast.makeText(SchedulingActivity.this, "Your Call has Been Schelued!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent newPage = new Intent(SchedulingActivity.this, CallActivity.class);
                    startActivity(newPage);
                }

                // If Password is correct, but user did not specify
                if (Butt.equals(5)) {

                    Toast toast = Toast.makeText(SchedulingActivity.this, "Please Select one time slot above", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, -100);
                    toast.show();

                }


            }
        });

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
            startActivity(new Intent(this, LoginActivity.class));

        }
        return super.onOptionsItemSelected(item);

    }
}
