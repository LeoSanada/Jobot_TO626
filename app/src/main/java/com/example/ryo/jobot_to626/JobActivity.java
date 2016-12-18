package com.example.ryo.jobot_to626;

import android.app.Activity;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class JobActivity extends FragmentActivity implements View.OnClickListener{

    ViewPager viewpagerTopmenu;
    private Button infoButton1;
    private Button infoButton2;
    private Button infoButton3;
    private Button infoButton4;
    private TextView matchPercent1;
    private TextView matchPercent2;
    private TextView matchPercent3;
    private TextView matchPercent4;
    private TextView matchText1;
    private TextView matchText2;
    private TextView matchText3;
    private TextView matchText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        infoButton1 = (Button) findViewById(R.id.infoButton1);

        infoButton2 = (Button) findViewById(R.id.infoButton2);
        infoButton3 = (Button) findViewById(R.id.infoButton3);
        infoButton4 = (Button) findViewById(R.id.infoButton4);
        matchPercent1 = (TextView) findViewById(R.id.matchPercent1);
        matchPercent2 = (TextView) findViewById(R.id.matchPercent2);
        matchPercent3 = (TextView) findViewById(R.id.matchPercent3);
        matchPercent4 = (TextView) findViewById(R.id.matchPercent4);
        matchText1 = (TextView) findViewById(R.id.matchText1);
        matchText2 = (TextView) findViewById(R.id.matchText2);
        matchText3 = (TextView) findViewById(R.id.matchText3);
        matchText4 = (TextView) findViewById(R.id.matchText4);

        infoButton1.setOnClickListener(this);
        infoButton2.setOnClickListener(this);
        infoButton3.setOnClickListener(this);
        infoButton4.setOnClickListener(this);
        matchText1.setOnClickListener(this);
        matchText2.setOnClickListener(this);
        matchText3.setOnClickListener(this);
        matchText4.setOnClickListener(this);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataUsers = database.getReference("users");

        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();


        dataUsers.child(currentuser.getUid().toString()).child("score").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String totalScore = dataSnapshot.getValue().toString();
                int score = Integer.parseInt(totalScore);

                if (score == 9) {
                    matchText1.setText("Lawyer");
                    matchText2.setText("Doctor");
                    matchText3.setText("Engineer");
                    matchText4.setText("Manager");
                    matchPercent1.setText("100%");
                    matchPercent2.setText("75%");
                    matchPercent3.setText("50%");
                    matchPercent4.setText("25%");
                } else if (score < 9 && score > 5){
                    matchText1.setText("Doctor");
                    matchText2.setText("Lawyer");
                    matchText3.setText("Engineer");
                    matchText4.setText("Manager");
                    matchPercent1.setText("100%");
                    matchPercent2.setText("70%");
                    matchPercent3.setText("33%");
                    matchPercent4.setText("30%");
                } else if (score < 5 && score > 0){
                    matchText1.setText("Engineer");
                    matchText2.setText("Manager");
                    matchText3.setText("Lawyer");
                    matchText4.setText("Doctor");
                    matchPercent1.setText("100%");
                    matchPercent2.setText("60%");
                    matchPercent3.setText("40%");
                    matchPercent4.setText("20%");
                } else if (score < 0){
                    matchText1.setText("Manager");
                    matchText2.setText("Engineer");
                    matchText3.setText("Doctor");
                    matchText4.setText("Lawyer");
                    matchPercent1.setText("100%");
                    matchPercent2.setText("50%");
                    matchPercent3.setText("20%");
                    matchPercent4.setText("10%");
                }


            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == infoButton1){
            Intent intent = new Intent(this, WikiDbActivity.class);
            intent.putExtra("job",matchText1.getText());
            startActivity(intent);


        }
        else if (v == infoButton2){
            Intent intent = new Intent(this, WikiDbActivity.class);
            intent.putExtra("job",matchText2.getText());
            startActivity(intent);
        }
        else if (v == infoButton3){
            Intent intent = new Intent(this, WikiDbActivity.class);
            intent.putExtra("job",matchText3.getText());
            startActivity(intent);
        }
        else if (v == infoButton4){
            Intent intent = new Intent(this, WikiDbActivity.class);
            intent.putExtra("job",matchText4.getText());
            startActivity(intent);
        }
        else if (v == matchText1){
            Intent intent = new Intent(this, MeetActivity.class);
            intent.putExtra("job",matchText1.getText());
            startActivity(intent);
        }

        else if (v == matchText2){
            Intent intent = new Intent(this, MeetActivity.class);
            intent.putExtra("job",matchText2.getText());
            startActivity(intent);
        }

        else if (v == matchText3){
            Intent intent = new Intent(this, MeetActivity.class);
            intent.putExtra("job",matchText3.getText());
            startActivity(intent);
        }

        else if (v == matchText4){
            Intent intent = new Intent(this, MeetActivity.class);
            intent.putExtra("job",matchText4.getText());
            startActivity(intent);
        }
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
