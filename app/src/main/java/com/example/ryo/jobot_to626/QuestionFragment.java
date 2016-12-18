package com.example.ryo.jobot_to626;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private TextView textViewQuestion;
    private Button buttonNo;
    private Button buttonYes;
    private Integer ScoreChange = 0;
    private Integer thisID;
    private Integer totalscore = 0;
    private String uid;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_question,container, false);
        textViewQuestion = (TextView)view.findViewById(R.id.textViewQuestion);

        buttonNo = (Button) view.findViewById(R.id.buttonNo);
        buttonNo.setOnClickListener(this);
        buttonNo.setBackgroundColor(Color.LTGRAY);

        buttonYes = (Button) view.findViewById(R.id.buttonYes);
        buttonYes.setOnClickListener(this);
        buttonYes.setBackgroundColor(Color.LTGRAY);

        final Bundle bundle = getArguments();
        final Integer count = bundle.getInt("count");



        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dataQuestions = database.getReference("questions");
        final DatabaseReference dataUsers = database.getReference("users");

        dataQuestions.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Question Q = dataSnapshot.getValue(Question.class);
                if (count == Q.id) {
                    String question = Q.question;
                    thisID = Q.id;
                    textViewQuestion.setText("Question "+thisID+":\n"+question);

                    dataUsers.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Integer score = 0;
                            if (dataSnapshot.child(uid).child("score").hasChild(count.toString())) {
                                score = dataSnapshot.child(uid).child("score").child(count.toString()).getValue(Integer.class);
                            }
                            if (score == 1) {
                                buttonYes.setBackgroundColor(Color.argb(255,228,106,52));
                            } else if (score == -1){
                                buttonNo.setBackgroundColor(Color.argb(255,228,106,52));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
            }
        };

        FirebaseUser currentuser = mAuth.getCurrentUser();
        uid = currentuser.getUid();

        return view;
    }

    @Override
    public void onClick(View v) {


        if (v==buttonNo) {
            ScoreChange = -1;
            buttonNo.setBackgroundColor(Color.argb(255,228,106,52));
            buttonYes.setBackgroundColor(Color.LTGRAY);
        } else if (v==buttonYes) {
            ScoreChange = 1;
            buttonNo.setBackgroundColor(Color.LTGRAY);
            buttonYes.setBackgroundColor(Color.argb(255,228,106,52));
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dataQuestions = database.getReference("questions");
        final DatabaseReference dataUsers = database.getReference("users");

        dataQuestions.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Question Q = dataSnapshot.getValue(Question.class);
                if (thisID == Q.id) {
                    if (ScoreChange != 0) {
                        //dataSnapshot.getRef().child("score").setValue(ScoreChange);
                        dataUsers.child(uid).child("score").child(thisID.toString()).setValue(ScoreChange);
                        totalscore = 0;
                        dataUsers.child(uid).child("score").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                dataUsers.child(uid).child("score").child("totalscore").setValue(0);
                                if (dataSnapshot.getKey().equals("totalscore")) {
                                    dataUsers.child(uid).child("score").child("totalscore").setValue(totalscore);
                                } else {
                                    totalscore = totalscore + dataSnapshot.getValue(Integer.class);
                                }
                            }

                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
