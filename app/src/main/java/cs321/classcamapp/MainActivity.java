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
    public static NoteDatabase noteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDB = new NoteDatabase(noteDBName);

        classSchedule = Schedule.classDBInput(classDB);
        if(classSchedule.isEmpty())
        {
            Schedule cl = new Schedule();
            cl.setClassName("UnOrganized");
            cl.setStartDate(new Date(116, 0, 1));
            cl.setEndDate(new Date(119, 11, 30));
            cl.setStartHour(1);
            cl.setStartMin(00);
            cl.setEndHour(23);
            cl.setEndMin(59);
            cl.addWeek("Mon");
            cl.addWeek("Tue");
            cl.addWeek("Wed");
            cl.addWeek("Thur");
            cl.addWeek("Fri");
            cl.addWeek("Sat");
            cl.addWeek("Sun");
            classSchedule.add(cl);
            Schedule.classDBOutout(classSchedule, classDB);
        }

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

    public void openCameraActivity(View view) {
        //Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CameraActivity.class);
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
        return "UnOrganized";
    }

    public static boolean currentlyClassPeriod(){
        String className = checkClass();
        if(className.equals("UnOrganized")){
            return false;
        }
        return true;
    }

    public void newCameraOpen(View view) {
        Toast.makeText(this, "NewCamera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CameraActivity2.class);
        startActivity(intent);
    }
}
