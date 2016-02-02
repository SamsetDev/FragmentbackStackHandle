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
public class SecondFragment extends Fragment {

   View view;
    Button button;
    ThirdFragment fragment;
    OnItemClicks onItemClicks;
    public SecondFragment() {
        // Required empty public constructor
    }



    private String initialText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_second, container, false);
        button= (Button) view.findViewById(R.id.btn2);


        fragment=new ThirdFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.itemClick("second");


               /* FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.MyContainer, fragment);
                MainActivity.fragmentstack.push(fragment);
                transaction.commit();*/

            }
        });


        return view;
    }
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
