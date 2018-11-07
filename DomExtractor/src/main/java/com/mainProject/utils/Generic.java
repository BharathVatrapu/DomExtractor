package com.mainProject.utils;

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generic {

    public static String getDate(){
        String DateNow=null;
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            DateNow = dateFormat.format(date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return DateNow;
    }

    public static boolean createFolder(String dirPath){
        boolean fvar = false;
        try {
            File file = new File(dirPath);
            if (file.exists()) {
                fvar = true;
            } else {
                fvar = file.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fvar;
    }

    public static boolean createFile(String filePath){
        boolean fvar = false;
        try{
            File file = new File(filePath);
            if (file.exists()) {
                fvar = true;
            } else {
                fvar = file.createNewFile();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return fvar;
    }

    public static boolean isFileExist(String filePath){
        boolean fvar = true;
        try{
            File file = new File(filePath);
            if (file.exists()) {
                fvar = true;
            } else {
                fvar = false;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return fvar;
    }

    public static void writeText(String msg, String filePath,boolean existingText){
        try{
            File file = new File(filePath);
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),existingText);
            BufferedWriter wr = new BufferedWriter(fw);
            wr.write(msg);
            wr.newLine();
            wr.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getLastModifiedDateTime(String filePath){
        File settings = new File(filePath);
        long lastChanged = settings.lastModified();
        String lastUpdated = format(lastChanged);
        return lastUpdated;
    }
    public static String format(long time) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(new Date(time));
    }

    public static void deleteFile(File file) throws IOException {

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                file.delete();


            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    deleteFile(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    file.delete();
                }
            }

        }else{
            //if file, then delete it
            file.delete();
        }
    }

    public static String choosefolderPath(){
        // JOptionPane.showMessageDialog(null,"Select Project Directory upto 'src' Path!");
        String strPath = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose Path");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            strPath = chooser.getSelectedFile().toString();

        } else {
            JOptionPane.showMessageDialog(null,"Select Project Directory Path only!");
        }
        return strPath;
    }

    public static void fileEmpty(String fileImport) throws IOException {

        try {
            FileWriter fw = new FileWriter(fileImport);
            PrintWriter pw = new PrintWriter(fw);
            pw.write("");
            pw.flush();
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
