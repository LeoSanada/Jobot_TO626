package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class FeedbackActivity extends Activity {

    RatingBar ratingBarOne;
    RatingBar ratingBarTwo;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBarOne = (RatingBar)findViewById(R.id.ratingbar_one);
        ratingBarTwo = (RatingBar)findViewById(R.id.ratingbar_two);

        submit_btn = (Button)findViewById(R.id.submit_butt);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating_one = String.valueOf(ratingBarOne.getRating());
                String rating_two = String.valueOf(ratingBarTwo.getRating());

                Toast.makeText(FeedbackActivity.this,"Thank you! Your answers have been recorded",Toast.LENGTH_LONG).show();

                Intent newPage = new Intent(FeedbackActivity.this, AssessmentActivity.class);
                startActivity(newPage);
            }
        });


    }
}
