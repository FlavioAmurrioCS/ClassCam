package cs321.classcamapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

import static cs321.classcamapp.MainActivity.classSchedule;

/**
 * Created by Jonathan on 4/22/2017.
 */

public class ImageBrowserAdapter extends BaseAdapter {
        private Context mContext;

        public ImageBrowserAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return ImageBrowser.getNoteArray().length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

//            int folderPosition = ImageBrowser.getPositionOpen();
//            String eventName = classSchedule.get(folderPosition).getClassName();
//            ArrayList<NoteRecord> notes = NoteDatabase.getFileList(eventName);

            //TODO Put this in
            //try this one instead
            File imageFile = new File(ImageBrowser.getNoteArray()[position].getFileLink());


            int tWidth = imageView.getWidth();
            int tHeight = imageView.getHeight();

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;

            BitmapFactory.decodeFile(imageFile.getAbsolutePath(), bmOptions);
            int pWidth = bmOptions.outWidth;
            int pHeight = bmOptions.outHeight;

            int scaleFactor = Math.min(pWidth/tWidth, pHeight/tHeight);

            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), bmOptions);
            imageView.setImageBitmap(bitmap);
            return imageView;

//            //TODO take this out
//            imageView.setImageResource(mThumbIds[position]);
//            return imageView;
        }
//    public Object[] getImageList

}
