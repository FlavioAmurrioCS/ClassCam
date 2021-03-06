package cs321.classcamapp;

import android.provider.ContactsContract;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Flavi on 3/30/2017.
 */
//Hello
public class NoteDatabase {
    private String folderName;
    private static ArrayList<NoteRecord> database;

    public NoteDatabase(String fileIO) {
        this.database = FileIO.dbInput(fileIO);
    }
    public NoteDatabase()
    {
        database = new ArrayList<NoteRecord>();
    }



    public int getSize() {
        return this.database.size();
    }

    public ArrayList<NoteRecord> getFileList(String event) {
        ArrayList<NoteRecord> retList = new ArrayList<NoteRecord>();
        for (int i = database.size() - 1; i > -1; i--) {

            if (database.get(i).getEvent().equals(event)) {
                retList.add(database.get(i));
            }
        }
        return retList;
    }

    public ArrayList<NoteRecord> getArrayList() {
        return this.database;
    }

    public boolean reOrganizedFiles()
    {
        boolean changed = false;
        for(int i = 0; i<this.database.size(); i++)
        {
            NoteRecord nr = this.database.get(i);
            String cur = checkClass(nr.getDate());
            if(!nr.getEvent().equals(cur))
            {
                nr.moveTo(cur);
                changed = true;
            }
            //else do nothing
        }
        if(changed)
        {
            FileIO.dbOutout(this.database, MainActivity.noteDBName);
        }
        return changed;
    }
    public static String checkClass(Date dt){
        Schedule s;
//        for (int i = database.size() - 1; i > -1; i--) {
        for(int i=MainActivity.classSchedule.size()-1; i > -1; i--){
//        for(int i=0; i < classSchedule.size() - 1; i++){
            s = MainActivity.classSchedule.get(i);
            int currentHour = dt.getHours();
            int currentMin = dt.getMinutes();
            if(dt.after(s.getStartDate()) && dt.before(s.getEndDate())) {    //within callender date
                if ((currentHour > s.getStartHour()) && currentHour < s.getEndHour()) {    // within class period hour
                    return s.getClassName();
                } else if (currentHour == s.getStartHour()) {
                    if (currentMin > s.getStartMin()) {
                        return s.getClassName();
                    }
                } else if (currentHour == s.getEndHour()) {
                    if (currentMin < s.getStartMin()) {
                        return s.getClassName();
                    }
                }
            }

        }
        return "Unclassified";
    }

    public String saveFileName()
    {
        Date dt = new Date();
        String type = "jpg";
        String event = MainActivity.checkClass();
        NoteRecord nr = new NoteRecord(dt, type, event);
        this.database.add(nr);
        FileIO.dbOutout(this.database, MainActivity.noteDBName);

        //Addded this for subfolder Structure
        File subFolder = new File(FileManager.getFolderName(), event);
        if(!subFolder.exists())
        {
            subFolder.mkdir();
        }
        String fileName = subFolder.getAbsolutePath() + "/" + nr.getFileName();
        return fileName;
//        return nr.getFileName();

    }

    public boolean addFile(String event, String type, Date timestamp) {
        NoteRecord nr = new NoteRecord(timestamp, type, event);
        this.database.add(nr);
        FileIO.dbOutout(this.database, MainActivity.noteDBName);
        return true;
    }

    //Adding a file with only a timestamp
    public boolean addFile(Date timestamp){
        NoteRecord nr = new NoteRecord(timestamp, ".jpg", MainActivity.checkClass());
//        this.dataCount++;
        this.database.add(nr);
        FileIO.dbOutout(this.database, MainActivity.noteDBName);
        return true;
    }

    public ArrayList<NoteRecord> search(ArrayList<String> tags, String event) {
        ArrayList<NoteRecord> toSearch = new ArrayList<>();
        if (event != null || event.equals("")) {
            for (int i = 0; i < MainActivity.noteDB.getSize(); i++) {
                NoteRecord nr = this.database.get(i);
                if (nr.getEvent().equals(event) && nr.getTags().containsAll(tags)) {
                    toSearch.add(nr);
                }
            }
        } else {
            for (int i = 0; i < MainActivity.noteDB.getSize(); i++) {
                NoteRecord nr = this.database.get(i);
                if (nr.getTags().containsAll(tags)) {
                    toSearch.add(nr);
                }
            }
        }
        return toSearch;
    }

    public boolean removeFile(NoteRecord nr) {
//        dataCount--;
        nr.deleteFile();
        this.database.remove(nr);
        FileIO.dbOutout(this.database, MainActivity.noteDBName);
        return true;
    }

    public String[] toStringArray() {
        String arr[] = new String[this.database.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.database.get(i).toString();
        }
        return arr;
    }

    public static String[] toStringArray(ArrayList<NoteRecord> arrList) {
        String arr[] = new String[arrList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrList.get(i).toString();
        }
        return arr;
    }

    public String getLast()
    {
        return database.get(database.size()-1).toString();
    }
}
