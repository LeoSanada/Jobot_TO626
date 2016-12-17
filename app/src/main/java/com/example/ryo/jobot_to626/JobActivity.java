package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JobActivity extends Activity implements View.OnClickListener{

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
    }

    @Override
    public void onClick(View v) {

        if (v == infoButton1){
            Intent intent = new Intent(this, WikiDbActivity.class);
            startActivity(intent);
        }
        else if (v == infoButton2){
            Intent intent = new Intent(this, WikiDbActivity.class);
            startActivity(intent);
        }
        else if (v == infoButton3){
            Intent intent = new Intent(this, WikiDbActivity.class);
            startActivity(intent);
        }
        else if (v == infoButton4){
            Intent intent = new Intent(this, WikiDbActivity.class);
            startActivity(intent);
        }
        else if (v == matchText1){
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        }

        else if (v == matchText2){
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        }

        else if (v == matchText3){
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        }

        else if (v == matchText4){
            Intent intent = new Intent(this, HistoryActivity.class);
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
