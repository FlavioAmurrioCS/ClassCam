package cs321.classcamapp;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MyLe on 4/30/17.
 */
public class AddScheduleTest extends ActivityInstrumentationTestCase2<FileManager> {
    AddSchedule addSchedule;

    public AddScheduleTest(Class<FileManager> activityClass) {
        super(activityClass);
    }


    @Before
    public void setup() throws Exception {

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}