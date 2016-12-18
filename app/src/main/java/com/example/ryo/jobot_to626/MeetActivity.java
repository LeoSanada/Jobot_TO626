package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.List;

public class MeetActivity extends FragmentActivity implements View.OnClickListener{
    ViewPager viewpagerTopmenu;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView matchText1;
    private TextView matchText2;
    private TextView matchText3;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button infoButton1;
    private Button infoButton2;
    private Button infoButton3;
    private Button buttonGetMatches;
    private TextView labelMatches;
    List<Users> contactList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        matchText1 = (TextView) findViewById(R.id.matchText1);
        matchText2 = (TextView) findViewById(R.id.matchText2);
        matchText3 = (TextView) findViewById(R.id.matchText3);
        infoButton1 = (Button) findViewById(R.id.infoButton1);
        infoButton2 = (Button) findViewById(R.id.infoButton2);
        infoButton3 = (Button) findViewById(R.id.infoButton3);
        labelMatches = (TextView) findViewById(R.id.labelMatches);
        buttonGetMatches = (Button) findViewById(R.id.buttonGetMatches);


        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        infoButton1.setOnClickListener(this);
        infoButton2.setOnClickListener(this);
        infoButton3.setOnClickListener(this);
        buttonGetMatches.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    //Toast.makeText(PostTweetActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    Toast.makeText(MeetActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
                }
            }
        };


        Intent intent = getIntent();
        String jobChosen = intent.getStringExtra("job");
        labelMatches.setText(jobChosen + " matches");


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataUsers = database.getReference();


        dataUsers.child("users").orderByChild("status").equalTo(jobChosen).limitToLast(3).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Users users = dataSnapshot.getValue(Users.class);
                contactList.add(users);

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
    public void onClick(View view) {

        if (view == buttonGetMatches) {

            matchText1.setText(contactList.get(0).email);
            matchText2.setText(contactList.get(1).email);
            matchText3.setText(contactList.get(2).email);

            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.VISIBLE);
            infoButton1.setVisibility(View.VISIBLE);
            infoButton2.setVisibility(View.VISIBLE);
            infoButton3.setVisibility(View.VISIBLE);

        } else if (view == imageView2){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataContact = database.getReference("users");

            FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
            DatabaseReference dataNewContact = dataContact.child(currentuser.getUid().toString()).child("contactlist").push();

            dataNewContact.setValue(matchText1.getText().toString());
            Toast.makeText(MeetActivity.this, "Contact added!", Toast.LENGTH_SHORT).show();

        } else if (view == imageView3){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataContact = database.getReference("users");

            FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
            DatabaseReference dataNewContact = dataContact.child(currentuser.getUid().toString()).child("contactlist").push();

            dataNewContact.setValue(matchText2.getText().toString());
            Toast.makeText(MeetActivity.this, "Contact added!", Toast.LENGTH_SHORT).show();

        } else if (view == imageView4){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataContact = database.getReference("users");

            FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
            DatabaseReference dataNewContact = dataContact.child(currentuser.getUid().toString()).child("contactlist").push();

            dataNewContact.setValue(matchText3.getText().toString());
            Toast.makeText(MeetActivity.this, "Contact added!", Toast.LENGTH_SHORT).show();
        } else if (view == infoButton1){

            Intent intent = new Intent (this, BioActivity.class);
            intent.putExtra("contact", matchText1.getText());
            startActivity(intent);
        } else if (view == infoButton2){

            Intent intent = new Intent (this, BioActivity.class);
            intent.putExtra("contact", matchText2.getText());
            startActivity(intent);
        } else if (view == infoButton3){

            Intent intent = new Intent (this, BioActivity.class);
            intent.putExtra("contact", matchText3.getText());
            startActivity(intent);
        }









    }


}
