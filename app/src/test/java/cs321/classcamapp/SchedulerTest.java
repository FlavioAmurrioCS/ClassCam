package cs321.classcamapp;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Flavio on 4/30/2017.
 */

public class SchedulerTest extends ActivityInstrumentationTestCase2<FileManager> {

    Scheduler scheduler;

    public SchedulerTest(Class<FileManager> activityClass) {
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
