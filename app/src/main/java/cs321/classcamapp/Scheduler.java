package cs321.classcamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class Scheduler extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i< MainActivity.classSchedule.size(); i++){
            Schedule e = MainActivity.classSchedule.get(i);
            a.add(e.toListView());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, a);
        mListView.setAdapter(arrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent e = new Intent(Scheduler.this, AddSchedule.class);
                e.putExtra("Position", position);
                startActivity(e);
            }
        });
    }

    public void openAdd(View view) {
        Intent intent = new Intent(this, AddSchedule.class);
        intent.putExtra("Position", -1);
        startActivity(intent);
    }




//    public static String getEvent(Date timestamp){
//        //given a timestamp, goes through scheudle and returns class (ex. CS321)
//        String event = "";
//
//        return event;
//    }
}
