package com.samset.myfragmenthandle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.samset.myfragmenthandle.listeners.OnItemClicks;
import com.samset.myfragmenthandle.fragments.FifthFragment;
import com.samset.myfragmenthandle.fragments.FourthFragment;
import com.samset.myfragmenthandle.fragments.FragmentFirst;
import com.samset.myfragmenthandle.fragments.SecondFragment;
import com.samset.myfragmenthandle.fragments.SixFragment;
import com.samset.myfragmenthandle.fragments.ThirdFragment;

import java.util.Stack;

/* By Samset*/
public class MainActivity extends AppCompatActivity implements OnItemClicks{

    public Stack<String> mFragmentStack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentStack = new Stack<String>();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = new FragmentFirst();

        String tag = fragment.toString();
        mFragmentStack.add(tag);
        transaction.add(R.id.containers, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();


    }



    @Override
    public void itemClick(String input)
    {
        if (input.equalsIgnoreCase("first"))
        {
            Fragment newFragment = new SecondFragment();
            beginTransction(newFragment);
        }else if (input.equalsIgnoreCase("second"))
        {
            Fragment newFragment = new ThirdFragment();
            beginTransction(newFragment);
        }
        else if (input.equalsIgnoreCase("third"))
        {
            Fragment fragment = new FourthFragment();
            beginTransction(fragment);
        }else if (input.equalsIgnoreCase("fourth"))
        {
            Fragment fragment = new FifthFragment();
            beginTransction(fragment);
        }else if (input.equalsIgnoreCase("fifth"))
        {
            Fragment fragment = new SixFragment();
            beginTransction(fragment);
        }
    }

    private void beginTransction(Fragment fragment)
    {
        Bundle args = new Bundle();
        String tag = fragment.toString();
        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fragment_animation_fade_in, R.anim.fragment_animation_fade_out);

        // I find what the current fragment from the stack is, take it and hide it
        // using transaction.hide(currentFragment);
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(mFragmentStack.peek());
        transaction.hide(currentFragment);
        transaction.add(R.id.containers, fragment,fragment.toString());
        // This is important, we must addToBackStack so we can pull it out later.
        transaction.addToBackStack(tag);
        // Instead of using replace we use add. Why? If we use replace, then the previous
        // fragment will always have to be re-created. What if you don't want to do that. In
        // my case, I didn't want it to be re-created all the time because I had a position
        // set and by re-creating it, I would have lost the position or had to use static flag.
        mFragmentStack.add(tag);
        transaction.commit();
    }




    @Override
    public void onBackPressed(){
        // from the stack we can get the latest fragment
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(mFragmentStack.peek());
        // If its an instance of Fragment1 I don't want to finish my activity, so I launch a Toast instead.
        if (fragment instanceof FragmentFirst){
            Toast.makeText(getApplicationContext(), "YOU ARE AT THE TOP FRAGMENT", Toast.LENGTH_SHORT).show();
        }
        else{
            // Remove the framg
            removeFragment();
            super.onBackPressed();
        }
    }
    private void removeFragment(){
        // remove the current fragment from the stack.
        mFragmentStack.pop();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // get fragment that is to be shown (in our case fragment1).
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(mFragmentStack.peek());
        // This time I set an animation with no fade in, so the user doesn't wait for the animation in back press
        transaction.setCustomAnimations(R.anim.zoom_in, R.anim.zoom_out);
        // We must use the show() method.
        transaction.show(fragment);
        transaction.commit();
    }
}
