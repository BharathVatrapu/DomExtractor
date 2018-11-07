package com.mainProject.frames;

/**
 *
 * @author BhaRatH
 */
public class Extractor extends javax.swing.JPanel {

    /**
     * Creates new form Extractor
     */
    public Extractor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelExtractor = new javax.swing.JPanel();
        txtFormat = new javax.swing.JLabel();
        rbUrl = new javax.swing.JRadioButton();
        rbPath = new javax.swing.JRadioButton();
        edtFormat = new javax.swing.JTextField();
        btnSelectFolder = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtCodeType = new javax.swing.JLabel();
        cmCodeType = new javax.swing.JComboBox<>();
        txtExample = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaExample = new javax.swing.JTextArea();
        panelObjects = new javax.swing.JPanel();
        cbLink = new javax.swing.JCheckBox();
        cbButton = new javax.swing.JCheckBox();
        cbList = new javax.swing.JCheckBox();
        cbEditBox = new javax.swing.JCheckBox();
        cbComboBox = new javax.swing.JCheckBox();
        cbRadioButton = new javax.swing.JCheckBox();
        cbCheckBox = new javax.swing.JCheckBox();
        cbText = new javax.swing.JCheckBox();
        cbImage = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFormat = new javax.swing.JList<>();
        btnGenerate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        panelExtractor.setBackground(new java.awt.Color(204, 255, 255));
        panelExtractor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        txtFormat.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtFormat.setText("Format: ");

        rbUrl.setBackground(new java.awt.Color(204, 255, 255));
        rbUrl.setText("Url");

        rbPath.setBackground(new java.awt.Color(204, 255, 255));
        rbPath.setText("Path");

        btnSelectFolder.setBackground(new java.awt.Color(204, 255, 255));
        btnSelectFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Opened_Folder_20px.png")));
        btnSelectFolder.setBorder(null);
        btnSelectFolder.setBorderPainted(false);

