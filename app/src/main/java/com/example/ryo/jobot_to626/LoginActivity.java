package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class LoginActivity extends Activity {
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
    }
}
