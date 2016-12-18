package com.example.ryo.jobot_to626;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopMenuFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    private Button buttonAssess;
    private Button buttonMatch;
    private Button buttonContact;


    public TopMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_top_menu,container, false);

        buttonAssess = (Button) view.findViewById (R.id.buttonAssess);
        buttonAssess.setOnClickListener(this);
        buttonMatch = (Button) view.findViewById (R.id.buttonMatch);
        buttonMatch.setOnClickListener(this);
        buttonContact = (Button) view.findViewById (R.id.buttonContact);
        buttonContact.setOnClickListener(this);


        final Bundle bundle = getArguments();
        final Integer count = bundle.getInt("count");

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view==buttonAssess) {
            //go to assessment
            Intent intent = new Intent(this.getContext(), AssessmentActivity.class);
            startActivity(intent);
        } else if (view==buttonMatch) {
            //go to match
            Intent intent = new Intent(this.getContext(), JobActivity.class);
            startActivity(intent);
        } else if (view==buttonContact){
            //go to contact
            Intent intent = new Intent(this.getContext(), HistoryActivity.class);
            startActivity(intent);
        }
    }
}
