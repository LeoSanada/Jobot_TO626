package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HistoryActivity extends FragmentActivity implements View.OnClickListener {

    ViewPager viewpagerTopmenu;

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;


    private AlertDialog.Builder dialogBuilder;

    private TextView name1;
    private TextView name2;
    private TextView name3;
    private TextView name4;

    private TextView profession1;
    private TextView profession2;
    private TextView profession3;
    private TextView profession4;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        button1 = (Button) findViewById(R.id.infoButton1);
        button2 = (Button) findViewById(R.id.infoButton2);
        button3 = (Button) findViewById(R.id.infoButton3);
        button4 = (Button) findViewById(R.id.infoButton4);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
    }

    //Menu method start here

    //Menu method end here




    private void DialogueBox1(){


        dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setTitle("Please Select One:");
//        dialogBuilder.setMessage("");
//        dialogBuilder.setView
        dialogBuilder.setPositiveButton("Schedule A Call", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog,int which)
            {
                schedule();
            }

        });

        dialogBuilder.setNegativeButton("Go to Chat", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog,int which)
            {
                Intent intentChat = new Intent(HistoryActivity.this, ChatActivity.class);
                startActivity(intentChat);
            }

        }).show();

    }



    // Method that determines whether user is student or professional and takes them to the correct scheduling page

    private void schedule()
    {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataUsers = database.getReference("users");

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = mAuth.getCurrentUser();
        String uid = currentuser.getUid();
        dataUsers.child(uid).child("status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().equals("Student")) {

                    Intent intent = new Intent(HistoryActivity.this, SchedulingActivity.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(HistoryActivity.this, ScheduleProfActvity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == button1) {
            DialogueBox1();
        }
        if (view == button2) {
            DialogueBox1();
        }
        if (view == button3) {
            DialogueBox1();
        }
        if (view == button4) {
            DialogueBox1();
        }
    }

    /////////////////////////////////
    /////////   MENU   /////////////
    /////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {

        if (item.getItemId() == R.id.logout_menu) {
            mAuth.signOut();
            startActivity(new Intent(this, LoginActivity.class));

        }
        return super.onOptionsItemSelected(item);

    }

}