package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ProfessionalMainActivity extends Activity implements View.OnClickListener {

    private Button active_chats;
    private Button scheduled_calls;
    private Button new_call;
    private Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional_main);


        active_chats = (Button) findViewById(R.id.active_chats);
        scheduled_calls = (Button) findViewById(R.id.scheduled_calls);
        new_call = (Button) findViewById(R.id.schedule_new_call);
        profile = (Button) findViewById(R.id.professional_profile);

        active_chats.setOnClickListener(this);
        scheduled_calls.setOnClickListener(this);
        new_call.setOnClickListener(this);
        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == active_chats) {
            Intent intent = new Intent(ProfessionalMainActivity.this, HistoryActivity.class);
            startActivity(intent);
        }

        if (view == scheduled_calls) {
            Intent intent = new Intent(ProfessionalMainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        if (view == new_call) {
            Intent intent = new Intent(ProfessionalMainActivity.this, ScheduleProfActivity.class);
            startActivity(intent);
        }

        if (view == profile) {
            Intent intent = new Intent(ProfessionalMainActivity.this, BasicActivity.class);
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