        btnAdd.setBackground(new java.awt.Color(204, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnAdd.setForeground(new java.awt.Color(41, 126, 183));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add_Row_32px.png")));
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);

        txtCodeType.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtCodeType.setText("Code Type: ");

        cmCodeType.setBackground(new java.awt.Color(204, 255, 255));
        cmCodeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pom", "property" }));

        txtExample.setText("Ex.");

        txtAreaExample.setBackground(new java.awt.Color(204, 255, 255));
        txtAreaExample.setColumns(20);
        txtAreaExample.setRows(5);
        jScrollPane1.setViewportView(txtAreaExample);

        panelObjects.setBackground(new java.awt.Color(204, 255, 255));
        panelObjects.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Object Controls", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));

        cbLink.setBackground(new java.awt.Color(204, 255, 255));
        cbLink.setText("Link");

        cbButton.setBackground(new java.awt.Color(204, 255, 255));
        cbButton.setText("Button");

        cbList.setBackground(new java.awt.Color(204, 255, 255));
        cbList.setText("List");

        cbEditBox.setBackground(new java.awt.Color(204, 255, 255));
        cbEditBox.setText("Edit Box");

        cbComboBox.setBackground(new java.awt.Color(204, 255, 255));
        cbComboBox.setText("Combo Box");

        cbRadioButton.setBackground(new java.awt.Color(204, 255, 255));
        cbRadioButton.setText("Radio Button");

        cbCheckBox.setBackground(new java.awt.Color(204, 255, 255));
        cbCheckBox.setText("Check Box");

        cbText.setBackground(new java.awt.Color(204, 255, 255));
        cbText.setText("Text");

        cbImage.setBackground(new java.awt.Color(204, 255, 255));
        cbImage.setText("Image");
        cbImage.setToolTipText("");

        javax.swing.GroupLayout panelObjectsLayout = new javax.swing.GroupLayout(panelObjects);
        panelObjects.setLayout(panelObjectsLayout);
        panelObjectsLayout.setHorizontalGroup(
                panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbLink)
                                        .addComponent(cbEditBox)
                                        .addComponent(cbComboBox))
                                .addGap(46, 46, 46)
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                                .addComponent(cbButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbList)
                                                .addGap(23, 23, 23))
                                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                                .addComponent(cbRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbText)
                                                .addGap(17, 17, 17))
                                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                                .addComponent(cbCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbImage)
                                                .addContainerGap())))
        );
        panelObjectsLayout.setVerticalGroup(
                panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbLink)
                                        .addComponent(cbButton)
                                        .addComponent(cbList))
                                .addGap(18, 18, 18)
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbEditBox)
                                        .addComponent(cbRadioButton)
                                        .addComponent(cbText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbComboBox)
                                        .addComponent(cbCheckBox)
                                        .addComponent(cbImage))
                                .addContainerGap())
        );

        listFormat.setBackground(new java.awt.Color(204, 255, 255));
        jScrollPane2.setViewportView(listFormat);

        btnGenerate.setBackground(new java.awt.Color(204, 255, 255));
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Services_32px.png")));
        btnGenerate.setText("Genarate");

        btnClear.setBackground(new java.awt.Color(204, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Broom_32px.png")));
        btnClear.setText("Clear");

        btnEdit.setBackground(new java.awt.Color(204, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnEdit.setForeground(new java.awt.Color(41, 126, 183));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit_Row_32px.png")));
        btnEdit.setBorder(null);
        btnEdit.setBorderPainted(false);

        btnRemove.setBackground(new java.awt.Color(204, 255, 255));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnRemove.setForeground(new java.awt.Color(41, 126, 183));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete_Row_32px.png")));
        btnRemove.setBorder(null);
        btnRemove.setBorderPainted(false);

        javax.swing.GroupLayout panelExtractorLayout = new javax.swing.GroupLayout(panelExtractor);
        panelExtractor.setLayout(panelExtractorLayout);
        panelExtractorLayout.setHorizontalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(edtFormat)
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtExample)
                                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                                .addComponent(txtFormat)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(rbUrl)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(rbPath))
                                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                                .addComponent(txtCodeType)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(cmCodeType, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSelectFolder))
                                        .addComponent(panelObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addGap(58, 58, 58)
                                                .addComponent(btnEdit)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnRemove))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
        );
        panelExtractorLayout.setVerticalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFormat)
                                                        .addComponent(rbUrl)
                                                        .addComponent(rbPath))
                                                .addGap(8, 8, 8)
                                                .addComponent(edtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnAdd)
                                        .addComponent(btnEdit)
                                        .addComponent(btnRemove)
                                        .addComponent(btnSelectFolder))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExtractorLayout.createSequentialGroup()
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtCodeType)
                                                        .addComponent(cmCodeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtExample)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(panelObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                                .addContainerGap())))
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSelectFolder;
    private javax.swing.JCheckBox cbButton;
    private javax.swing.JCheckBox cbCheckBox;
    private javax.swing.JCheckBox cbComboBox;
    private javax.swing.JCheckBox cbEditBox;
    private javax.swing.JCheckBox cbImage;
    private javax.swing.JCheckBox cbLink;
    private javax.swing.JCheckBox cbList;
    private javax.swing.JCheckBox cbRadioButton;
    private javax.swing.JCheckBox cbText;
    private javax.swing.JComboBox<String> cmCodeType;
    private javax.swing.JTextField edtFormat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listFormat;
    private javax.swing.JPanel panelExtractor;
    private javax.swing.JPanel panelObjects;
    private javax.swing.JRadioButton rbPath;
    private javax.swing.JRadioButton rbUrl;
    private javax.swing.JTextArea txtAreaExample;
    private javax.swing.JLabel txtCodeType;
    private javax.swing.JLabel txtExample;
    private javax.swing.JLabel txtFormat;
    // End of variables declaration
}

