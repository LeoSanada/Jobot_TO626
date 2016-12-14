package com.example.ryo.jobot_to626;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends Activity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener();



    }

    @Override
    public void onClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataChat = database.getReference();
        dataChat.child(Chat).orderByKey().limitToLast(999).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Chat chat = dataSnapshot.getValue(Chat.class);

                String me = user.getEmail();
                String person1 = Chat.from;
                String person2 = Chat.to;

                if (me == person1 || me == person2){

                    if (otherperson == person1 || other person == person2) {

                        String val = Chat.from + "\n" + Chat.to + "\n" + Chat.message;

                        textViewget.setText(val);



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
