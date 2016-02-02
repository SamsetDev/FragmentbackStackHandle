package com.samset.myfragmenthandle.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.samset.myfragmenthandle.R;
import com.samset.myfragmenthandle.listeners.OnItemClicks;


/**
 * /* By Samset
 */
public class FifthFragment extends Fragment {

View view;Button button;
    OnItemClicks onItemClicks;
    public FifthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_fifth, container, false);
        button= (Button) view.findViewById(R.id.btn5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.itemClick("fifth");
            }
        });


        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onItemClicks= (OnItemClicks) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
