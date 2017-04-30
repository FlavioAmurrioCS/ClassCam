package cs321.classcamapp;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by tor on 4/30/17.
 */
public class MainActivityTest{

    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void openCameraActivity() throws Exception {

    }

    @Test
    public void openSchedule() throws Exception {

    }

    @Test
    public void openFileManager() throws Exception {

    }

@Test
    public void checkClass() throws Exception {
        Schedule test = new Schedule();
        test.setClassName("Unclassified");
        test.setStartDate(new Date(116, 0, 1));
        test.setEndDate(new Date(119, 11, 30));
        test.setStartHour(1);
        test.setStartMin(00);
        test.setEndHour(23);
        test.setEndMin(59);
        test.addWeek("Mon");
        test.addWeek("Tue");
        test.addWeek("Wed");
        test.addWeek("Thurs");
        test.addWeek("Fri");
        test.addWeek("Sat");
        test.addWeek("Sun");
        MainActivity.classSchedule.add(test);
    assertEquals(test.getClassName(), MainActivity.checkClass());
}

    @Test
    public void checkClass2() throws Exception {
        Date now = new Date();
        Schedule test2 = new Schedule();
        test2.setClassName("Class");
        test2.setStartDate(new Date(116, 0, 1));
        test2.setEndDate(new Date(119, 11, 30));
        test2.setStartHour(now.getHours());
        test2.setStartMin(now.getMinutes());
        test2.setEndHour(now.getHours()+1);
        test2.setEndMin(now.getMinutes() + 2);
        test2.addWeek("Mon");
        test2.addWeek("Tue");
        test2.addWeek("Wed");
        test2.addWeek("Thurs");
        test2.addWeek("Fri");
        test2.addWeek("Sat");
        test2.addWeek("Sun");
        MainActivity.classSchedule.add(test2);
        assertEquals(test2.getClassName(), MainActivity.checkClass());
    }

    @Test
    public void currentlyClassPeriod() throws Exception {

    }

    @Test
    public void newCameraOpen() throws Exception {

    }

}