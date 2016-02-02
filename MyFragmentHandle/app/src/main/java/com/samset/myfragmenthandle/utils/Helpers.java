package com.samset.myfragmenthandle.utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by karamjeetsingh on 01/02/16.
 */
public class Helpers {
 FragmentManager fm;
    Context context;
    private String firstFragmentTag;



  public static Helpers getInstance()
  {
      return new Helpers();
  }

}
