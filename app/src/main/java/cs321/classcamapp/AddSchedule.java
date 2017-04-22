package cs321.classcamapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Date;


public class AddSchedule extends AppCompatActivity {

    EditText name, date_start, date_end, time_start, time_end;
    CheckBox Mon, Tue, Wed, Thurs, Fri, Sat, Sun;
    Button save, cancel;
    FileIO fileio = new FileIO();
    ArrayList<Schedule> classData = null;

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

    public void saveMethod(View view) {

        Schedule cl = new Schedule();
        cl.setClassName(name.toString());

        cl.setStartDate(stringToDate(date_start.toString()));
        cl.setEndDate(stringToDate(date_end.toString()));

        int tem []= stringToTime(time_end.toString());
        cl.setStartHour(tem[0]);
        cl.setStartMin(tem[1]);

        int tem2 []= stringToTime(time_start.toString());
        cl.setEndHour(tem2[0]);
        cl.setEndMin(tem2[1]);

        if(Mon.isSelected())
            cl.addWeek("Mon");
        if(Tue.isSelected())
            cl.addWeek("Tue");
        if(Wed.isSelected())
            cl.addWeek("Wed");
        if(Thurs.isSelected())
            cl.addWeek("Thur");
        if(Fri.isSelected())
            cl.addWeek("Fri");
        if(Sat.isSelected())
            cl.addWeek("Sat");
        if(Sun.isSelected())
            cl.addWeek("Sun");

        classData.add(cl);

    }

    public Date stringToDate(String str){
        String [] spl = str.split("/");
        int day [] = new int[3];
        for(int i = 0; i < spl.length; i ++){
            day[i] = Integer.parseInt(spl[i]);
        }
        return new Date(day[2], day[0], day[1]);
    }

    public int[] stringToTime(String str){
        String [] spl = str.split(":");
        int time [] = new int[2];
        for(int i = 0; i < 2; i++)
            time[i] = Integer.parseInt(spl[i]);
        return time;
    }

}
