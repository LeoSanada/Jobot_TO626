package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class CallActivity extends Activity {

        @Override
        public String toString() {
            return super.toString();
        }

        Button call;
        Button profile;
        String phone_number;
        Integer have_called;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_call);
            have_called=0;

            if (have_called.equals(1)){

                Intent newPage = new Intent(CallActivity.this, FeedbackActivity.class);
                startActivity(newPage);

            }
            phone_number="tel:7347471547";

            //BUTTON TO MAKE CALL
            call = (Button) findViewById(R.id.callbutton);

            call.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
//                Toast toast = Toast.makeText(phone.this, "Calling" , Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 450);
//                toast.show();

                    if (have_called.equals(1)){

                        Intent newPage = new Intent(CallActivity.this, FeedbackActivity.class);
                        startActivity(newPage);

                    }

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse(phone_number));
                    startActivity(callIntent);
                    have_called=1;



                }
            });

            if (have_called.equals(1)){

                Intent newPage = new Intent(CallActivity.this, FeedbackActivity.class);
                startActivity(newPage);

            }

            //BUTTON TO SEE PROFILE
            profile = (Button) findViewById(R.id.profilebutton);

            profile.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
//

                    Intent newPage = new Intent(CallActivity.this, BioActivity.class);
                    startActivity(newPage);

                }
            });
        }
    }
