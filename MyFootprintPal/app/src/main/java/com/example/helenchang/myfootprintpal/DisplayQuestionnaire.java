package com.example.helenchang.myfootprintpal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;


import java.util.ArrayList;


public class DisplayQuestionnaire extends FragmentActivity {

    
    private static ArrayList<String> questions = new ArrayList<String>();
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 14;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }



    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }



    private void populateQuestions(){
        questions.add("How many people live in your house");
        questions.add("What kind of energy system does your house use?");
        questions.add("Do you use energy efficient light bulbs?");
        questions.add("What kind of stove system does your house use");
        questions.add("How often do you cook?");
        questions.add("How many times do you shower a day");
        questions.add("What is your primary form of transportation");
        questions.add("If you drive a car, what kind of car do you drive?");
        questions.add("If you take public transportation, which one do you take?");
        questions.add("How far do you commute?");
        questions.add("How many times a year do you fly out of the US");
        questions.add("How many times a year do you fly within the US?");
        questions.add("What is your diet like?");
        questions.add("How often do you drink bottled water (yearly)?");

    }

}
