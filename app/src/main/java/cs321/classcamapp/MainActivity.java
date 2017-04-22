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
    public static String classDB = FileManager.getFolderName() + "/" + "classDB.txt";
    public static String noteDBName= FileManager.getFolderName() + "/" + "noteDB.txt";


    //arrayList of schedules(className, startDate, endDate, startHour, startMinute, endHour, endMinute (base 24)
    static ArrayList<Schedule> classSchedule;
    public static NoteDatabase noteDB = new NoteDatabase(noteDBName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classSchedule = Schedule.classDBInput(classDB);

//        classSchedule.add(new Schedule());
//        classSchedule.add(new Schedule());
//        classSchedule.get(0).setClassName("CS321");
//        classSchedule.get(1).setClassName("CLAS 260");

//        // takes user to scheduler the first time they start the application
//        if(classSchedule.size() == 0){
//            // if there are no classes scheduled
//            Intent intent = new Intent(this, Scheduler.class);
//            startActivity(intent);
//        }
//        else if (currentlyClassPeriod()){
//            //if it is a class period I want to go to the camera on start up
//            Intent intent = new Intent(this, CameraScreen.class);
//            startActivity(intent);
//        }
//        else{
//            //stay on the main acitivity screen
//        }

    }

    public void openCamera(View view) {
        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TestingPage.class);
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
        // hello
        return "";
    }

    public static boolean currentlyClassPeriod(){
        String className = checkClass();
        if(className.equals("")){
            return false;
        }
        return true;
    }
}
