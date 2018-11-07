package com.mainProject.frames;

/**
 * Created by bvatrapu on 8/9/2017.
 */

import com.mainProject.utils.Generic;
import com.mainProject.utils.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreen extends JFrame {

    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;

    public SplashScreen() {
        super("Splash");
        setSize(580, 310);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/img/SplashScreen_Pro.png"));
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, 580, 310);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 290, 580, 20);

        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }

    public static void main(String args[])throws Exception{
        SplashScreen ss=new SplashScreen();
        ss.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(10000);
        ss.dispose();
        if(setupXtractor()){
         //   new XpathXtractor().setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "Setup Incomplete", "Terminating.. " , JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static boolean setupXtractor(){
        boolean flag=true;
        if(!Generic.createFolder(GlobalConstants.Xtractor_Home_folder)){
            flag=false;
        }
        if(!Generic.createFolder(GlobalConstants.Xtractor_pom_folder)){
            flag=false;
        }

        if(!Generic.createFile(GlobalConstants.Xtractor_Url_file)){
            flag=false;
        }
        if(!Generic.createFile(GlobalConstants.Xtractor_path_file)){
            flag=false;
        }
        return flag;
    }

}