package com.example.helenchang.myfootprintpal;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
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
        //DO NOT UNCOMMENT!!!!
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeaders, listDataChildren);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        finish();
    }
    private void prepareListData(){
        listDataHeaders = new ArrayList<String>();
        listDataChildren = new HashMap<String, List<String>>();

        //Add Headers
        listDataHeaders.add("Housing");
        listDataHeaders.add("Travel");
        listDataHeaders.add("Food");

    }
}
