package cs321.classcamapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jonathan on 4/22/2017.
 */

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] className;
    private final Integer[] imageID;

    public CustomGrid(Context c, String[] className, Integer[] imageID){
        mContext = c;
        this.imageID = imageID;
        this.className = className;
    }


    @Override
    public int getCount() {
        return imageID.length;
    }

    @Override
    public Object getItem(int i) {
        //TODO this method..
        return null;
    }

    @Override
    public long getItemId(int i) {
        //TODO this method
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setTextSize(12);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(className[i]);
            imageView.setImageResource(imageID[i]);
        } else {
            grid = (View)view;
        }
        return grid;
    }
}
