package cs321.classcamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class Scheduler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);
    }


    public static String getEvent(Date timestamp){
        //given a timestamp, goes through scheudle and returns class (ex. CS321)
        String event = "";

        return event;
    }
}
