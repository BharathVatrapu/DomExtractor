package com.mainProject.frames;


import javax.swing.*;

/**
 *
 * @author BhaRatH
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Extractor
     */
    public Home() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelExtractor = new javax.swing.JPanel();
        imgHome = new javax.swing.JLabel();


        panelExtractor.setBackground(new java.awt.Color(204, 255, 255));
        panelExtractor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        imgHome.setIcon(new ImageIcon(getClass().getResource("/img/DomExtractor_Home.gif")));
        javax.swing.GroupLayout panelExtractorLayout = new javax.swing.GroupLayout(panelExtractor);
        panelExtractor.setLayout(panelExtractorLayout);
        panelExtractorLayout.setHorizontalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imgHome, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
        panelExtractorLayout.setVerticalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imgHome, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelExtractor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelExtractor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel imgHome;
    private javax.swing.JPanel panelExtractor;
    // End of variables declaration
}

