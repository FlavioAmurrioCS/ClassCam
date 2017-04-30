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
    private Schedule schd;

    @Before
    public void setup() throws Exception {
        testD = new Date(117,5,15);
        schd = new Schedule("UnOrganized###1451624400000###1577682000000###1###0###23###59###[Mon,Tue,Wed,Thurs,Fri,Sat,Sun]");
    }

    @Test
    public void clearWeek() throws Exception {

    }

    @Test//toListView method is tested at the end
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
        Schedule a = new Schedule();
        a.setStartHour(1);
        a.setStartMin(30);
        String expected = "1:30";
        assertEquals(expected, a.startTimeToString());
    }
    @Test
    public void startTimeToString1() throws Exception {
        Schedule a = new Schedule();
        a.setStartHour(9);
        a.setStartMin(5);
        String expected = "9:05";
        assertEquals(expected, a.startTimeToString());
    }

    @Test
    public void endTimeToString() throws Exception {
        Schedule a = new Schedule();
        a.setEndHour(1);
        a.setEndMin(30);
        String expected = "1:30";
        assertEquals(expected, a.endTimeToString());
    }

    @Test
    public void getClassName() throws Exception {
        assertEquals("UnOrganized",schd.getClassName());
    }

    @Test
    public void setClassName() throws Exception {
        Schedule schd2 = new Schedule();
        schd2.setClassName("Test1");
        assertEquals("Test1",schd2.getClassName());
    }

    @Test
    public void getStartDate() throws Exception {
        Date testDt;
        assertEquals(testDt = new Date(Long.parseLong("1451624400000")),schd.getStartDate());
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
        assertEquals("should equal 1", 1,schd.getStartHour());
    }

    @Test
    public void setStartHour() throws Exception {

    }

    @Test
    public void getEndHour() throws Exception {
        assertEquals("should equal 23",23,schd.getEndHour());
    }

    @Test
    public void setEndHour() throws Exception {

    }

    @Test
    public void getStartMin() throws Exception {
        assertEquals("should equal 0", 0,schd.getStartMin());
    }

    @Test
    public void setStartMin() throws Exception {
        Schedule schd1 = new Schedule();
        schd1.setStartMin(10);
        assertEquals("should equal 10",10,schd1.getStartMin());
    }

    @Test
    public void getEndMin() throws Exception {
        assertEquals("should equal 59", 59,schd.getEndMin());
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