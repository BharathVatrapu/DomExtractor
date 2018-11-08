package com.mainProject.frames;


import com.mainProject.utils.Generic;
import com.mainProject.utils.GlobalConstants;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author BhaRatH
 */
public class SelectUrls extends javax.swing.JFrame {
    DefaultListModel  listModel= new DefaultListModel();
    DefaultListModel  readText= new DefaultListModel();
    /**
     * Creates new form SelectUrls
     */
    public SelectUrls() {
        initComponents();
        getUrls();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelSelectUrls = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listUrls = new javax.swing.JList<>();
        edtUrl = new javax.swing.JTextField();
        txtUrl = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jScrollPane2.setViewportView(listUrls);
        listUrls.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()){
                    edtUrl.setText(listUrls.getSelectedValue());
                }
            }
        });

        txtUrl.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtUrl.setText("Url:");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnAdd.setForeground(new java.awt.Color(41, 126, 183));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add_Row_32px.png")));
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });


        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEdit.setForeground(new java.awt.Color(41, 126, 183));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit_Row_32px.png")));
        btnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnRemove.setForeground(new java.awt.Color(41, 126, 183));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_Row_32px.png")));
        btnRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        btnSelect.setText("Select");
        btnSelect.setBorder(null);
        btnSelect.setBorderPainted(false);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSelectUrlsLayout = new javax.swing.GroupLayout(panelSelectUrls);
        panelSelectUrls.setLayout(panelSelectUrlsLayout);
        panelSelectUrlsLayout.setHorizontalGroup(
                panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                .addGroup(panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                                                .addComponent(txtUrl)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                                                                .addComponent(btnAdd)
                                                                                .addGap(75, 75, 75)
                                                                                .addComponent(btnEdit)
                                                                                .addGap(89, 89, 89)
                                                                                .addComponent(btnRemove))
                                                                        .addComponent(edtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                                .addGap(128, 128, 128)
                                                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelSelectUrlsLayout.setVerticalGroup(
                panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSelectUrlsLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUrl))
                                .addGap(28, 28, 28)
                                .addGroup(panelSelectUrlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEdit)
                                        .addComponent(btnAdd)
                                        .addComponent(btnRemove))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelSelectUrls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSelectUrls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

        readText = Generic.readTextFile(GlobalConstants.DomExtractor_Extractor_url_file);
        if(isElementExistinList(edtUrl.getText())){
            JOptionPane.showMessageDialog(null, "Already Exists", "Warning" , JOptionPane.WARNING_MESSAGE);
        } else {
            Generic.writeText(edtUrl.getText(),GlobalConstants.DomExtractor_Extractor_url_file,true);
            JOptionPane.showMessageDialog(null, "Done", "Done" , JOptionPane.INFORMATION_MESSAGE);
            listModel.addElement(edtUrl.getText());
            listUrls.setModel(listModel);
        }
        listUrls.setSelectedValue(edtUrl.getText(),false);

    }

    public boolean isElementExistinList(String addElement){
        boolean flag=false;
        System.out.println("readText::"+readText.size());
        for(int i=0;i<=readText.size()-1;i++){
            System.out.println(addElement+"::"+readText.get(i).toString());
            if(addElement.equalsIgnoreCase(readText.get(i).toString())){
                flag=true;
                break;
            }
        }
        System.out.println("flag::"+flag);
        return flag;
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        String edtVal= listUrls.getSelectedValue().toString();
        listModel.removeElement(listUrls.getSelectedValue());
        Generic.writeText(listUrls.getModel().getElementAt(0).toString(),GlobalConstants.DomExtractor_Extractor_url_file,false);
        for(int i = 1; i< listUrls.getModel().getSize();i++){
            Generic.writeText(listUrls.getModel().getElementAt(i).toString(),GlobalConstants.DomExtractor_Extractor_url_file,true);
        }

        JOptionPane.showMessageDialog(null, "Done", "Done" , JOptionPane.INFORMATION_MESSAGE);
        edtUrl.setText("");
        edtUrl.setText(edtVal);
    }
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        listModel.removeElement(listUrls.getSelectedValue());
        Generic.writeText(listUrls.getModel().getElementAt(0).toString(),GlobalConstants.DomExtractor_Extractor_url_file,false);
        for(int i = 1; i< listUrls.getModel().getSize();i++){
            Generic.writeText(listUrls.getModel().getElementAt(i).toString(),GlobalConstants.DomExtractor_Extractor_url_file,true);
        }

        JOptionPane.showMessageDialog(null, "Done", "Done" , JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectUrls().setVisible(true);
            }
        });
    }

    public void btnSelectActionPerformed(java.awt.event.ActionEvent evt){
        GlobalConstants.selected_URL = listUrls.getSelectedValue().toString();

        setVisible(false);
        dispose();
        SmartExtractor.edtFormat.setText(GlobalConstants.selected_URL);
        SmartExtractor.btnSelectFolder.setEnabled(true);
    }
    public void getUrls(){
        try {
            listModel.removeAllElements();
            File file = new File(GlobalConstants.DomExtractor_Extractor_url_file);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {

                listModel.addElement(st);
            }
            //listModel.addElement(st);

            listUrls.setModel(listModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSelect;
    private javax.swing.JTextField edtUrl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listUrls;
    private javax.swing.JPanel panelSelectUrls;
    private javax.swing.JLabel txtUrl;
    // End of variables declaration
}
