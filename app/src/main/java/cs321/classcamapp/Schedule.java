package cs321.classcamapp;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Flavio on 4/19/2017.
 */

public class Schedule {

    private String className;
    private Date startDate, endDate;
    private int startHour, endHour, startMin,endMin;
    private String week[];

    public Schedule()
    {
        //Nothing
    }

    public Schedule(String input) {
        String split []= input.split("###");
        this.setClassName(split[0]);
        this.setStartDate(new Date(Long.parseLong(split[1])));
        this.setEndDate(new Date(Long.parseLong(split[2])));
        this.setStartHour(Integer.parseInt(split[3]));
        this.setStartMin(Integer.parseInt(split[4]));
        this.setEndHour(Integer.parseInt(split[5]));
        this.setEndMin(Integer.parseInt(split[6]));
        String w = split[7].substring(1, split[7].length() - 1);
        this.week = w.split(", ");
    }

    public String toFileString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.className);
        sb.append("###");
        sb.append(this.startDate.getTime());
        sb.append("###");
        sb.append(this.endDate.getTime());
        sb.append("###");
        sb.append(this.startHour);
        sb.append("###");
        sb.append(this.startMin);
        sb.append("###");
        sb.append(this.endHour);
        sb.append("###");
        sb.append(this.endMin);
        sb.append(Arrays.toString(week));
        return sb.toString();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }


    public static ArrayList<Schedule> classDBInput(String fileName)
    {
        Scanner sc;
        ArrayList<Schedule> retList = new ArrayList<>();
        try
        {
            sc = new Scanner(new File(fileName));
        }
        catch(Exception e)
        {
            return retList;
        }
        while

    }
}
