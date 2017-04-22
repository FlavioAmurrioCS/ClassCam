package cs321.classcamapp;
/**
 * Created by MyLe on 4/18/17.
 */

import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.app.Dialog;
import android.app.TimePickerDialog;;

// TimePicker Fragment

public class TimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private static EditText appointment_end;
    public static TimeDialog newInstance(View view){
        appointment_end = (EditText)view;
        return(new TimeDialog());
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current time as the default time in the dialog
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        //Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,false);

    }


    public void onTimeSet(TimePicker picker,int hour, int minute){

        String min = minute + "";
        if(min.equals("0"))
        {
            min = "00";
        } else if (minute < 10) {
            min = "0" + minute;
        }
        else
        {
            min = minute + "";
        }
        appointment_end.setText(hour + ":" + min);
    }
}
