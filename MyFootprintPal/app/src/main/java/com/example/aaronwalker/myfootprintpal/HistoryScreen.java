package com.example.aaronwalker.myfootprintpal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.Math.*;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;


public class HistoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //datapoint arrays initialized for 24hrs
        DataPoint[] dataYesterday = new DataPoint[24];
        DataPoint[] dataTwoDaysAgo = new DataPoint[24];
        DataPoint[] dataThreeDaysAgo = new DataPoint[24];

        //randomize points SHOULD BE COMING FROM PAST USER DATA!!
        for(int i = 0; i < 24; i++){
            double randx = i + 1;
            double randy = java.lang.Math.random() * 100;
            dataThreeDaysAgo[i] = new DataPoint(randx, randy);
            randx = i + 1;
            randy = java.lang.Math.random() * 100;
            dataTwoDaysAgo[i] = new DataPoint(randx, randy);
            randx = i + 1;
            randy = java.lang.Math.random() * 100;
            dataYesterday[i] = new DataPoint(randx, randy);

        }
        //create graph for most recent history (yesterday + 2days ago + 3days ago)
        GraphView graphPast = (GraphView) findViewById(R.id.graph);

        //series of points
        LineGraphSeries<DataPoint> seriesYesterday = new LineGraphSeries<DataPoint>(dataYesterday);
        LineGraphSeries<DataPoint> seriesTwoDaysAgo = new LineGraphSeries<DataPoint>(dataTwoDaysAgo);
        LineGraphSeries<DataPoint> seriesThreeDaysAgo = new LineGraphSeries<DataPoint>(dataThreeDaysAgo);

        //coloring
        seriesThreeDaysAgo.setColor(Color.RED);
        seriesTwoDaysAgo.setColor(Color.BLUE);
        seriesYesterday.setColor(Color.GREEN);

        //plot lines
        graphPast.addSeries(seriesYesterday);
        graphPast.addSeries(seriesTwoDaysAgo);
        graphPast.addSeries(seriesThreeDaysAgo);

        //set up scaling/scrolling
        graphPast.getViewport().setScalable(true);
        graphPast.getViewport().setScrollable(true);

        //axis
        graphPast.getGridLabelRenderer().setVerticalAxisTitle("Carbon Footprint (CO2e)");
        graphPast.getGridLabelRenderer().setHorizontalAxisTitle("Time (h)");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history_screen, menu);
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
