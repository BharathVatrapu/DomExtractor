package com.mainProject.utils;

import java.io.File;

public class GlobalConstants {

    public static String Xtractor_Home_folder = System.getProperty("user.home")+File.separator+"Xtractor";
    public static String Xtractor_pom_folder = Xtractor_Home_folder+File.separator+"pom";
    public static String Xtractor_Url_file = Xtractor_Home_folder+File.separator+"url.txt";
    public static String Xtractor_path_file = Xtractor_Home_folder+File.separator+"path.txt";


    public static String Xtractor_Img_Path = System.getProperty("user.dir") +File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"img"+File.separator;

}
