package cs321.classcamapp;


import java.io.File;
import java.util.Date;
import java.util.ArrayList;

/**
 * Created by Flavi on 3/30/2017.
 */

public class NoteRecord {
    // private int ID;
    private final Date timeStamp;
    private String fileName;
    private final String fileType;
    private ArrayList<String> tags;
    private String event;

    public NoteRecord(Date timeStamp, String fileType, String event) {
        this.timeStamp = timeStamp;
        this.fileName = nameSyntax(event, timeStamp, fileType);
        this.fileType = fileType;
        this.tags = new ArrayList<String>();
        this.event = event;
    }

    public NoteRecord(String fileStr) {
        String str[] = fileStr.split("###");
        this.event = str[0];
        this.timeStamp = new Date(Long.parseLong(str[1]));
        this.fileName = str[2];
        this.fileType = str[3];
        String strTag = str[4].substring(1, str[4].length() - 1);
        String tagArr[] = strTag.split(", ");
        this.tags = new ArrayList<String>();
        for (int i = 0; i < tagArr.length; i++) {
            this.tags.add(tagArr[i]);
        }
    }

    public String toDatabase() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.event);
        sb.append("###");
        sb.append(this.timeStamp.getTime());
        sb.append("###");
        sb.append(this.fileName);
        sb.append("###");
        sb.append(this.fileType);
        sb.append("###");
        sb.append(this.tags.toString());
        return sb.toString();
    }
    public Date getDate()
    {
        return this.timeStamp;
    }
    public void deleteFile()
    {
        File rm = new File(this.getFileLink());
        rm.delete();
    }

    public void moveTo(String newEvent)
    {
        File oldFile = new File(this.getFileLink());
        String newFileName = nameSyntax(newEvent,this.timeStamp,this.fileType);
        File newFile = new File(FileManager.getFolderName() + "/" + newEvent + "/" + newFileName);
        oldFile.renameTo(newFile);
        this.event = newEvent;
        this.fileName = newFileName;
//        File
    }

    static String nameSyntax(String event, Date timeStamp, String fileType) {
        StringBuffer sb = new StringBuffer();
        sb.append(event);
        sb.append("_");
        sb.append((timeStamp.getYear() + 1900));
        sb.append("_");
        sb.append((timeStamp.getMonth() + 1));
        sb.append("_");
        sb.append(timeStamp.getDate());
        sb.append("_");
        sb.append(timeStamp.getHours());
        sb.append("_");
        sb.append(timeStamp.getMinutes());
        sb.append("_");
        sb.append((timeStamp.getSeconds()));
        sb.append("." + fileType);
        return sb.toString();

        //CS321_2017_04_23_19_23_32.jpg
    }

    public String getEvent() {
        return this.event;
    }

    private void updateFileName() {
        // TODO: Update file in android
        this.fileName = nameSyntax(this.event, this.timeStamp, this.fileType);
    }

    public void setEvent(String str) {
        this.event = str;
        updateFileName();

    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getFileName() {
        return this.fileName;
    }
    public String getFileLink()
    {
//        String ret = FileManager.getFolderName() + "/" + this.fileName;
        String ret = FileManager.getFolderName() + "/" + this.event + "/" + this.fileName;
        return ret;
    }

    public String getFileType() {
        return this.fileType;
    }

    public boolean addTag(String str) {
        if (!this.tags.contains(str)) {
            return this.tags.add(str);
        }
        return false;
    }

    public void removeTag(String str) {
        this.tags.remove(str);
    }

    public boolean equals(NoteRecord nr) {
        return (this.timeStamp.equals(nr.timeStamp) && this.event.equals(nr.event));
    }

}
