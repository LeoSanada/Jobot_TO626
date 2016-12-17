package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class BioActivity extends Activity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        //BUTTON TO SEE PROFILE
        back = (Button) findViewById(R.id.backbutton);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent newPage = new Intent(BioActivity.this, CallActivity.class);
                startActivity(newPage);

            }
        });


    }
}