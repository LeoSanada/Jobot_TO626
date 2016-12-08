package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class LoginActivity extends Activity implements View.OnClickListener{
    private Button buttonLogin;
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPWD;
    private RadioButton radioButtonStudent;
    private RadioButton radioButtonProfessional;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPWD = (EditText) findViewById(R.id.editTextPWD);
        radioButtonStudent =(RadioButton) findViewById(R.id.radioButtonStudent);
        radioButtonProfessional = (RadioButton) findViewById(R.id.radioButtonProfessional);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        radioButtonProfessional.setOnClickListener(this);
        radioButtonStudent.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

    }
}
