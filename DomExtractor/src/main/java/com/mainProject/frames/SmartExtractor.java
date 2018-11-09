package com.mainProject.frames;

import com.mainProject.utils.DomExtractor;
import com.mainProject.utils.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author BhaRatH
 */
public class SmartExtractor extends javax.swing.JPanel {

    public static WebDriver driver;

    /**
     * Creates new form Extractor
     */
    public SmartExtractor() {
        initComponents();
        btnStop.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelExtractor = new javax.swing.JPanel();
        edtFormat = new javax.swing.JTextField();
        btnSelectFolder = new javax.swing.JButton();
        txtCodeType = new javax.swing.JLabel();
        cmCodeType = new javax.swing.JComboBox<>();
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
        btnGenerate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtCodeType1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnPlay = new javax.swing.JButton();
        txtPastehere = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();

        panelExtractor.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        panelExtractor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        btnSelectFolder.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        btnSelectFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Hand_Left_20px.png")));
        btnSelectFolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSelectFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFolderActionPerformed(evt);
            }
        });

        txtCodeType.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtCodeType.setText("Code Type: ");

        cmCodeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pom", "property" }));

        panelObjects.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        panelObjects.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Object Controls", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));

        cbLink.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbLink.setText("Link");

        cbButton.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbButton.setText("Button");

        cbList.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbList.setText("List");

        cbEditBox.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbEditBox.setText("Edit Box");

        cbComboBox.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbComboBox.setText("Combo Box");

        cbRadioButton.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbRadioButton.setText("Radio Button");

        cbCheckBox.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbCheckBox.setText("Check Box");

        cbText.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbText.setText("Text");

        cbImage.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        cbImage.setText("Image");
        cbImage.setToolTipText("");

        javax.swing.GroupLayout panelObjectsLayout = new javax.swing.GroupLayout(panelObjects);
        panelObjects.setLayout(panelObjectsLayout);
        panelObjectsLayout.setHorizontalGroup(
                panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbLink)
                                                        .addComponent(cbButton))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                                .addGroup(panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbEditBox)
                                                        .addComponent(cbRadioButton)
                                                        .addComponent(cbList)
                                                        .addComponent(cbComboBox)
                                                        .addComponent(cbCheckBox)
                                                        .addComponent(cbText)
                                                        .addComponent(cbImage))
                                                .addGap(0, 18, Short.MAX_VALUE))))
        );
        panelObjectsLayout.setVerticalGroup(
                panelObjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelObjectsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbLink)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbEditBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbComboBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbImage)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerate.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Services_32px.png")));
        btnGenerate.setText("Genarate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Broom_32px.png")));
        btnClear.setText("Clear");

        txtCodeType1.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtCodeType1.setText("Url: ");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane3.setViewportView(txtArea);

        btnPlay.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        btnPlay.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnPlay.setForeground(new java.awt.Color(0, 204, 0));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Play_32px.png")));
        btnPlay.setText("Play");
        btnPlay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        txtPastehere.setText("paste here: HTML code");

        btnStop.setBackground(new java.awt.Color(GlobalConstants.body_Color_r,GlobalConstants.body_Color_g,GlobalConstants.body_Color_b));
        btnStop.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnStop.setForeground(new java.awt.Color(204, 0, 51));
        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Stop_32px.png")));
        btnStop.setText("Stop");
        btnStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelExtractorLayout = new javax.swing.GroupLayout(panelExtractor);
        panelExtractor.setLayout(panelExtractorLayout);
        panelExtractorLayout.setHorizontalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExtractorLayout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addComponent(txtCodeType)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmCodeType, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                        .addGap(231, 231, 231)
                                                                        .addComponent(txtPastehere)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addGap(84, 84, 84)
                                                                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(31, 31, 31)
                                                .addComponent(panelObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addComponent(txtCodeType1)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                                .addComponent(edtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnSelectFolder)))))
                                .addGap(36, 36, 36))
        );
        panelExtractorLayout.setVerticalGroup(
                panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(edtFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCodeType1))
                                        .addComponent(btnSelectFolder))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCodeType)
                                        .addComponent(cmCodeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelExtractorLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPastehere)
                                                .addGap(3, 3, 3)
                                                .addComponent(jScrollPane3)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelExtractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnGenerate)
                                                        .addComponent(btnClear))
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExtractorLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                                .addComponent(panelObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62))))
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

    public void btnSelectFolderActionPerformed(java.awt.event.ActionEvent evt){
        new SelectUrls().setVisible(true);
        btnSelectFolder.setEnabled(false);
    }
    public void btnPlayActionPerformed(java.awt.event.ActionEvent evt){
        try {
            btnPlay.setEnabled(false);
            btnStop.setEnabled(true);
            System.out.println("browser:" + GlobalConstants.SETTINGS_DEFAULT_BROWSER);
            switch (GlobalConstants.SETTINGS_DEFAULT_BROWSER) {
                case "Chrome":
                    System.setProperty(
                            "webdriver.chrome.driver", GlobalConstants.SETTINGS_DRIVER_FOLDER_PATH + File.separator + "chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.navigate().to(edtFormat.getText());
                    driver.manage().window().maximize();
                    Thread.sleep(5000);
                    String openDevTools = Keys.chord(Keys.CONTROL, Keys.SHIFT, "i");
                    driver.findElement(By.tagName("body")).sendKeys(openDevTools);
                    break;
                case "Firefox":
                    System.setProperty(
                            "webdriver.gecko.driver", GlobalConstants.SETTINGS_DRIVER_FOLDER_PATH + File.separator + "geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.navigate().to(edtFormat.getText());
                    driver.manage().window().maximize();
                    break;
                case "IE11":
                    System.setProperty(
                            "webdriver.ie.driver", GlobalConstants.SETTINGS_DRIVER_FOLDER_PATH + File.separator + "IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    driver.navigate().to(edtFormat.getText());
                    driver.manage().window().maximize();
                    break;
                case "Edge":
                    System.setProperty(
                            "webdriver.edge.driver",
                            GlobalConstants.SETTINGS_DRIVER_FOLDER_PATH + File.separator + "MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    driver.navigate().to(edtFormat.getText());
                    driver.manage().window().maximize();
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }
    public void btnStopActionPerformed(java.awt.event.ActionEvent evt){

        driver.quit();
        btnPlay.setEnabled(true);
        btnStop.setEnabled(false);
    }

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {
        String format=null;
        ArrayList<String> objList=new ArrayList<String>();

//        if(rbPath.isSelected()){
//            format = rbPath.getText().toLowerCase();
//        } else{
//            format = rbUrl.getText().toLowerCase();
//        }

        if(cbLink.isSelected()){
            objList.add(cbLink.getText());
        }
        if(cbButton.isSelected()){
            objList.add(cbButton.getText());
        }
        if(cbCheckBox.isSelected()){
            objList.add(cbCheckBox.getText());
        }
        if(cbEditBox.isSelected()){
            objList.add(cbEditBox.getText());
        }
        if(cbImage.isSelected()){
            objList.add(cbImage.getText());
        }
        if(cbList.isSelected()){
            objList.add(cbList.getText());
        }
        if(cbRadioButton.isSelected()){
            objList.add(cbRadioButton.getText());
        }
        if(cbText.isSelected()){
            objList.add(cbText.getText());
        }
        if(cbComboBox.isSelected()){
            objList.add(cbComboBox.getText());
        }

        for(int j=0; j<=objList.size()-1;j++){
            System.out.println(objList.get(j));
        }

        DomExtractor domExtractor=new DomExtractor();
        domExtractor.smartExtractor(txtArea.getText(),cmCodeType.getSelectedItem().toString(),driver,objList);
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnPlay;
    public static javax.swing.JButton btnSelectFolder;
    private javax.swing.JButton btnStop;
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
    public static javax.swing.JTextField edtFormat;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JPanel panelExtractor;
    private javax.swing.JPanel panelObjects;
    private javax.swing.JLabel txtCodeType;
    private javax.swing.JLabel txtCodeType1;
    private javax.swing.JLabel txtPastehere;
    // End of variables declaration
}
