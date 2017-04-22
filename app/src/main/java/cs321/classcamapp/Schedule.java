package cs321.classcamapp;

import java.io.File;
import java.io.PrintWriter;
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
    private ArrayList<String> week;

    public Schedule()
    {
        week = new ArrayList<>();
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
        String temp [] = w.split(", ");
        for(int i = 0; i < temp.length; i++){
            week.add(temp[i]);
        }
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
        sb.append(week.toString());
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

    public void addWeek(String w){
        this.week.add(w);
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
        while(sc.hasNext())
        {
            retList.add(new Schedule(sc.nextLine()));
        }
        return retList;
    }

    static void classDBOutout(ArrayList<Schedule> arr, String filePath)
    {
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(filePath);// create  the file
        }
        catch (Exception e)
        {
            System.out.println ("Error opening the file " + filePath);// if there is  no possible to create  the file
            System.exit (0);
        }
        for (int i = 0; i < arr.size(); i++)
        {
            outputStream.print(arr.get(i).toFileString());
        }//end for loop
        outputStream.close();
    }






}
