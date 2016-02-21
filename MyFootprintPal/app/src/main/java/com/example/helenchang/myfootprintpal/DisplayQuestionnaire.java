package com.example.helenchang.myfootprintpal;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayQuestionnaire extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeaders;
    HashMap<String, List<String>> listDataChildren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_questionnaire);

        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeaders, listDataChildren);

        // setting list adapter
        expListView.setAdapter(listAdapter);
//        finish();

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeaders.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeaders.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeaders.get(groupPosition)
                                + " : "
                                + listDataChildren.get(
                                listDataHeaders.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }
    private void prepareListData(){
        listDataHeaders = new ArrayList<String>();
        listDataChildren = new HashMap<String, List<String>>();

        //Add Headers
        listDataHeaders.add("Housing");
        listDataHeaders.add("Travel");
        listDataHeaders.add("Food");

        List<String> housing = new ArrayList<String>();
        //answer with int
        housing.add("How many people live in your house?");
        //answer with either COAL or NATURAL GAS
        housing.add("What kind of energy system does your house use?");
        //answer with YES or NO
        housing.add("Do you use energy efficient light bulbs?");
        //answer with either FUEL OIL or NATURAL GAS
        housing.add("What kind of stove system does your house use");
        //answer with either ONCE A WEEK, ONCE A DAY or ALL THE TIME
        housing.add("How often do you cook?");
        //answer with ONCE TWICE THREE TIMES or FOUR TIMES
        housing.add("How many times do you shower a day?");

        List<String> travel = new ArrayList<String>();
        //answer with CARS or PUBLIC TRANSPORTATION or HUMAN POWER
        travel.add("What is your primary form of transportation?");
        //answer with DIESEL ELECTRIC HYBRID OR N/A
        travel.add("If you drivea a car: What kind of car do you drive?");
        //answer with METRO BUS CAR POOL or N/A
        travel.add("If you take public transportation do you take the train or metro?");
        //answer with 0-3 30-60 60-90 or REALLY FAR
        travel.add("If you take a car or public transportation how far do you commute?");
        //0-3 3-6 6-9 or ALOT
        travel.add("How many times a year do you fly out of the United States?");
        //0-3 3-6 6-9 or ALOT
        travel.add("How many times a year did you fly within the United States?");

        List<String> food = new ArrayList<String>();
        //answer with MEAT HEAVY AVERAGE MEAT LOVER PESCETARIAN VEGETARIAN VEGAN
        food.add("What is your diet like?");
        //answer with ONLY BOTTLED WATER, 10-20, 0-10, NEVER
        food.add("How often do you drink bottled water? (yearly)");


    }
}
