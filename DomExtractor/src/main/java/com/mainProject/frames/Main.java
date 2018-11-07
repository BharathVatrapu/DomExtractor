package com.mainProject.frames;

import com.mainProject.utils.Generic;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bvatrapu
 */
public class Main extends JFrame {

    GridBagLayout gridBagLayout = new GridBagLayout();
    static Extractor extractor;
    static SmartExtractor smartExtractor;
    static Themes themes;
    static About about;
    static Settings settings;
    static ViewFiles viewFiles;
    static Home home;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    /**
     * Creates new form ObjectExtractor
     */

    public Main() {
        initComponents();
        extractor = new Extractor();
        smartExtractor = new SmartExtractor();
        themes = new Themes();
        about = new About();
        settings = new Settings();
        viewFiles = new ViewFiles();
        home = new Home();

        panelBody.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(extractor,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(smartExtractor,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(themes,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(about,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(settings,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(viewFiles,c);
        c.gridx = 0;
        c.gridy = 0;
        panelBody.add(home,c);

        extractor.setVisible(false);
        smartExtractor.setVisible(false);
        themes.setVisible(false);
        about.setVisible(false);
        settings.setVisible(false);
        viewFiles.setVisible(false);
        home.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelHeader = new JPanel();
        imgLogo = new JLabel();
        btnClose = new JButton();
        btnMinimize = new JButton();
        txtDate = new JLabel();
        txtDOM = new JLabel();
        txtExtractor = new JLabel();
        imgHtml = new JLabel();
        imgConvert = new JLabel();
        imgTXT = new JLabel();
        imgLogo1 = new JLabel();
        panelSide = new JPanel();
        btnSettings = new JButton();
        btnHome = new JButton();
        btnExtractor = new JButton();
        btnTheme = new JButton();
        btnHelp = new JButton();
        btnSideClose = new JButton();
        btnSmartExtrator = new JButton();
        btnOpenFile = new JButton();
        btnAbout = new JButton();
        panelBody = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setLocationRelativeTo(null);
        setUndecorated(true);

        panelHeader.setBackground(new Color(204, 204, 255));

        imgLogo.setIcon(new ImageIcon(getClass().getResource("/icons/Source_Code_48px.png")));

        btnClose.setBackground(new Color(204, 204, 255));
        btnClose.setIcon(new ImageIcon(getClass().getResource("/icons/Delete_20px.png")));
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosesActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new Color(204, 204, 255));
        btnMinimize.setIcon(new ImageIcon(getClass().getResource("/icons/Subtract_20px.png")));
        btnMinimize.setBorder(null);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setFocusPainted(false);
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setState(Frame.ICONIFIED);
            }
        });

        txtDate.setFont(new Font("Verdana", 0, 12));
        txtDate.setForeground(new Color(51, 0, 255));
        txtDate.setText(Generic.getDate());

        txtDOM.setFont(new Font("Tahoma", 1, 24));
        txtDOM.setForeground(new Color(0, 153, 255));
        txtDOM.setText("DOM");

        txtExtractor.setFont(new Font("Tahoma", 1, 24));
        txtExtractor.setForeground(new Color(51, 0, 255));
        txtExtractor.setText("Extractor");

        imgHtml.setIcon(new ImageIcon(getClass().getResource("/icons/HTML_Filetype_48px.png")));

        imgConvert.setIcon(new ImageIcon(getClass().getResource("/icons/Outgoing_Data_48px.png")));

        imgTXT.setIcon(new ImageIcon(getClass().getResource("/icons/Code_File_48px.png")));

        imgLogo1.setIcon(new ImageIcon(getClass().getResource("/icons/Origami_62px.png")));

        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imgLogo1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDOM)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgLogo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExtractor)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                                .addComponent(imgHtml)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(imgConvert)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(imgTXT)
                                                .addGap(121, 121, 121)
                                                .addComponent(btnMinimize)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnClose))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                                .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addComponent(btnClose)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addComponent(btnMinimize)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDate)))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtExtractor)
                                                .addComponent(imgLogo)
                                                .addComponent(txtDOM)
                                                .addComponent(imgTXT)
                                                .addComponent(imgConvert)
                                                .addComponent(imgHtml))
                                        .addComponent(imgLogo1))
                                .addGap(22, 22, 22))
        );

        panelSide.setBackground(new Color(102, 102, 102));

        btnSettings.setBackground(new Color(102, 102, 102));
        btnSettings.setFont(new Font("Segoe UI", 1, 12));
        btnSettings.setIcon(new ImageIcon(getClass().getResource("/icons/Settings_26px.png")));
        btnSettings.setText("  Settings");
        btnSettings.setBorder(null);
        btnSettings.setBorderPainted(false);
        btnSettings.setFocusPainted(false);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnHome.setBackground(new Color(102, 102, 102));
        btnHome.setFont(new Font("Segoe UI", 1, 12));
        btnHome.setIcon(new ImageIcon(getClass().getResource("/icons/Home_26px.png")));
        btnHome.setText("   Home");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExtractor.setBackground(new Color(102, 102, 102));
        btnExtractor.setFont(new Font("Segoe UI", 1, 12));
        btnExtractor.setIcon(new ImageIcon(getClass().getResource("/icons/Property_Script_26px.png")));
        btnExtractor.setText("Extractor");
        btnExtractor.setBorder(null);
        btnExtractor.setBorderPainted(false);
        btnExtractor.setFocusPainted(false);
        btnExtractor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractorActionPerformed(evt);
            }
        });

        btnTheme.setBackground(new Color(102, 102, 102));
        btnTheme.setFont(new Font("Segoe UI", 1, 12));
        btnTheme.setIcon(new ImageIcon(getClass().getResource("/icons/Paint_Palette_26px.png")));
        btnTheme.setText("Theme");
        btnTheme.setBorder(null);
        btnTheme.setBorderPainted(false);
        btnTheme.setFocusPainted(false);
        btnTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemeActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new Color(102, 102, 102));
        btnHelp.setFont(new Font("Segoe UI", 1, 12));
        btnHelp.setIcon(new ImageIcon(getClass().getResource("/icons/Help_26px.png")));
        btnHelp.setText("Help");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setFocusPainted(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnSideClose.setBackground(new Color(102, 102, 102));
        btnSideClose.setFont(new Font("Segoe UI", 1, 12));
        btnSideClose.setIcon(new ImageIcon(getClass().getResource("/icons/Shutdown_26px.png")));
        btnSideClose.setText("Close");
        btnSideClose.setBorder(null);
        btnSideClose.setBorderPainted(false);
        btnSideClose.setFocusPainted(false);
        btnSideClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideCloseActionPerformed(evt);
            }
        });

        btnSmartExtrator.setBackground(new Color(102, 102, 102));
        btnSmartExtrator.setFont(new Font("Segoe UI", 1, 12));
        btnSmartExtrator.setIcon(new ImageIcon(getClass().getResource("/icons/Pin_Pad_20px.png")));
        btnSmartExtrator.setText("Smart Extractor");
        btnSmartExtrator.setBorder(null);
        btnSmartExtrator.setBorderPainted(false);
        btnSmartExtrator.setFocusPainted(false);
        btnSmartExtrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmartExtratorActionPerformed(evt);
            }
        });

        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnOpenFile.setFont(new Font("Segoe UI", 1, 12));
        btnOpenFile.setIcon(new ImageIcon(getClass().getResource("/icons/Open_View_26px.png")));
        btnOpenFile.setText("View Files");
        btnOpenFile.setBorder(null);
        btnOpenFile.setBorderPainted(false);
        btnOpenFile.setFocusPainted(false);
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        btnAbout.setBackground(new Color(102, 102, 102));
        btnAbout.setFont(new Font("Segoe UI", 1, 12));
        btnAbout.setIcon(new ImageIcon(getClass().getResource("/icons/About_26px.png")));
        btnAbout.setText("About");
        btnAbout.setBorder(null);
        btnAbout.setBorderPainted(false);
        btnAbout.setFocusPainted(false);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        GroupLayout panelSideLayout = new GroupLayout(panelSide);
        panelSide.setLayout(panelSideLayout);
        panelSideLayout.setHorizontalGroup(
                panelSideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExtractor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTheme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSideClose, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSmartExtrator, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpenFile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSideLayout.setVerticalGroup(
                panelSideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSideLayout.createSequentialGroup()
                                .addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnExtractor, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSmartExtrator, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnOpenFile, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnTheme, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnSideClose, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        panelBody.setBackground(new Color(0, 153, 255));

        GroupLayout panelBodyLayout = new GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 670, Short.MAX_VALUE)
        );
        panelBodyLayout.setVerticalGroup(
                panelBodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(panelSide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnClosesActionPerformed(java.awt.event.ActionEvent evt) {
        close();
    }
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {
        btnHome.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnExtractor.setBackground(new Color(102, 102, 102));
        btnSmartExtrator.setBackground(new Color(102, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));

        smartExtractor.setVisible(false);
        themes.setVisible(false);
        about.setVisible(false);
        settings.setVisible(false);
        extractor.setVisible(false);
        home.setVisible(true);
    }
    private void btnExtractorActionPerformed(java.awt.event.ActionEvent evt) {
        btnExtractor.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnHome.setBackground(new Color(102, 102, 102));
        btnSmartExtrator.setBackground(new Color(102, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));



        smartExtractor.setVisible(false);
        themes.setVisible(false);
        about.setVisible(false);
        settings.setVisible(false);
        extractor.setVisible(true);

    }
    private void btnSmartExtratorActionPerformed(java.awt.event.ActionEvent evt) {
        btnSmartExtrator.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnHome.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));


        extractor.setVisible(false);
        themes.setVisible(false);
        about.setVisible(false);
        settings.setVisible(false);
        smartExtractor.setVisible(true);

    }
    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {
        btnSettings.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnHome.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));


        extractor.setVisible(false);
        smartExtractor.setVisible(false);
        about.setVisible(false);
        themes.setVisible(false);
        settings.setVisible(true);

    }

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {
        btnOpenFile.setBackground(new Color(255, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnHome.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));
        panelBody.setBackground(new Color(255, 102, 102));

    }

    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {

        btnTheme.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnHome.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnSmartExtrator.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));

        extractor.setVisible(false);
        smartExtractor.setVisible(false);
        about.setVisible(false);
        settings.setVisible(false);
        themes.setVisible(true);

    }
    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {
        btnAbout.setBackground(new Color(204, 255, 255));
        panelBody.setBackground(new Color(204, 255, 255));

        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnHome.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));

        extractor.setVisible(false);
        smartExtractor.setVisible(false);
        themes.setVisible(false);
        settings.setVisible(false);
        about.setVisible(true);

    }
    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {
        btnHelp.setBackground(new Color(255, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnHome.setBackground(new Color(102, 102, 102));
        btnSettings.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));
        panelBody.setBackground(new Color(255, 102, 102));

        new Help().setVisible(true);
    }
    private void btnSideCloseActionPerformed(java.awt.event.ActionEvent evt) {
        close();

    }


    public void initLoading(){
        btnSettings.setBackground(new Color(255, 102, 102));
        btnHome.setBackground(new Color(102, 102, 102));
        btnExtractor.setBackground(new Color(102, 102, 102));
        btnOpenFile.setBackground(new Color(102, 102, 102));
        btnTheme.setBackground(new Color(102, 102, 102));
        btnAbout.setBackground(new Color(102, 102, 102));
        btnHelp.setBackground(new Color(102, 102, 102));
        btnClose.setBackground(new Color(102, 102, 102));
        panelBody.setBackground(new Color(255, 102, 102));

        btnHelp.setEnabled(false);
    }
    public void close(){
        setVisible(false);
        dispose();
    }



    // Variables declaration - do not modify
    private JButton btnAbout;
    private JButton btnClose;
    private JButton btnExtractor;
    private JButton btnHelp;
    private JButton btnHome;
    private JButton btnMinimize;
    private JButton btnOpenFile;
    private JButton btnSettings;
    private JButton btnSideClose;
    private JButton btnSmartExtrator;
    private JButton btnTheme;
    private JLabel imgConvert;
    private JLabel imgHtml;
    private JLabel imgLogo;
    private JLabel imgLogo1;
    private JLabel imgTXT;
    private JPanel panelBody;
    private JPanel panelHeader;
    private JPanel panelSide;
    private JLabel txtDOM;
    private JLabel txtDate;
    private JLabel txtExtractor;
    // End of variables declaration
}
