package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WikiDbActivity extends Activity implements View.OnClickListener{

    private Button buttonBack;
    private TextView textViewJobTitle;
    private TextView textViewDescription;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_db);

        Bundle bundle = getIntent().getExtras();

        String job = bundle.getString("job");
        textViewJobTitle = (TextView) findViewById(R.id.textViewJobTitle);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);

        textViewJobTitle.setText(job + " Information");
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataJobs = database.getReference("Job Titles");

        dataJobs.child(job).orderByKey().equalTo("Description").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String description = dataSnapshot.getValue().toString();

                textViewDescription.setText(description);


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
        Intent newPage = new Intent(WikiDbActivity.this, JobActivity.class);
        startActivity(newPage);
    }
}
