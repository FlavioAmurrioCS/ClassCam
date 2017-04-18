package com.classcam.classcam;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Flavi on 3/30/2017.
 */

public class NoteDatabase {
    private String folderName;
    private ArrayList<NoteRecord> database;
    private int dataCount = 0;

    public NoteDatabase(String fileIO) {
        this.database = FileIO.dbInput(fileIO);
        this.dataCount = this.database.size();
    }

    public int getSize() {
        return this.dataCount;
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

    public boolean addFile(String event, String type, Date timestamp) {
        NoteRecord nr = new NoteRecord(timestamp, type, event);
        this.dataCount++;
        this.database.add(nr);
        FileIO.dbOutout(this.database, FileManager.DBFILENAME);
        return true;
    }

    public ArrayList<NoteRecord> search(ArrayList<String> tags, String event) {
        ArrayList<NoteRecord> toSearch = new ArrayList<>();
        if (event != null || event.equals("")) {
            for (int i = 0; i < FileManager.NTDB.dataCount; i++) {
                NoteRecord nr = this.database.get(i);
                if (nr.getEvent().equals(event) && nr.getTags().containsAll(tags)) {
                    toSearch.add(nr);
                }
            }
        } else {
            for (int i = 0; i < FileManager.NTDB.dataCount; i++) {
                NoteRecord nr = this.database.get(i);
                if (nr.getTags().containsAll(tags)) {
                    toSearch.add(nr);
                }
            }
        }
        return toSearch;
    }

    public boolean removeFile(NoteRecord nr) {
        dataCount--;
        this.database.remove(nr);
        FileIO.dbOutout(this.database, FileManager.DBFILENAME);
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
}