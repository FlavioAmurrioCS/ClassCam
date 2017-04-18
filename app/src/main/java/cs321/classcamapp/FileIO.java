package cs321.classcamapp;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Flavi on 4/12/2017.
 */

public class FileIO {

    static ArrayList<NoteRecord> dbInput(String filePath)
    {
        ArrayList<NoteRecord> ret = new ArrayList<NoteRecord>();
        try
        {
            Scanner sc = new Scanner(new File(filePath));
            while(sc.hasNext())
            {
                String line = sc.nextLine();
                ret.add(new NoteRecord(line));
            }
        }
        catch (Exception e)
        {
            //TODO
        }
        return ret;
    }
    static void dbOutout(ArrayList<NoteRecord> arr, String filePath)
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
            outputStream.print(arr.get(i).toDatabase());
        }//end for loop
        outputStream.close();
    }
}
