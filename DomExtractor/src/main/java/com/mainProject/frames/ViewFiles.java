package com.mainProject.frames;


import com.mainProject.utils.Generic;
import com.mainProject.utils.GlobalConstants;
import com.mainProject.utils.ViewFileTable;
import com.mainProject.utils.ViewFilesTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BhaRatH
 */
public class ViewFiles extends javax.swing.JPanel {

    ViewFilesTableModel viewFilesTableModel = null;
    public String resultsDirectory = null;
    /**
     * Creates new form Extractor
     */
    public ViewFiles() {
        initComponents();
        initLoad();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelViewFiles = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFiles = new javax.swing.JTable();
        btnOpen = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        panelViewFiles.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        panelViewFiles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

//        tblFiles.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null}
//                },
//                new String [] {
//                        "Title 1", "Title 2", "Title 3", "Title 4"
//                }
//        ));
//        jScrollPane3.setViewportView(tblFiles);

        tblFiles.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));

        jScrollPane3.setViewportView(tblFiles);

        tblFiles.getSelectionModel().addListSelectionListener(new SelectionListener());

        btnOpen.setFont(new java.awt.Font("Tahoma", 1, 13));
        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    btnOpenActionPerformed(evt);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 13));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    btnDeleteActionPerformed(evt);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout panelViewFilesLayout = new javax.swing.GroupLayout(panelViewFiles);
        panelViewFiles.setLayout(panelViewFilesLayout);
        panelViewFilesLayout.setHorizontalGroup(
                panelViewFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelViewFilesLayout.createSequentialGroup()
                                .addGroup(panelViewFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelViewFilesLayout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(120, 120, 120)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelViewFilesLayout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        panelViewFilesLayout.setVerticalGroup(
                panelViewFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelViewFilesLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(panelViewFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelViewFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelViewFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblFiles.getSelectedRow();
            if(row < 0)
                return;
            int col = tblFiles.getSelectedColumn();
            if(col < 0)
                return;

            tblFiles.clearSelection();
            resultsDirectory = GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+tblFiles.getModel().getValueAt(row, 1);
            tblFiles.setSelectionBackground(Color.BLUE);
        }
    }
    public ViewFilesTableModel getModel(String dirPath) {
        int i=1;

        File file = new File(dirPath);
        String[] names = file.list();
        //build the list
        List<ViewFileTable> viewFileList = new ArrayList<ViewFileTable>();
        if (names!=null) {
            for (String name : names) {
               // if (new File(dirPath + name).isFile()) {

                    ViewFileTable viewFileTable = new ViewFileTable(i, name, Generic.getLastModifiedDateTime(dirPath + name));
                     viewFileList.add(viewFileTable);
                    i=i+1;
              //  }
            }

        }
        viewFilesTableModel = new ViewFilesTableModel(viewFileList);
        return viewFilesTableModel;
    }
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt)throws Exception {
        if(resultsDirectory==null){
            JOptionPane.showMessageDialog(null, "Select File Name", "Warning" , JOptionPane.INFORMATION_MESSAGE);
        } else {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe",resultsDirectory);
            pb.start();
        }

    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)throws Exception {
        if(resultsDirectory==null){
            JOptionPane.showMessageDialog(null, "Select File Name", "Warning" , JOptionPane.INFORMATION_MESSAGE);
        } else{
            File directory = new File(resultsDirectory);
            try{
                Generic.deleteFile(directory);
            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
        tblFiles.setModel(getModel(GlobalConstants.SETTINGS_FOLDER_PATH));
    }

    public void initLoad(){
        tblFiles.setModel(getModel(GlobalConstants.SETTINGS_FOLDER_PATH));
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelViewFiles;
    public static javax.swing.JTable tblFiles;
    // End of variables declaration
}
