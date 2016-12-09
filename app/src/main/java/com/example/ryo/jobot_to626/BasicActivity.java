package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BasicActivity extends Activity implements View.OnClickListener{
    private Button buttonSignin;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPWD;
    private EditText editTextInfo;
    private RadioButton radiobuttonStudent;
    private RadioButton radioButtonDoctor;
    private RadioButton radioButtonLawyer;
    private RadioButton radioButtonEngineer;
    private RadioButton radioButtonTeacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        buttonSignin = (Button) findViewById(R.id.buttonSignin);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        editTextInfo = (EditText) findViewById(R.id.editTextInfo);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPWD = (EditText) findViewById(R.id.editTextPWD);
        radioButtonDoctor = (RadioButton) findViewById(R.id.radioButtonDoctor);
        radioButtonEngineer = (RadioButton) findViewById(R.id.radioButtonEngineer);
        radioButtonLawyer = (RadioButton) findViewById(R.id.radioButtonLawyer);
        radiobuttonStudent = (RadioButton) findViewById(R.id.radioButtonStudent);
        radioButtonTeacher = (RadioButton) findViewById(R.id.radioButtonTeacher);

        buttonSignin.setOnClickListener(this);
        radioButtonDoctor.setOnClickListener(this);
        radioButtonTeacher.setOnClickListener(this);
        radiobuttonStudent.setOnClickListener(this);
        radioButtonLawyer.setOnClickListener(this);
        radioButtonEngineer.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

    }
}
