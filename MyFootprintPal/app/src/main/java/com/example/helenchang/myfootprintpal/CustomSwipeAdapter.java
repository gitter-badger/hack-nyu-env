package com.example.helenchang.myfootprintpal;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by aaronwalker on 2/22/16.
 */
public class CustomSwipeAdapter extends PagerAdapter {
    private String[] question_resources = {"How many people live in your house?",
            "What kind of energy system does your house use?",
            "Do you use energy efficient light bulbs?",
            "What kind of stove system does your house use",
            "How often do you cook?",
            "How many times do you shower a day?",
            "What is your primary form of transportation?",
            "If you drivea a car: What kind of car do you drive?",
            "If you take public transportation do you take the train or metro?",
            "If you take a car or public transportation how far do you commute?",
            "How many times a year do you fly out of the United States?",
            "How many times a year did you fly within the United States?",
            "What is your diet like?",
            "How often do you drink bottled water? (yearly)"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return question_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        TextView textView = (TextView) item_view.findViewById(R.id.text1);

        textView.setText(question_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }
}
