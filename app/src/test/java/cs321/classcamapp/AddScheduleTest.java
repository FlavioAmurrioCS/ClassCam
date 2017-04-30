package cs321.classcamapp;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by MyLe on 4/30/17.
 */
public class AddScheduleTest {
    AddSchedule as;

//    @Before
//    public void setup() throws  Exception{
//        as.getClass();
//    }

    @Test
    public void test1(){
        int cb[] = as.stringToTime("12:30");
        int[] exptected = {12,30};
        assertEquals(exptected, cb);
    }

    @Test
    public void stringToDateTest1(){
        String d = "2/9/2012";
        assertEquals(new Date(112, 2, 9), as.stringToDate(d));
    }

    @Test
    public void stringToDateTest2(){
        String d = "10/12/2012";
        assertEquals(new Date(112, 10, 12), as.stringToDate(d));
    }

    public int[] stringToTime(String str) {
        String[] spl = str.split(":");
        int time[] = new int[2];
        for (int i = 0; i < 2; i++)
            time[i] = Integer.parseInt(spl[i]);
        return time;
    }
    @Test
    public void stringToTimeTest1() {
        int expected[] = {12, 30};
        assertTrue(Arrays.equals(expected, as.stringToTime("12:30")));
    }

    @Test
    public void stringToTimeTest2(){
        int expected[] = {2, 3};
        assertTrue(Arrays.equals(expected, as.stringToTime("2:03")));
    }
}