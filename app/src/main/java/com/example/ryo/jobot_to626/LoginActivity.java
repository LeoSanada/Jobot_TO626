package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity implements View.OnClickListener{
    private Button buttonLogin;
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPWD;
    //private RadioButton radioButtonStudent;
    //private RadioButton radioButtonProfessional;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPWD = (EditText) findViewById(R.id.editTextPWD);
        //radioButtonStudent =(RadioButton) findViewById(R.id.radioButtonStudent);
        //radioButtonProfessional = (RadioButton) findViewById(R.id.radioButtonProfessional);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        //radioButtonProfessional.setOnClickListener(this);
        //radioButtonStudent.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                    Toast.makeText(LoginActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                    Toast.makeText(LoginActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
                }
                // ...
            }
        };


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

    @Override
    public void onClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPWD.getText().toString();

        if (view == buttonLogin) {
            signIn(email, password);
        } else if (view == buttonRegister) {
            createAccount(email, password);
            signIn(email, password);
        }

    }
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Authentication failed,Please register first!",
                                    Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(LoginActivity.this,BasicActivity.class);
                            //startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity.this, "Go to Assessment Page", Toast.LENGTH_SHORT).show();
                            //new AlertDialog.Builder(LoginActivity.this)
                              //      .setMessage("Where?")
                                //    .setNegativeButton("Go to Monitor", new DialogInterface.OnClickListener() {
                                  //      @Override
                                    //    public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(LoginActivity.this, AssessmentActivity.class);
                                            startActivity(intent);
                                  //      }
                                  //  })
                                  //  .setPositiveButton("Go to Purchase", new DialogInterface.OnClickListener() {
                                  //      @Override
                                  //      public void onClick(DialogInterface dialogInterface, int i) {
                                  //          Intent intent = new Intent(LoginActivity.this, BasicActivity.class);
                                  //          startActivity(intent);
                                  //      }
                                  //  })
                                  //  .show();

                        }
                    }
                });
    }

    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Authentication failed and Go To Register Page.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,BasicActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }
}
