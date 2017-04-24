package cs321.classcamapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.File;

public class ImageViewer extends AppCompatActivity {

    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);


        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        selectedImage = (ImageView) findViewById(R.id.imageView);
        gallery.setSpacing(1);
        final ImageViewAdapter imageViewAdapter = new ImageViewAdapter(this);
        gallery.setAdapter(imageViewAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                File imageFile = new File(ImageBrowser.getNoteArray()[position].getFileLink());
                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                selectedImage.setImageBitmap(bitmap);

                // show the selected Image
//                selectedImage.setImageResource(ImageViewAdapter.mImageIds[position]);
            }
        });
    }
}
