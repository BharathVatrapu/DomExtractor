package com.mainProject.frames;


/**
 *
 * @author BhaRatH
 */
public class ViewFiles extends javax.swing.JPanel {

    /**
     * Creates new form Extractor
     */
    public ViewFiles() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelViewFiles = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFiles = new javax.swing.JTable();
        btnOpen = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        panelViewFiles.setBackground(new java.awt.Color(204, 255, 255));
        panelViewFiles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        tblFiles.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(tblFiles);

        btnOpen.setFont(new java.awt.Font("Tahoma", 1, 13));
        btnOpen.setText("Open");

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 13));
        btnDelete.setText("Delete");

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


    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelViewFiles;
    private javax.swing.JTable tblFiles;
    // End of variables declaration
}
