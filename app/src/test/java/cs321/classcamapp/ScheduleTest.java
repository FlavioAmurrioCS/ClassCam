package cs321.classcamapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        Schedule schd = new Schedule("UnOrganized###1451624400000###1577682000000###1###0###23###59###[Mon,Tue,Wed,Thurs,Fri,Sat,Sun]");
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
        assertNotEquals("The date should not equal: 7/15/2017", "7/15/2017", Schedule.dateToString(testD));
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
    @Test
    public void clearWeekTest() throws Exception{
        Schedule s = new Schedule();

        ArrayList<String> expected = new ArrayList<>();
        s.addWeek("Mon");
        s.addWeek("Tue");
        s.addWeek("Fri");
        s.clearWeek();
        assertEquals(expected, s.getWeekDay());
    }

    @Test
    public void toListViewTest() throws Exception{
        Schedule s = new Schedule();
        s.setStartHour(12);
        s.setStartMin(0);
        s.setEndHour(1);
        s.setEndMin(30);
        s.setClassName("CS123");
        s.addWeek("Mon");
        s.addWeek("Tue");
        s.setStartDate(new Date(120,2,23));
        s.setEndDate(new Date(120,2,27));
        String expected = "CS123 - [Mon, Tue]\nTime: 12:00 - 1:30\n3/23/2020 - 3/27/2020";
        assertEquals(expected, s.toListView());
    }

    @Test
    public void dateToStringTest() throws Exception{
        Schedule s = new Schedule();
        Date a = new Date();
        a.setDate(23);
        a.setMonth(3);
        a.setYear(120);
        String expect = "4/23/2020";
        assertEquals(expect, s.dateToString(a));
    }
}