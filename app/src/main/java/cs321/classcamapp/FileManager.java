package cs321.classcamapp;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import java.io.File;
import static cs321.classcamapp.MainActivity.classSchedule;
import static cs321.classcamapp.R.id.gridview;
import java.util.*;

public class FileManager extends AppCompatActivity {

    public static String DBFILENAME = getFolderName() + "/" + "NoteDataBase.txt";
    public static NoteDatabase NTDB = new NoteDatabase(DBFILENAME);
    GridView grid;
    private Object ArrayList;

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
        setContentView(R.layout.activity_file_manager);

        CustomGrid adapter = new CustomGrid(FileManager.this, getClassNames(classSchedule), getFolders(classSchedule));
        grid = (GridView)findViewById(R.id.gridview);
        grid.setAdapter(adapter);
//        GridView gridview = (GridView) findViewById(R.id.gridview);
//        gridview.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(FileManager.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private Integer[] getFolders(ArrayList<Schedule> classSchedule){
        Integer[] temp = new Integer[classSchedule.size()];
        for(int i=0; i < classSchedule.size(); i++){
            temp[i] = (R.drawable.foldericon);
        }
        return temp;
    }

    private String[] getClassNames(ArrayList<Schedule> classSchedule){
        String[] temp = new String[classSchedule.size()];
        for(int i=0; i < classSchedule.size(); i++){
            temp[i] = classSchedule.get(i).getClassName();
        }
        return temp;
    }
}
