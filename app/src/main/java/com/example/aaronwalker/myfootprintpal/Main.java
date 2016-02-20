package com.example.aaronwalker.myfootprintpal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Main extends AppCompatActivity {
    private static Button button_travel, button_water, button_food, button_waste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_travel = (Button)findViewById(R.id.button);
        button_water = (Button)findViewById(R.id.button2);
        button_food = (Button)findViewById(R.id.button3);
        button_waste = (Button)findViewById(R.id.button4);
        OnClickTravelButtonListener();
        OnClickWaterButtonListener();
        OnClickFoodButtonListener();
        OnClickWasteButtonListener();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void OnClickTravelButtonListener() {
        button_travel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Travel");
                        startActivity(intent);
                    }
                }
        );
    }
    public void OnClickWaterButtonListener() {
        button_water.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Water");
                        startActivity(intent);
                    }
                }
        );

    }
    public void OnClickFoodButtonListener() {
        button_food.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Food");
                        startActivity(intent);
                    }
                }
        );
    }
    public void OnClickWasteButtonListener() {
        button_waste.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Waste");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
