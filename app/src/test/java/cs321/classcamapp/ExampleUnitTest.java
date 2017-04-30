package cs321.classcamapp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
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