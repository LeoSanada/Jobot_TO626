package com.example.ryo.jobot_to626;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends FragmentActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText editTextMessage;
    private TextView textViewGet;
    private Button buttonSend;
    private Integer msgcount;
    private Integer msgcount2;


    ViewPager viewpagerTopmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        textViewGet = (TextView) findViewById(R.id.textViewGet);
        buttonSend = (Button) findViewById(R.id.buttonSend);

        viewpagerTopmenu = (ViewPager) findViewById(R.id.viewpagerTopmenu);
        viewpagerTopmenu.setAdapter(new MenuAdapter(getSupportFragmentManager()));

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                    Toast.makeText(ChatActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                    Toast.makeText(ChatActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
                }
                // ...
            }
        };

        buttonSend.setOnClickListener(this);
        msgcount = 0;

    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //String data to database
        DatabaseReference dataChat2 = database.getReference("chat2");
        DatabaseReference dataNewChat2 = dataChat2.push();

        String message = editTextMessage.getText().toString();
        String sender = mAuth.getCurrentUser().getEmail();

        Chat2 chat2 = new Chat2(sender, message);
        dataNewChat2.setValue(chat2);
        msgcount = msgcount + 1;
        msgcount2 = 0;

        //Show data but showing too much data
        DatabaseReference dataChatLoad = database.getReference();
        dataChatLoad.child("chat2").orderByKey().limitToLast(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                msgcount2 = msgcount2 + 1;
                if (msgcount==msgcount2) {
                    Chat2 chat2 = dataSnapshot.getValue(Chat2.class);
                    String val = textViewGet.getText().toString();
                    val = val + "\n \n Message:" + chat2.message + "\n Sender: " + chat2.sender;
                    textViewGet.setText(val);
                    textViewGet.setMovementMethod(new ScrollingMovementMethod());
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



        //DatabaseReference dataChat = database.getReference("chat");
        //dataChat.orderByKey().limitToLast(999).addChildEventListener(new ChildEventListener() {

            //@Override
            //public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                //Chat chat = dataSnapshot.getValue(Chat.class);

                //FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
                //String me = currentuser.getEmail();
                //String otherperson = "Person"; //has to be changed!!!!! *****************
                //String person1 = chat.from;
                //String person2 = chat.to;

                //if (me == person1 || me == person2){

                    //if (otherperson == person1 || otherperson == person2) {

                        //String val = chat.from + "\n" + chat.to + "\n" + chat.message;

                        //textViewGet.setText(val);

                    //}
                //}
            //}

            //@Override
            //public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            //}

            //@Override
            //public void onChildRemoved(DataSnapshot dataSnapshot) {
            //}

            //@Override
            //public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            //}

            //@Override
            //public void onCancelled(DatabaseError databaseError) {

            //}
        //});
    //}


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
