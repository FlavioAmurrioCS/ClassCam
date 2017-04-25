package cs321.classcamapp;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static cs321.classcamapp.MainActivity.classSchedule;

public class ImageBrowser extends AppCompatActivity {

    private static int positionOpen;
    private static ArrayList<NoteRecord> notes;
    private static NoteRecord[] noteArray;

    public static String getFolderName() {
        String filePath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filePath, "ClassCam");
        if (!file.exists())
            file.mkdir();
        return (file.getAbsolutePath());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browser);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.browserToolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        positionOpen = getIntent().getIntExtra("positionOpen", -1);
        String eventName = classSchedule.get(positionOpen).getClassName();
        setTitle(eventName);
        Toast.makeText(this, eventName, Toast.LENGTH_SHORT).show();
        notes = MainActivity.noteDB.getFileList(eventName);
        if(notes.size() == 0){
            return;
        }
        noteArray = new NoteRecord[notes.size()];
        noteArray = notes.toArray(noteArray);





        GridView gridview = (GridView) findViewById(R.id.imageGridView);
        gridview.setAdapter(new ImageBrowserAdapter(ImageBrowser.this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(ImageBrowser.this, "" + position, Toast.LENGTH_SHORT).show();
//                Toast.makeText(ImageBrowser.this, "This was the " + positionOpen + " position FOLDER.", Toast.LENGTH_SHORT).show();
                
//                Intent intent = new Intent(ImageBrowser.this, ImageViewer.class);
//                intent.putExtra("position", position);
//                startActivity(intent);

                Intent bigView = new Intent(ImageBrowser.this, bigImageView.class);
                bigView.putExtra("position", position);
                bigView.putExtra("browserPositionOpen", positionOpen);
                startActivity(bigView);
            }
        });




    }

    public static int getPositionOpen(){
        return positionOpen;
    }

    public static NoteRecord[] getNoteArray(){
        return noteArray;
    }



}
