package cs321.classcamapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;


public class AddSchedule extends AppCompatActivity {

    EditText name, date_start, date_end, time_start, time_end;
    CheckBox Mon, Tue, Wed, Thurs, Fri, Sat, Sun;
    Button save, cancel;
    //ArrayList<Class> classData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        Mon = (CheckBox)findViewById(R.id.checkBox);
        Tue = (CheckBox)findViewById(R.id.checkBox1);
        Wed = (CheckBox)findViewById(R.id.checkBox2);
        Thurs = (CheckBox)findViewById(R.id.checkBox3);
        Fri = (CheckBox)findViewById(R.id.checkBox4);
        Sat = (CheckBox)findViewById(R.id.checkBox5);
        Sun = (CheckBox)findViewById(R.id.checkBox6);

        date_start =(EditText)findViewById(R.id.startDate);
        date_end = (EditText) findViewById(R.id.endDate);
        time_start = (EditText)findViewById(R.id.startTime);
        time_end = (EditText)findViewById(R.id.endTime);
        name = (EditText) findViewById(R.id.editName);

        save = (Button)findViewById(R.id.save_bt);
        cancel = (Button)findViewById(R.id.cancel_bt);
    }

    @Override
    public void onStart(){
        super.onStart();

        date_start.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){
                    DateDialog dialog=new DateDialog(view);
                    FragmentTransaction ft =getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });


        date_end.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){
                    DateDialog dialog=new DateDialog(view);
                    FragmentTransaction ft =getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });

        time_start.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){
                    TimeDialog dialog = TimeDialog.newInstance(view);
                    android.support.v4.app.FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
                    dialog.show(ft, "TimeDialog");

                }
            }
        });


        time_end.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View view, boolean hasfocus){
                if(hasfocus){
                    TimeDialog dialog = TimeDialog.newInstance(view);
                    android.support.v4.app.FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
                    dialog.show(ft, "TimeDialog");

                }
            }
        });
    }

    public ArrayList<String> checkWeek(){
        ArrayList<String> cb = new ArrayList<>();
        if(Mon.isChecked())
            cb.add("Mon");
        if(Tue.isChecked())
             cb.add ("Tue");
        if(Wed.isChecked())
             cb.add ("Wed");
        if(Thurs.isChecked())
             cb.add ("Thur");
        if(Fri.isChecked())
             cb.add ("Fri");
        if(Sat.isChecked())
             cb.add ("Sat");
        if(Sun.isChecked())
             cb.add ("Sun");
        return  cb;
    }

    public void saveMethod(View view) {
        String sName = name.getText().toString();
        String sStartDate = date_start.getText().toString();
        String sEndDate = date_end.getText().toString();
        String sStartTime = time_start.getText().toString();
        String sEndTime = time_end.getText().toString();
        Date dStartDate = stringToDate(sStartDate);
        Date dEndDate = stringToDate(sEndDate);

        if(sName.equals("") || dEndDate.before(dStartDate) || checkWeek().isEmpty())
        {
            Toast.makeText(this, "Invalid Date", Toast.LENGTH_SHORT).show();
            return;
        }

        Schedule cl = new Schedule();
        cl.setClassName(sName);
        cl.setStartDate(dStartDate);
        cl.setEndDate(dEndDate);
        int time []= stringToTime(sStartTime);
        cl.setStartHour(time[0]);
        cl.setStartMin(time[1]);
        time = stringToTime(sEndTime);
        cl.setEndHour(time[0]);
        cl.setEndMin(time[1]);
        ArrayList<String> w = checkWeek();
        for(String a : checkWeek())
            cl.addWeek(a);

        MainActivity.classSchedule.add(cl);
        Schedule.classDBOutout(MainActivity.classSchedule, MainActivity.classDB);
        Intent in = new Intent(this, Scheduler.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }

    public Date stringToDate(String str){
        String [] spl = str.split("/");
        int day [] = new int[3];
        for(int i = 0; i < spl.length; i ++){
            day[i] = Integer.parseInt(spl[i]);
        }
        return new Date(day[2] - 1900, day[0] - 1, day[1]);
    }

    public int[] stringToTime(String str){
        String [] spl = str.split(":");
        int time [] = new int[2];
        for(int i = 0; i < 2; i++)
            time[i] = Integer.parseInt(spl[i]);
        return time;
    }

}
