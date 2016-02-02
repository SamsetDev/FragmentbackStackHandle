package com.samset.myfragmenthandle.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.samset.myfragmenthandle.R;


/**
 * /* By Samset
 */
public class SixFragment extends Fragment {

   View view;
    Button button;
    public SixFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_six, container, false);
        button= (Button) view.findViewById(R.id.btn6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "THIS IS LAST FRAGMENT-6 BEING CLICKED!!! PRESS BACK TO GO TO FRAGMENT-1", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
