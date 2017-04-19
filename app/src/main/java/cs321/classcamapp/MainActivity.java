package cs321.classcamapp;

import android.content.Intent;
import android.support.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //arrayList of schedules(className, startDate, endDate, startHour, startMinute, endHour, endMinute (base 24)
    static ArrayList<Schedule> classSchedule = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // takes user to scheduler the first time they start the application
        if(false){       //TODO check if schedule has been made yet
            Intent intent = new Intent(this, Scheduler.class);
            startActivity(intent);
        }

    }

    public void openCamera(View view) {
        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CameraScreen.class);
        startActivity(intent);
    }

    public void openSchedule(View view) {
        Toast.makeText(this, "Open Schedule", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Scheduler.class);
        startActivity(intent);
    }

    public void openFileManager(View view) {
        Toast.makeText(this, "Open File Manager", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FileManager.class);
        startActivity(intent);
    }

    /***
     * Determines if the current time is currently within a scheduled class period
     * @return Returns the class name if currently within a schedule class. Returns an empty string
     * if not currently within a class period.
     *
     */
    public static String checkClass(){
        Date dt = new Date();
        Schedule s;
        for(int i=0; i < classSchedule.size() - 1; i++){
            s = classSchedule.get(i);
            int currentHour = dt.getHours();
            int currentMin = dt.getMinutes();
            if(dt.after(s.getStartDate()) && dt.before(s.getEndDate())){    //within callender date
                if(( currentHour >= s.getStartHour()) && currentHour <= s.getEndHour()){    // within class period hour
                    if(currentMin >= s.getStartMin() && currentMin <= s.getEndMin()){
                        // If I get here then the we have verified that we are currently in s class
                        return s.getClassName();
                    }
                }
            }
        }
        return "";

    }
}
