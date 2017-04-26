package cs321.classcamapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class bigImageView extends AppCompatActivity {
    private int browserPositionOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image_view);

        int position = getIntent().getIntExtra("position", 0);
        browserPositionOpen = getIntent().getIntExtra("browserPositionOpen", 0);

        ImageView imageView = (ImageView)findViewById(R.id.bigImageView);
        imageView.setRotation(90);


        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        File imageFile = new File(ImageBrowser.getNoteArray()[position].getFileLink());
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        imageView.setImageBitmap(bitmap);
    }

    public void onBackClick(View view){
        Intent backIntent = new Intent(bigImageView.this, ImageBrowser.class);
        backIntent.putExtra("positionOpen", browserPositionOpen);
        startActivity(backIntent);
        finish();
    }

    public void deleteFile(View view) {
        int position = getIntent().getIntExtra("position", 0);
        NoteRecord nr = ImageBrowser.getNoteArray()[position];
        MainActivity.noteDB.removeFile(nr);
        Toast.makeText(this, "File Deleted", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this, FileManager.class);
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);
    }
}
