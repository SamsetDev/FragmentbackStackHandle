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
public class FragmentFirst extends Fragment {
    View view;
    Button button;
    SecondFragment fragment;
    OnItemClicks onItemClicks;
    public FragmentFirst() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_fragment_first, container, false);
        button= (Button) view.findViewById(R.id.btn1);
        fragment=new SecondFragment();

        // I want the whole view to be clickable, but I could have called the textView or ImageView only.
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onItemClicks.itemClick("first");
            }
        });



        return view;
    }

    // in onAttach we must instantiate the listener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onItemClicks= (OnItemClicks) activity;
            //mOnFragment1ClickedListener = (OnFragment1ClickedListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }



}
