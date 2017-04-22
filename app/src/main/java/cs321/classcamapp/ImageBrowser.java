package cs321.classcamapp;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static cs321.classcamapp.MainActivity.classSchedule;

public class ImageBrowser extends AppCompatActivity {

    private int positionOpen;

    public static String DBFILENAME = getFolderName() + "/" + "NoteDataBase.txt";
    public static NoteDatabase NTDB = new NoteDatabase(DBFILENAME);

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

        GridView gridview = (GridView) findViewById(R.id.imageGridView);
        gridview.setAdapter(new ImageBrowserAdapter(ImageBrowser.this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(ImageBrowser.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
