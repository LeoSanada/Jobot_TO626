package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class WikiDbActivity extends Activity implements View.OnClickListener{

    private Button buttonBack;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_db);

        Bundle bundle = getIntent().getExtras();

        String job = bundle.getString("job");
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        Intent newPage = new Intent(WikiDbActivity.this, JobActivity.class);
        startActivity(newPage);
    }
}
