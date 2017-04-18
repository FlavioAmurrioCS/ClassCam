package cs321.classcamapp;

import android.content.Intent;
import android.support.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        Toast.makeText(this, "Open Camera", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CameraScreen.class);
        startActivity(intent);
    }

    public void openSchedule(View view) {
        Toast.makeText(this, "Open Schedule", Toast.LENGTH_SHORT).show();Intent intent = new Intent(this, Scheduler.class);
        startActivity(intent);
    }

    public void openFileManager(View view) {
        Toast.makeText(this, "Open File Manager", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FileManager.class);
        startActivity(intent);
    }
}
