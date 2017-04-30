package cs321.classcamapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.transition.Scene;
import android.support.v13.app.ActivityCompat;
import android.support.v13.app.FragmentCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_STORAGE_PERMISSION = 1;
    public static String classDB;
    public static String noteDBName;


    //arrayList of schedules(className, startDate, endDate, startHour, startMinute, endHour, endMinute (base 24)
    static ArrayList<Schedule> classSchedule;
    public static NoteDatabase noteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestStoragePermission();
        }
        classDB = FileManager.getFolderName() + "/" + "classDB.txt";
        noteDBName = FileManager.getFolderName() + "/" + "noteDB.txt";

        noteDB = new NoteDatabase(noteDBName);
        classSchedule = Schedule.classDBInput(classDB);

        if (classSchedule.isEmpty()) {
            Schedule cl = new Schedule();
            cl.setClassName("Unclassified");
            cl.setStartDate(new Date(116, 0, 1));
            cl.setEndDate(new Date(119, 11, 30));
            cl.setStartHour(1);
            cl.setStartMin(00);
            cl.setEndHour(23);
            cl.setEndMin(59);
            cl.addWeek("Mon");
            cl.addWeek("Tue");
            cl.addWeek("Wed");
            cl.addWeek("Thurs");
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

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

        } else {

            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_PERMISSION);
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
////            new Camera2BasicFragment.ConfirmationDialog().show(getChildFragmentManager(), FRAGMENT_DIALOG);
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                    REQUEST_STORAGE_PERMISSION);
//        }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Toast.makeText(this, "ENABLE APP PERMISSION ON SETTINGS", Toast.LENGTH_SHORT).show();

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    public void openCameraActivity(View view) {
        //Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CameraActivity2.class);
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
    public static String checkClass() {
        Date dt = new Date();
        Schedule s;

//        for (int i = database.size() - 1; i > -1; i--) {
        for (int i = classSchedule.size() - 1; i > -1; i--) {
//        for(int i=0; i < classSchedule.size() - 1; i++){
            s = classSchedule.get(i);
            int currentHour = dt.getHours();
            int currentMin = dt.getMinutes();
            if (dt.after(s.getStartDate()) && dt.before(s.getEndDate())) {    //within callender date
                if ((currentHour > s.getStartHour()) && currentHour < s.getEndHour()) {    // within class period hour
                    return s.getClassName();
                } else if (currentHour == s.getStartHour()) {
                    if (currentMin > s.getStartMin()) {
                        return s.getClassName();
                    }
                } else if (currentHour == s.getEndHour()) {
                    if (currentMin < s.getEndMin()) {
                        return s.getClassName();
                    }
                }
            }

        }

        return "Unclassified";
    }

    public static boolean currentlyClassPeriod() {
        String className = checkClass();
        if (className.equals("UnOrganized")) {
            return false;
        }
        return true;
    }

    public void newCameraOpen(View view) {
        Intent intent = new Intent(MainActivity.this, CameraActivity2.class);
        startActivity(intent);
    }
}
