package com.example.helenchang.myfootprintpal;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;



public class DisplayQuestionnaire extends Activity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
