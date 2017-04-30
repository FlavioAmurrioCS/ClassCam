package cs321.classcamapp;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by tor on 4/30/17.
 */
public class ScheduleTest {

    private Date testD;

    @Before
    public void setup() throws Exception {
        testD = new Date(117,5,15);
    }

    @Test
    public void clearWeek() throws Exception {

    }

    @Test
    public void toListView() throws Exception {

    }

    @Test
    public void dateToString() throws Exception {
        assertEquals("The date should read: 6/15/2017","6/15/2017",Schedule.dateToString(testD));
    }

    @Test
    public void toFileString() throws Exception {

    }

    @Test
    public void startTimeToString() throws Exception {

    }

    @Test
    public void endTimeToString() throws Exception {

    }

    @Test
    public void getClassName() throws Exception {

    }

    @Test
    public void setClassName() throws Exception {

    }

    @Test
    public void getStartDate() throws Exception {

    }

    @Test
    public void setStartDate() throws Exception {

    }

    @Test
    public void getEndDate() throws Exception {

    }

    @Test
    public void setEndDate() throws Exception {

    }

    @Test
    public void getStartHour() throws Exception {

    }

    @Test
    public void setStartHour() throws Exception {

    }

    @Test
    public void getEndHour() throws Exception {

    }

    @Test
    public void setEndHour() throws Exception {

    }

    @Test
    public void getStartMin() throws Exception {

    }

    @Test
    public void setStartMin() throws Exception {

    }

    @Test
    public void getEndMin() throws Exception {

    }

    @Test
    public void setEndMin() throws Exception {

    }

    @Test
    public void addWeek() throws Exception {

    }

    @Test
    public void getWeekDay() throws Exception {

    }

    @Test
    public void classDBInput() throws Exception {

    }

    @Test
    public void classDBOutout() throws Exception {

    }

}