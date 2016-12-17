package com.example.ryo.jobot_to626;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Alexander on 12/11/2016.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    private Integer count;

    @Override
    public Fragment getItem(final int i) {

        final Fragment fragment = new QuestionFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public int getCount() {
        count = 9;

// ****** Unfortunately does not work... Will look for a workaround later. ********
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference dataQuestions = database.getReference("questions");
//        dataQuestions.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                count = (int) (long) dataSnapshot.getChildrenCount();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        return count;
    }
}
