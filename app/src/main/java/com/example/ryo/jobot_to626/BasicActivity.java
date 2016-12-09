package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BasicActivity extends Activity implements View.OnClickListener{
    private Button buttonSignin;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPWD;
    private EditText editTextInfo;
    //private RadioButton radiobuttonStudent;
    //private RadioButton radioButtonDoctor;
    //private RadioButton radioButtonLawyer;
    //private RadioButton radioButtonEngineer;
    //private RadioButton radioButtonTeacher;
    private RadioGroup radioGroupStatus;
    private RadioButton radioButtonStatus;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        //buttonSignin = (Button) findViewById(R.id.buttonSignin);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
        editTextInfo = (EditText) findViewById(R.id.editTextInfo);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPWD = (EditText) findViewById(R.id.editTextPWD);
        //radioButtonDoctor = (RadioButton) findViewById(R.id.radioButtonDoctor);
        //radioButtonEngineer = (RadioButton) findViewById(R.id.radioButtonEngineer);
        //radioButtonLawyer = (RadioButton) findViewById(R.id.radioButtonLawyer);
        //radiobuttonStudent = (RadioButton) findViewById(R.id.radioButtonStudent);
        //radioButtonTeacher = (RadioButton) findViewById(R.id.radioButtonTeacher);

        //buttonSignin.setOnClickListener(this);
   //     radioButtonDoctor.setOnClickListener(this);
   //     radioButtonTeacher.setOnClickListener(this);
   //     radiobuttonStudent.setOnClickListener(this);
   //     radioButtonLawyer.setOnClickListener(this);
   //     radioButtonEngineer.setOnClickListener(this);



        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //Toast.makeText(BasicActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(BasicActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BasicActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };

        addListenerOnButton();

    }



    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void addListenerOnButton() {
        radioGroupStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        buttonSignin = (Button) findViewById(R.id.buttonSignin);

        buttonSignin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroupStatus.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButtonStatus = (RadioButton) findViewById(selectedId);

                //Toast.makeText(BasicActivity.this,
                        //"Status is" + radioButtonStatus.getText(), Toast.LENGTH_SHORT).show();

                Toast.makeText(BasicActivity.this,"Go to Assessment Page",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BasicActivity.this,AssessmentActivity.class);
                startActivity(intent);


            }

        });
    }

    @Override
    public void onClick(View view) {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String briefinfo = editTextInfo.getText().toString();
        String status = radioButtonStatus.getText().toString();

        Users users = new Users(name, email, briefinfo,status);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataPurchases = database.getReference("users");
        DatabaseReference dataNewPurchase = dataPurchases.push();
        dataNewPurchase.setValue(users);


    }


}



