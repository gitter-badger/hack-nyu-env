package com.example.helenchang.myfootprintpal;

import android.os.Bundle;
import android.app.Activity;

public class DisplayQuestionnaire extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_questionnaire);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
