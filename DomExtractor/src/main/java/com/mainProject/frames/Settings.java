package com.mainProject.frames;


/**
 *
 * @author BhaRatH
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Extractor
     */
    public Settings() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelExtractor = new javax.swing.JPanel();
        panelImage = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        txtFolderPath = new javax.swing.JLabel();
        edtSelectFolder = new javax.swing.JTextField();
        btnFolderSelect = new javax.swing.JButton();
        txtBrowserdriverPath = new javax.swing.JLabel();
        edtDriverPath = new javax.swing.JTextField();
        btnSelectDriversFolder = new javax.swing.JButton();
        txtDefaultBrowser = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        rbChrome = new javax.swing.JRadioButton();
        imgChrome = new javax.swing.JLabel();
        imgFirefox = new javax.swing.JLabel();
        rbFirefox = new javax.swing.JRadioButton();
        imgIE11 = new javax.swing.JLabel();
        rbIE11 = new javax.swing.JRadioButton();
        imgEdge = new javax.swing.JLabel();
        rbEdge = new javax.swing.JRadioButton();

        panelExtractor.setBackground(new java.awt.Color(204, 255, 255));
        panelExtractor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
                panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        panelImageLayout.setVerticalGroup(
                panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        txtFolderPath.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtFolderPath.setText("Set Folder Path:");

        btnFolderSelect.setBackground(new java.awt.Color(204, 255, 255));
        btnFolderSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Opened_Folder_20px.png")));
        btnFolderSelect.setBorder(null);
        btnFolderSelect.setBorderPainted(false);

        txtBrowserdriverPath.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtBrowserdriverPath.setText("Browser drivers Path:");

        btnSelectDriversFolder.setBackground(new java.awt.Color(204, 255, 255));
        btnSelectDriversFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Opened_Folder_20px.png")));
        btnSelectDriversFolder.setBorder(null);
        btnSelectDriversFolder.setBorderPainted(false);

        txtDefaultBrowser.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtDefaultBrowser.setText("Select default Browser:");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13));
        btnSave.setForeground(new java.awt.Color(51, 152, 219));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Save_32px.png")));
        btnSave.setText("Save");

        rbChrome.setBackground(new java.awt.Color(204, 255, 255));
        rbChrome.setText("Chrome");

        imgChrome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Chrome_30px.png")));

        imgFirefox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Firefox_30px.png")));

        rbFirefox.setBackground(new java.awt.Color(204, 255, 255));
        rbFirefox.setText("Firefox");

        imgIE11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Internet_Explorer_30px.png")));

        rbIE11.setBackground(new java.awt.Color(204, 255, 255));
        rbIE11.setText("IE11");

        imgEdge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Microsoft_Edge_30px.png")));

        rbEdge.setBackground(new java.awt.Color(204, 255, 255));
        rbEdge.setText("Edge");

        javax.swing.GroupLayout panelExtractorLayout = new javax.swing.GroupLayout(panelExtractor);
        panelExtractor.setLayout(panelExtractorLayout);
        panelExtractorLayout.setHorizontalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addComponent(txtFolderPath)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(edtSelectFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnFolderSelect))
                                                        .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addComponent(txtBrowserdriverPath)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(edtDriverPath, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnSelectDriversFolder))
                                                        .addComponent(txtDefaultBrowser)))
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(imgChrome)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbChrome)
                                                .addGap(18, 18, 18)
                                                .addComponent(imgFirefox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbFirefox)
                                                .addGap(18, 18, 18)
                                                .addComponent(imgIE11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbIE11)
                                                .addGap(18, 18, 18)
                                                .addComponent(imgEdge)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbEdge)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelExtractorLayout.setVerticalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFolderPath)
                                        .addComponent(edtSelectFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFolderSelect))
                                .addGap(27, 27, 27)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtBrowserdriverPath)
                                        .addComponent(edtDriverPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSelectDriversFolder))
                                .addGap(32, 32, 32)
                                .addComponent(txtDefaultBrowser)
                                .addGap(18, 18, 18)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rbChrome)
                                        .addComponent(imgChrome)
                                        .addComponent(rbFirefox)
                                        .addComponent(imgFirefox)
                                        .addComponent(rbIE11)
                                        .addComponent(imgIE11)
                                        .addComponent(rbEdge)
                                        .addComponent(imgEdge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
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
    private javax.swing.JButton btnFolderSelect;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSelectDriversFolder;
    private javax.swing.JTextField edtDriverPath;
    private javax.swing.JTextField edtSelectFolder;
    private javax.swing.JLabel imgChrome;
    private javax.swing.JLabel imgEdge;
    private javax.swing.JLabel imgFirefox;
    private javax.swing.JLabel imgIE11;
    private javax.swing.JLabel lbImage;
    private javax.swing.JPanel panelExtractor;
    private javax.swing.JPanel panelImage;
    private javax.swing.JRadioButton rbChrome;
    private javax.swing.JRadioButton rbEdge;
    private javax.swing.JRadioButton rbFirefox;
    private javax.swing.JRadioButton rbIE11;
    private javax.swing.JLabel txtBrowserdriverPath;
    private javax.swing.JLabel txtDefaultBrowser;
    private javax.swing.JLabel txtFolderPath;
    // End of variables declaration
}
