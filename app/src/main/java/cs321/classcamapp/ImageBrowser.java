package cs321.classcamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ImageBrowser extends AppCompatActivity {

    private int positionOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_browser);

        positionOpen = getIntent().getIntExtra("position", -1);
        TextView testing = (TextView) findViewById(R.id.textView);
        testing.setText("The " + positionOpen + " position was clicked");
    }
}
