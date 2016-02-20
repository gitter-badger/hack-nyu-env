package com.example.helenchang.myfootprintpal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.view.View.OnClickListener;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
//import com.jjoe64.graphview.



public class Homescreen extends AppCompatActivity {
    //add one time welcome screen

    SharedPreferences mPrefs;
    final String welcomeScreenShownPref = "welcomeScreenShown";

    //Coloring
    final int COL_TODAY = Color.GREEN;
    final int COL_BEST = Color.GRAY;
    final int COL_GOAL = Color.RED;

    //null points for disappearing lines
    final DataPoint[] EMPTY = new DataPoint[]{new DataPoint(0,0)};

    LineGraphSeries<DataPoint> todayData;
    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        //Default to false if not found in xml
        Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, false);

        if(!welcomeScreenShown) {
            //somehow show questionaire
            Intent intent = new Intent(this, DisplayQuestionnaire.class);
            //edit prefs
            mPrefs.edit().putBoolean(welcomeScreenShownPref, true).commit();

        }
        //GRAPHS
        graph = (GraphView) findViewById(R.id.graph);

        //Line 1: Today's data
        todayData = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(todayData);
        graph.setTitle("Today's Progress");
        graph.setTitleTextSize(70);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Carbon Footprint (CO2e)");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Time (h)");
        todayData.setColor(COL_TODAY);



        //Line 2: Best data
        LineGraphSeries<DataPoint> bestData = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 2),
                new DataPoint(1, 5),
                new DataPoint(2, 4),
                new DataPoint(3, 4),
                new DataPoint(4, 7)
        });
        graph.addSeries(bestData);
        bestData.setColor(COL_BEST);


        //Line 3: Goal data
        LineGraphSeries<DataPoint> goalData = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(1, 5),
                new DataPoint(2, 5),
                new DataPoint(3, 5),
                new DataPoint(4, 5)
        });
        graph.addSeries(goalData);
        goalData.setColor(COL_GOAL);


        //CHECKBOXES
        CheckBox todayCB = (CheckBox) findViewById(R.id.todayCB);
        CheckBox bestCB = (CheckBox) findViewById(R.id.bestCB);
        CheckBox goalCB = (CheckBox) findViewById(R.id.goalCB);

        todayCB.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){

                if(((CheckBox)v).isChecked()){
                    todayData.resetData(EMPTY);
                    graph.addSeries(todayData);
                }
                else{
                    todayData.resetData(new DataPoint[] {
                            new DataPoint(0, 1),
                            new DataPoint(1, 5),
                            new DataPoint(2, 3),
                            new DataPoint(3, 2),
                            new DataPoint(4, 6)
                    });

                }
            }



        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homescreen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
