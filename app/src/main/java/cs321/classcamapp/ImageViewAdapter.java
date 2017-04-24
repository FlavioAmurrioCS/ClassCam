package cs321.classcamapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jonathan on 4/23/2017.
 */

public class ImageViewAdapter extends BaseAdapter {

    private Context mContext;

    public ImageViewAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return ImageBrowser.getNoteArray().length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView img = new ImageView(mContext);

        File imageFile = new File(ImageBrowser.getNoteArray()[i].getFileLink());
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        img.setImageBitmap(bitmap);


        img.setLayoutParams(new Gallery.LayoutParams(200, 200));

        img.setScaleType(ImageView.ScaleType.FIT_XY);


        return img;

    }
}
