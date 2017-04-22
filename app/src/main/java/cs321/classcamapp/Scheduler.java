package cs321.classcamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class Scheduler extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);
        mListView = (ListView) findViewById(R.id.listView);

        //Class classList
        //ArrayList<Schedule> classList = Schedule.toFileString();

        //String[] listItems = new String[classList.size()];

//        for(int i = 0; i < classList.size(); i++){
//            listItems[i] = classList.toString();
//        }
//
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
//        mListView.setAdapter(adapter);
    }

    public void openAdd(View view) {
        Intent intent = new Intent(this, AddSchedule.class);
        startActivity(intent);
    }


    public static String getEvent(Date timestamp){
        //given a timestamp, goes through scheudle and returns class (ex. CS321)
        String event = "";

        return event;
    }
}
