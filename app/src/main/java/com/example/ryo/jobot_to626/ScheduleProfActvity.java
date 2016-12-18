package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScheduleProfActvity extends Activity {

    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    //    DateFormat df = new
    Button TimeButt;
    Button DateButt;
    Button CallButt;
    Integer a;
    String new_date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm aa");
    TextView text;
    Calendar dateTime = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_prof_actvity);
        a=0;

        text = (TextView) findViewById(R.id.date_time_text);

        //BUTTON TO SET TIME
        TimeButt = (Button) findViewById(R.id.time_button);
        TimeButt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateTime();
                a=1;
            }
        });


        //BUTTON TO SET DATE
        DateButt = (Button) findViewById(R.id.date_button);
        DateButt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateDate();
                a=1;
            }
        });


        //BUTTON TO GO TO 'PHONE' ACTIVITY (SHOULD ADD IF STATEMENT FOR WHEN USER HAS NOT INPUT ITS DATE)
        CallButt = (Button) findViewById(R.id.call_butt);
        CallButt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Toast.makeText(ScheduleProfActvity.this, "Your Availability was Registered!", Toast.LENGTH_SHORT).show();
                Intent newPage = new Intent(ScheduleProfActvity.this, ProfessionalMainActivity.class);
                startActivity(newPage);
            }
        });


        if (a.equals(1))
        {
            updateTextLabel();
        }
    }




    /////////////////////////////////////
    // CREATE DIALOG FOR PICKING DATES //
    /////////////////////////////////////

    private void updateDate()
    {
        new DatePickerDialog(this, d, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, month);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTextLabel();
        }
    };


    ///////////////////////////////////
    // CREATE DIALOG FOR PICKING TIME //
    ///////////////////////////////////

    private void updateTime()
    {
        new TimePickerDialog(this, t, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE),true).show();
    }

    TimePickerDialog.OnTimeSetListener t= new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute)
        {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            updateTextLabel();
        }

    };


    // UPDATE TEXT EVERYTIME USER PICS A TIME & DATE
    private void updateTextLabel()
    {
        new_date = formatDateTime.format(dateTime.getTime());
        new_date= new_date.substring(0, new_date.length()-6) + new_date.substring(new_date.length()-3, new_date.length()) ;
        text.setText(new_date);

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
