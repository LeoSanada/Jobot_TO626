package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends Activity implements View.OnClickListener{

    public Button buttonSchedule1;
    public Button buttonSchedule2;
    public Button buttonSchedule3;
    public Button buttonChat1;
    public Button buttonChat2;
    public Button buttonChat3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        buttonSchedule1 = (Button) findViewById(R.id.buttonSchedule1);
        buttonSchedule2 = (Button) findViewById(R.id.buttonSchedule2);
        buttonSchedule3 = (Button) findViewById(R.id.buttonSchedule3);
        buttonChat1 = (Button) findViewById(R.id.buttonChat1);
        buttonChat2 = (Button) findViewById(R.id.buttonChat2);
        buttonChat3 = (Button) findViewById(R.id.buttonChat3);

        buttonSchedule1.setOnClickListener(this);
        buttonSchedule2.setOnClickListener(this);
        buttonSchedule3.setOnClickListener(this);
        buttonChat1.setOnClickListener(this);
        buttonChat2.setOnClickListener(this);
        buttonChat3.setOnClickListener(this);

    }

    //Menu method start here

    //Menu method end here


    @Override
    public void onClick(View view) {

    }
}
