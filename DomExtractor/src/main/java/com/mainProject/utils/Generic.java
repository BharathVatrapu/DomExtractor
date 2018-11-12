package com.mainProject.utils;

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generic {
    public static DefaultListModel listModel= new DefaultListModel();

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
    public static String getDateTime()
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy-kk-mm");
        String DateNow = dateFormat.format(date);
        return DateNow;

    }



    public static DefaultListModel readTextFile(String filePath){
        DefaultListModel listModel= new DefaultListModel();
        String[] readlines=null;
        try {
            listModel.removeAllElements();
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;

            while ((st = br.readLine()) != null) {
                listModel.addElement(st);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listModel;
    }
    public static String readText(String filePath){
        String st=null;
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {

                return st;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("read::"+st);
        return st;
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

    public static void getTheme(){

        switch (GlobalConstants.THEME){
            case "NeonBlue":
                GlobalConstants.header_Color_r= GlobalConstants.NeonBlue[0];
                GlobalConstants.header_Color_g= GlobalConstants.NeonBlue[1];
                GlobalConstants.header_Color_b= GlobalConstants.NeonBlue[2];

                GlobalConstants.body_Color_r=GlobalConstants.NeonBlue[3];
                GlobalConstants.body_Color_g= GlobalConstants.NeonBlue[4];
                GlobalConstants.body_Color_b= GlobalConstants.NeonBlue[5];
                break;
            case "SlateBlue":
                GlobalConstants.header_Color_r= GlobalConstants.SLATE_BLUE[0];
                GlobalConstants.header_Color_g= GlobalConstants.SLATE_BLUE[1];
                GlobalConstants.header_Color_b= GlobalConstants.SLATE_BLUE[2];

                GlobalConstants.body_Color_r=GlobalConstants.SLATE_BLUE[3];
                GlobalConstants.body_Color_g= GlobalConstants.SLATE_BLUE[4];
                GlobalConstants.body_Color_b= GlobalConstants.SLATE_BLUE[5];
                break;
            case "BitterSweet":
                GlobalConstants.header_Color_r= GlobalConstants.BitterSweet[0];
                GlobalConstants.header_Color_g= GlobalConstants.BitterSweet[1];
                GlobalConstants.header_Color_b= GlobalConstants.BitterSweet[2];

                GlobalConstants.body_Color_r=GlobalConstants.BitterSweet[3];
                GlobalConstants.body_Color_g= GlobalConstants.BitterSweet[4];
                GlobalConstants.body_Color_b= GlobalConstants.BitterSweet[5];
                break;
            case "Supernova":
                GlobalConstants.header_Color_r= GlobalConstants.Supernova[0];
                GlobalConstants.header_Color_g= GlobalConstants.Supernova[1];
                GlobalConstants.header_Color_b= GlobalConstants.Supernova[2];

                GlobalConstants.body_Color_r=GlobalConstants.Supernova[3];
                GlobalConstants.body_Color_g= GlobalConstants.Supernova[4];
                GlobalConstants.body_Color_b= GlobalConstants.Supernova[5];
                break;
            case "LaserLemon":
                GlobalConstants.header_Color_r= GlobalConstants.LaserLemon[0];
                GlobalConstants.header_Color_g= GlobalConstants.LaserLemon[1];
                GlobalConstants.header_Color_b= GlobalConstants.LaserLemon[2];

                GlobalConstants.body_Color_r=GlobalConstants.LaserLemon[3];
                GlobalConstants.body_Color_g= GlobalConstants.LaserLemon[4];
                GlobalConstants.body_Color_b= GlobalConstants.LaserLemon[5];
                break;
            case "MintGreen":
                GlobalConstants.header_Color_r= GlobalConstants.MintGreen[0];
                GlobalConstants.header_Color_g= GlobalConstants.MintGreen[1];
                GlobalConstants.header_Color_b= GlobalConstants.MintGreen[2];

                GlobalConstants.body_Color_r=GlobalConstants.MintGreen[3];
                GlobalConstants.body_Color_g= GlobalConstants.MintGreen[4];
                GlobalConstants.body_Color_b= GlobalConstants.MintGreen[5];
                break;
            case "PersianGreen":
                GlobalConstants.header_Color_r= GlobalConstants.PersianGreen[0];
                GlobalConstants.header_Color_g= GlobalConstants.PersianGreen[1];
                GlobalConstants.header_Color_b= GlobalConstants.PersianGreen[2];

                GlobalConstants.body_Color_r=GlobalConstants.PersianGreen[3];
                GlobalConstants.body_Color_g= GlobalConstants.PersianGreen[4];
                GlobalConstants.body_Color_b= GlobalConstants.PersianGreen[5];
                break;
            case "FuchiaPink":
                GlobalConstants.header_Color_r= GlobalConstants.FuchiaPink[0];
                GlobalConstants.header_Color_g= GlobalConstants.FuchiaPink[1];
                GlobalConstants.header_Color_b= GlobalConstants.FuchiaPink[2];

                GlobalConstants.body_Color_r=GlobalConstants.FuchiaPink[3];
                GlobalConstants.body_Color_g= GlobalConstants.FuchiaPink[4];
                GlobalConstants.body_Color_b= GlobalConstants.FuchiaPink[5];
                break;

            case "Default":
                GlobalConstants.header_Color_r= GlobalConstants.Default[0];
                GlobalConstants.header_Color_g= GlobalConstants.Default[1];
                GlobalConstants.header_Color_b= GlobalConstants.Default[2];

                GlobalConstants.body_Color_r=GlobalConstants.Default[3];
                GlobalConstants.body_Color_g= GlobalConstants.Default[4];
                GlobalConstants.body_Color_b= GlobalConstants.Default[5];
                break;
            case "Default1":
                GlobalConstants.header_Color_r= GlobalConstants.Default1[0];
                GlobalConstants.header_Color_g= GlobalConstants.Default1[1];
                GlobalConstants.header_Color_b= GlobalConstants.Default1[2];

                GlobalConstants.body_Color_r=GlobalConstants.Default1[3];
                GlobalConstants.body_Color_g= GlobalConstants.Default1[4];
                GlobalConstants.body_Color_b= GlobalConstants.Default1[5];

                GlobalConstants.button_Color_r=GlobalConstants.Default1[6];
                GlobalConstants.button_Color_g= GlobalConstants.Default1[7];
                GlobalConstants.button_Color_b= GlobalConstants.Default1[8];
                break;

            case "Default2":
                GlobalConstants.header_Color_r= GlobalConstants.Default2[0];
                GlobalConstants.header_Color_g= GlobalConstants.Default2[1];
                GlobalConstants.header_Color_b= GlobalConstants.Default2[2];

                GlobalConstants.body_Color_r=GlobalConstants.Default2[3];
                GlobalConstants.body_Color_g= GlobalConstants.Default2[4];
                GlobalConstants.body_Color_b= GlobalConstants.Default2[5];

                GlobalConstants.button_Color_r=GlobalConstants.Default2[6];
                GlobalConstants.button_Color_g= GlobalConstants.Default2[7];
                GlobalConstants.button_Color_b= GlobalConstants.Default2[8];
                break;
            case "Default3":
                GlobalConstants.header_Color_r= GlobalConstants.Default3[0];
                GlobalConstants.header_Color_g= GlobalConstants.Default3[1];
                GlobalConstants.header_Color_b= GlobalConstants.Default3[2];

                GlobalConstants.body_Color_r=GlobalConstants.Default3[3];
                GlobalConstants.body_Color_g= GlobalConstants.Default3[4];
                GlobalConstants.body_Color_b= GlobalConstants.Default3[5];

                GlobalConstants.button_Color_r=GlobalConstants.Default3[6];
                GlobalConstants.button_Color_g= GlobalConstants.Default3[7];
                GlobalConstants.button_Color_b= GlobalConstants.Default3[8];
                break;

        }

    }

    public static String pomEx(){
        String xpath = "//div/a[text()='example.com']";
        String findby = "@FindBy(how = How.XPATH, using = "+xpath+")";
        String cachelookup  = "@CacheLookup";
        String webelement = "public WebElement btnExample"+";";
        String pom = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;

        return pom;
    }
    public static String propEx(){
        String pom = "SignInPage.SignIn.Link = //div/a[text()='example.com']@@@xpath";
        return pom;
    }

    public static File changeExtension(File f, String newExtension) {
        int i = f.getName().lastIndexOf('.');
        String name = f.getName().substring(0,i);
        return new File(f.getParent() + "/" + name + newExtension);
    }

    public static String removeSpecialChars(String string){
        String str;
        str = string.replaceAll("\\s+","");
        str = str.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^|]*", "");
        return str;
    }

    public static void loadDefaultData(){
        listModel = Generic.readTextFile(GlobalConstants.DomExtractor_Config_Settings_file);
        if(!listModel.isEmpty()) {
            GlobalConstants.SETTINGS_FOLDER_PATH = listModel.get(0).toString();
            GlobalConstants.SETTINGS_DRIVER_FOLDER_PATH = listModel.get(1).toString();
            GlobalConstants.SETTINGS_DEFAULT_BROWSER = listModel.get(2).toString();
        }
        if(Generic.readText(GlobalConstants.DomExtractor_Config_Theme_file)==null) {
            Generic.writeText("NeonBlue",GlobalConstants.DomExtractor_Config_Theme_file,false);
            GlobalConstants.THEME = Generic.readText(GlobalConstants.DomExtractor_Config_Theme_file);
        } else{
            GlobalConstants.THEME = Generic.readText(GlobalConstants.DomExtractor_Config_Theme_file);
        }

        Generic.getTheme();
    }
}
