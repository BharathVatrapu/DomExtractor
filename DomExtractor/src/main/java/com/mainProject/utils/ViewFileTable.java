package com.mainProject.utils;

public class ViewFileTable {

    private int sno;
    private String fileName;
    private String createDate;


    public ViewFileTable(int sno, String fileName, String createDate){
        this.sno = sno;
        this.fileName = fileName;
        this.createDate = createDate;
    }


    public String getfileName() {
        return fileName;
    }
    public String getcreateDate(){
        return createDate;
    }

    public int getSno()
    {
        return sno;
    }

    public void setselectName(int sno)
    {
        this.sno = sno;
    }
}
