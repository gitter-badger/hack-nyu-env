package com.example.helenchang.myfootprintpal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

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

public class Homescreen extends AppCompatActivity {

    //add one time welcome screen

    SharedPreferences mPrefs;
    final String welcomeScreenShownPref = "welcomeScreenShown";

    //Coloring
    final int COL_TODAY = Color.GREEN;
    final int COL_BEST = Color.GRAY;
    final int COL_GOAL = Color.RED;

    //DATAPOINTS
    final DataPoint[] EMPTY = new DataPoint[]{new DataPoint(0,0)};
    DataPoint[] todayDP;
    DataPoint[] bestDP;
    DataPoint[] goalDP;

    LineGraphSeries<DataPoint> todayLineGraph;
    LineGraphSeries<DataPoint> bestLineGraph;
    LineGraphSeries<DataPoint> goalLineGraph;
    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DONT MESS WITH THIS
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPrefs = getSharedPreferences(welcomeScreenShownPref,0);
        mPrefs.edit().putBoolean("my_first_time", true).commit();

        //Boolean welcomeScreenShown = mPrefs.getBoolean(welcomeScreenShownPref, true);

        if (mPrefs.getBoolean("my_first_time", true)) {
            //somehow show questionnaire
            Intent intent = new Intent(Homescreen.this, DisplayQuestionnaire.class);
            Homescreen.this.startActivity(intent);
            //edit prefs
            mPrefs.edit().putBoolean("my_first_time", false).commit();
//            finish();
//            mPrefs.getBoolean(welcomeScreenShownPref, true);
        }
//        else {
            //GRAPHS
            graph = (GraphView) findViewById(R.id.graph);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(0);
            graph.getViewport().setMaxX(24);
            graph.setTitle("Today's Progress");
            graph.setTitleTextSize(70);
            graph.getGridLabelRenderer().setVerticalAxisTitle("Carbon Footprint (CO2e)");
            graph.getGridLabelRenderer().setHorizontalAxisTitle("Time (h)");

            //DATAPOINTS (UPDATE HERE)
            todayDP = new DataPoint[]{
                    new DataPoint(0, 1),
                    new DataPoint(5, 5),
                    new DataPoint(10, 3),
                    new DataPoint(15, 2),
                    new DataPoint(20, 6)
            };
            bestDP = new DataPoint[]{
                    new DataPoint(0, 2),
                    new DataPoint(5, 5),
                    new DataPoint(10, 4),
                    new DataPoint(15, 4),
                    new DataPoint(24, 7)
            };
            goalDP = new DataPoint[]{
                    new DataPoint(0, 5),
                    new DataPoint(24, 5)
            };

            //Line 1: Today's data
            todayLineGraph = new LineGraphSeries<DataPoint>(todayDP);
            graph.addSeries(todayLineGraph);
            todayLineGraph.setColor(COL_TODAY);

            //Line 2: Best data
            bestLineGraph = new LineGraphSeries<DataPoint>(bestDP);
            graph.addSeries(bestLineGraph);
            bestLineGraph.setColor(COL_BEST);

            //Line 3: Goal data
            goalLineGraph = new LineGraphSeries<DataPoint>(goalDP);
            graph.addSeries(goalLineGraph);
            bestLineGraph.setColor(COL_GOAL);


            //CHECKBOXES
            CheckBox todayCB = (CheckBox) findViewById(R.id.todayCB);
            CheckBox bestCB = (CheckBox) findViewById(R.id.bestCB);
            CheckBox goalCB = (CheckBox) findViewById(R.id.goalCB);
            todayCB.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        todayLineGraph.resetData(todayDP);
                    } else {
                        todayLineGraph.resetData(EMPTY);
                    }
                }
            });
            bestCB.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        bestLineGraph.resetData(bestDP);
                    } else {
                        bestLineGraph.resetData(EMPTY);
                    }
                }
            });
            goalCB.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((CheckBox) v).isChecked()) {
                        goalLineGraph.resetData(goalDP);
                    } else {
                        goalLineGraph.resetData(EMPTY);
                    }
                }
            });

            //gets rid of actionbar title
            setTitle("");


        }
//    }
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