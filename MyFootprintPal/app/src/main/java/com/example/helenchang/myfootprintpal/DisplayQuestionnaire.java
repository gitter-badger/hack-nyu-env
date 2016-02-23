package com.example.helenchang.myfootprintpal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayQuestionnaire extends FragmentActivity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
