package com.mainProject.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class DomExtractor {

    StringBuilder stringBuilder = new StringBuilder();
    Document document;
    List<String> listStrings = new ArrayList<String>();
    String innerxpath=null;
    String id = null;
    String text = null;
    String xpath=null;
    String findby=null;
    String cachelookup = "@CacheLookup";
    String webelement = null;


    String pageObjectmodel=null;
    String enumPropertiesmodel=null;
    String pageName;

    String all;
    String all_links;
    String all_buttons;
    String all_radiobuttons;
    String all_texts;
    String all_lists;
    String all_images;
    String all_checkboxes;
    String all_edits;
    String all_comboboxes;
    String all_textarea;

    public void extractor(String format,String htmlComp,String pomType,ArrayList<String> objList){
        String fileName=null;
        try
        {
            if(objList.size()!=0) {
                if (format.equalsIgnoreCase("url")) {
                    document = Jsoup.connect(htmlComp).get();
                } else {
                    document = Jsoup.parse(new File(htmlComp), "utf-8");
                }
                Elements input_elements = document.getElementsByTag("input");
                for (int k = 0; k <= objList.size() - 1; k++) {
                    switch (objList.get(k)) {
                        case "Link":
                            getLinks(pomType);
                            break;
                        case "Button":
                            getButtons(pomType,input_elements);
                            break;
                        case "Check Box":
                            getCheckbox(pomType,input_elements);
                            break;
                        case "Edit Box":
                            getEdit(pomType,input_elements);
                            getTextArea(pomType);
                            break;
                        case "Image":
                            getImages(pomType);
                            break;
                        case "List":
                            //  getList(pomType);
                            break;
                        case "Radio Button":
                            getRadioButton(pomType,input_elements);
                            break;
                        case "Combo Box":
                            getCombobox(pomType);
                            break;
                        case "Text":
                            getText(pomType);
                            break;
                    }
                }


                if(!StringUtils.isEmpty(all_links)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_links+System.lineSeparator();
                    } else {
                        all = all_links+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_buttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_buttons+System.lineSeparator();
                    } else {
                        all = all_buttons+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_checkboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_checkboxes+System.lineSeparator();
                    } else {
                        all = all_checkboxes+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_edits)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_edits+System.lineSeparator();
                    } else {
                        all = all_edits+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_textarea)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_textarea+System.lineSeparator();
                    } else {
                        all = all_textarea+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_images)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_images+System.lineSeparator();
                    } else {
                        all = all_images+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_lists)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_lists+System.lineSeparator();
                    } else {
                        all = all_lists+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_radiobuttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_radiobuttons+System.lineSeparator();
                    } else {
                        all = all_radiobuttons+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_comboboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_comboboxes+System.lineSeparator();
                    } else {
                        all = all_comboboxes+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_texts)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_texts+System.lineSeparator();
                    } else {
                        all = all_texts+System.lineSeparator();
                    }
                }


                if(StringUtils.isEmpty(pageName)){
                    fileName = "DomExtractor_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
                } else {
                    fileName = pageName+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
                }

                if(!StringUtils.isEmpty(all)) {
                    if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName)) {
                        Generic.writeText(all, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName, false);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Objects not found", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
                }
                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName);
                pb.start();
            } else{
                JOptionPane.showMessageDialog(null, "Select atleast one Object control", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void smartExtractor(String htmlContent, String pomType, WebDriver driver, ArrayList<String> objList){
        String fileName=null;
        try
        {
            if(objList.size()!=0) {
                document = Jsoup.parse(htmlContent);
                if (driver != null) {
                    System.out.println("driver title" + driver.getTitle());
                    pageName = Generic.removeSpecialChars(driver.getTitle());
                }
                Elements input_elements = document.getElementsByTag("input");
                for (int k = 0; k <= objList.size() - 1; k++) {
                    switch (objList.get(k)) {
                        case "Link":
                            getLinks(pomType);
                            break;
                        case "Button":
                            getButtons(pomType,input_elements);
                            break;
                        case "Check Box":
                            getCheckbox(pomType,input_elements);
                            break;
                        case "Edit Box":
                            getEdit(pomType,input_elements);
                            getTextArea(pomType);
                            break;
                        case "Image":
                            getImages(pomType);
                            break;
                        case "List":
                          //  getList(pomType);
                            break;
                        case "Radio Button":
                            getRadioButton(pomType,input_elements);
                            break;
                        case "Combo Box":
                            getCombobox(pomType);
                            break;
                        case "Text":
                            getText(pomType);
                            break;
                    }
                }


                if(!StringUtils.isEmpty(all_links)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_links+System.lineSeparator();
                    } else {
                        all = all_links+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_buttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_buttons+System.lineSeparator();
                    } else {
                        all = all_buttons+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_checkboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_checkboxes+System.lineSeparator();
                    } else {
                        all = all_checkboxes+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_edits)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_edits+System.lineSeparator();
                    } else {
                        all = all_edits+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_textarea)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_textarea+System.lineSeparator();
                    } else {
                        all = all_textarea+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_images)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_images+System.lineSeparator();
                    } else {
                        all = all_images+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_lists)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_lists+System.lineSeparator();
                    } else {
                        all = all_lists+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_radiobuttons)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_radiobuttons+System.lineSeparator();
                    } else {
                        all = all_radiobuttons+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_comboboxes)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_comboboxes+System.lineSeparator();
                    } else {
                        all = all_comboboxes+System.lineSeparator();
                    }
                }
                if(!StringUtils.isEmpty(all_texts)){
                    if(!StringUtils.isEmpty(all)){
                        all = all+all_texts+System.lineSeparator();
                    } else {
                        all = all_texts+System.lineSeparator();
                    }
                }


                if(StringUtils.isEmpty(pageName)){
                    fileName = "DomExtractor_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
                } else {
                    fileName = pageName+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".java";
                }

                if(!StringUtils.isEmpty(all)) {
                    if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName)) {
                        Generic.writeText(all, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName, false);
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Objects not found", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
                }
                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + fileName);
                pb.start();
            } else{
                JOptionPane.showMessageDialog(null, "Select atleast one Object control", "Warning.. " , JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //###############################################################################################
    //###############################################################################################




    //###############################################################################################
    //###############################################################################################

    public void getLinks(String pomType){
        listStrings.clear();
        innerxpath=null;
        all_links=null;
        stringBuilder.delete(0, stringBuilder.length());
        //     Link
        // Elements links = document.select("a[href]");
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            if (!StringUtils.isEmpty(link.text())) {
                id = link.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = link.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = link.text();
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//a/" + innerxpath + "[text()=" + text + "]";
                    } else {
                        xpath = "//a[text()=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(link.text());
                webelement = "public WebElement lnk" + text + ";";

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".Link = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".Link = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        all_links = stringBuilder.toString();
    }

    public void getButtons(String pomType,Elements input_buttons){
        listStrings.clear();
        innerxpath=null;
        stringBuilder.delete(0, stringBuilder.length());

        Elements buttons = document.getElementsByTag("button");
        for (Element button : buttons) {
            if (!StringUtils.isEmpty(button.text())) {
                id = button.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = button.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = button.text();
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//button/" + innerxpath + "[text()=" + text + "]";
                    } else {
                        xpath = "//button[text()=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(button.text());
                webelement = "public WebElement btn" + text + ";";

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".Button = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".Button = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".Button = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".Button = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        //Elements input_buttons = document.getElementsByTag("input");
        for (Element input_button : input_buttons) {
            if (input_button.attr("type").equalsIgnoreCase("submit")) {
                id = input_button.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_button.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_button.attr("value");
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@value=" + text + "]";
                    } else {
                        xpath = "//input[@value=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(input_button.attr("value"));
                webelement = "public WebElement btn" + text + ";";

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".Button = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".Button = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".Button = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".Button = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        all_buttons = stringBuilder.toString();
    }


    public void getCheckbox(String pomType,Elements input_Checkboxes){
        listStrings.clear();
        innerxpath=null;
        all_checkboxes=null;
        stringBuilder.delete(0, stringBuilder.length());

        for (Element input_checkbox : input_Checkboxes) {
            if (input_checkbox.attr("type").equalsIgnoreCase("checkbox")) {
                id = input_checkbox.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_checkbox.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_checkbox.attr("name");
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@name=" + text + "]";
                    } else {
                        xpath = "//input[@name=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(input_checkbox.attr("id"));
                webelement = "public WebElement chkbox" + text + ";";

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".CheckBox = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".CheckBox = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".CheckBox = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".CheckBox = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        all_checkboxes = stringBuilder.toString();

    }
    public String firstFive(String str) {
        return str.length() < 5 ? str : str.substring(0, 5);
    }
    public void getEdit(String pomType,Elements input_Edits){
        listStrings.clear();
        innerxpath=null;
        all_edits=null;
        stringBuilder.delete(0, stringBuilder.length());

        for (Element input_edit : input_Edits) {
            if (input_edit.attr("type").equalsIgnoreCase("input")||input_edit.attr("type").equalsIgnoreCase("text")||input_edit.attr("type").equalsIgnoreCase("password")||input_edit.attr("type").equalsIgnoreCase("email")||input_edit.attr("type").equalsIgnoreCase("number")||input_edit.attr("type").equalsIgnoreCase("search")||input_edit.attr("type").equalsIgnoreCase("url")||input_edit.attr("type").equalsIgnoreCase("tel")) {
                id = input_edit.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_edit.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_edit.attr("name");
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@name=" + text + "]";
                    } else {
                        xpath = "//input[@name=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(input_edit.attr("id"));
                if(firstFive(text).equalsIgnoreCase("input")){
                    webelement = "public WebElement " + text + ";";
                } else{
                    webelement = "public WebElement input" + text + ";";
                }

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".EditBox = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".EditBox = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".EditBox = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".EditBox = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        all_edits = stringBuilder.toString();

    }

    public void getImages(String pomType){
        listStrings.clear();
        innerxpath=null;
        all_images=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements images = document.getElementsByTag("img");
        for (Element img : images) {

                id = img.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = img.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = img.attr("alt");
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//img/" + innerxpath + "[@alt=" + text + "]";
                    } else {
                        xpath = "//img[@alt=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(img.attr("alt"));
                webelement = "public WebElement img" + text + ";";

                if(pomType.equalsIgnoreCase("pom")){
                    if (findby != null) {
                        pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if(pomType.equalsIgnoreCase("property")){
                    if(StringUtils.isEmpty(pageName)){
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".Img = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".Img = " + id + "@@@id";
                        }
                    } else{
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".Img = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".Img = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();

        }
        all_images = stringBuilder.toString();
    }

    public void getCombobox(String pomType){
        listStrings.clear();
        innerxpath=null;
        all_comboboxes=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements comboboxes = document.getElementsByTag("select");
        for (Element cmbox : comboboxes) {

            id = cmbox.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = cmbox.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = cmbox.attr("name");
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//select/" + innerxpath + "[@name=" + text + "]";
                } else {
                    xpath = "//select[@name=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(cmbox.attr("id"));
            webelement = "public WebElement cmbox" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".ComboBox = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".ComboBox = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".ComboBox = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".ComboBox = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_comboboxes = stringBuilder.toString();
    }
    public void getTextArea(String pomType){
        listStrings.clear();
        innerxpath=null;
        all_textarea=null;
        stringBuilder.delete(0, stringBuilder.length());
        Elements textAreas = document.getElementsByTag("textarea");
        for (Element textarea : textAreas) {

            id = textarea.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = textarea.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = textarea.attr("name");
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//textarea/" + innerxpath + "[@name=" + text + "]";
                } else {
                    xpath = "//textarea[@name=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(textarea.attr("id"));
            webelement = "public WebElement textarea" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Edit = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Edit = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Edit = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Edit = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_textarea = stringBuilder.toString();
    }
    public void getRadioButton(String pomType,Elements input_radios){
        listStrings.clear();
        innerxpath=null;
        all_radiobuttons=null;
        stringBuilder.delete(0, stringBuilder.length());
        for (Element input_radio : input_radios) {
            if (input_radio.attr("type").equalsIgnoreCase("radio")) {
                id = input_radio.attr("id");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(id=" + id + ")";
                } else {
                    String linkInnerH = input_radio.html();
                    if (linkInnerH.contains("<")) {
                        Document innerdoc = Jsoup.parse(linkInnerH);
                        Elements innerelements = innerdoc.getAllElements();
                        for (Element innerele : innerelements) {
                            listStrings.add(innerele.tag().getName());
                        }
                        innerxpath = listStrings.get(4);
                        for (int i = 5; i <= listStrings.size() - 1; i++) {
                            innerxpath = innerxpath + "/" + listStrings.get(i);
                        }
                        listStrings.clear();

                    }
                    text = input_radio.attr("name");
                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@name=" + text + "]";
                    } else {
                        xpath = "//input[@name=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(xpath = " + xpath + ")";
                }
                text = Generic.removeSpecialChars(input_radio.attr("id"));
                webelement = "public WebElement radio" + text + ";";

                if (pomType.equalsIgnoreCase("pom")) {
                    if (findby != null) {
                        pageObjectmodel = cachelookup + System.lineSeparator() + findby + System.lineSeparator() + webelement + System.lineSeparator();
                    }
                    stringBuilder.append(pageObjectmodel);
                    stringBuilder.append(System.lineSeparator());
                } else if (pomType.equalsIgnoreCase("property")) {
                    if (StringUtils.isEmpty(pageName)) {
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = "Page." + text + ".RadioButton = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = "Page." + text + ".RadioButton = " + id + "@@@id";
                        }
                    } else {
                        if (StringUtils.isEmpty(id)) {
                            enumPropertiesmodel = pageName + "Page." + text + ".RadioButton = " + xpath + "@@@xpath";
                        } else {
                            enumPropertiesmodel = pageName + "Page." + text + ".RadioButton = " + id + "@@@id";
                        }
                    }
                    stringBuilder.append(enumPropertiesmodel);
                    stringBuilder.append(System.lineSeparator());
                }
                nullvars();
            }
        }
        all_radiobuttons = stringBuilder.toString();
    }

    public void getText(String pomType){
        all_texts = null;
        stringBuilder.delete(0, stringBuilder.length());
        geth1(pomType);
        geth2(pomType);
        geth3(pomType);
        geth4(pomType);
        geth5(pomType);
        geth6(pomType);
        getp(pomType);
        getsmall(pomType);
    }

    public void geth1(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h1s = document.getElementsByTag("h1");
        for (Element h1 : text_h1s) {
            id = h1.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h1.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h1.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h1/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h1[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h1.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
       all_texts = stringBuilder.toString();
    }

    public void geth2(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h2s = document.getElementsByTag("h2");
        for (Element h2 : text_h2s) {
            id = h2.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h2.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h2.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h2/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h2[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h2.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth3(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h3s = document.getElementsByTag("h3");
        for (Element h3 : text_h3s) {
            id = h3.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h3.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h3.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h3/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h3[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h3.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth4(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h4s = document.getElementsByTag("h4");
        for (Element h4 : text_h4s) {
            id = h4.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h4.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h4.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h4/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h4[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h4.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void geth5(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h5s = document.getElementsByTag("h5");
        for (Element h5 : text_h5s) {
            id = h5.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h5.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h5.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h5/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h5[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h5.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void geth6(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h6s = document.getElementsByTag("h6");
        for (Element h6 : text_h6s) {
            id = h6.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = h6.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = h6.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//h6/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//h6[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(h6.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void getsmall(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_smalls = document.getElementsByTag("small");
        for (Element small : text_smalls) {
            id = small.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = small.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = small.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//small/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//small[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(small.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }
    public void getp(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements textps = document.getElementsByTag("p");
        for (Element p : textps) {
            id = p.attr("id");
            if (!StringUtils.isEmpty(id)) {
                id = "\"" + id + "\"";
                findby = "@FindBy(id=" + id + ")";
            } else {
                String linkInnerH = p.html();
                if (linkInnerH.contains("<")) {
                    Document innerdoc = Jsoup.parse(linkInnerH);
                    Elements innerelements = innerdoc.getAllElements();
                    for (Element innerele : innerelements) {
                        listStrings.add(innerele.tag().getName());
                    }
                    innerxpath = listStrings.get(4);
                    for (int i = 5; i <= listStrings.size() - 1; i++) {
                        innerxpath = innerxpath + "/" + listStrings.get(i);
                    }
                    listStrings.clear();

                }
                text = p.text();
                text = "\\\"" + text + "\\\"";
                if (innerxpath != null) {
                    xpath = "//p/" + innerxpath + "[text()=" + text + "]";
                } else {
                    xpath = "//p[text()=" + text + "]";
                }
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(xpath = " + xpath + ")";
            }
            text = Generic.removeSpecialChars(p.text());
            webelement = "public WebElement txt" + text + ";";

            if(pomType.equalsIgnoreCase("pom")){
                if (findby != null) {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                stringBuilder.append(pageObjectmodel);
                stringBuilder.append(System.lineSeparator());
            } else if(pomType.equalsIgnoreCase("property")){
                if(StringUtils.isEmpty(pageName)){
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = "Page." + text + ".Text = " + id + "@@@id";
                    }
                } else{
                    if (StringUtils.isEmpty(id)) {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + xpath + "@@@xpath";
                    } else {
                        enumPropertiesmodel = pageName + "Page." + text + ".Text = " + id + "@@@id";
                    }
                }
                stringBuilder.append(enumPropertiesmodel);
                stringBuilder.append(System.lineSeparator());
            }
            nullvars();

        }
        all_texts = stringBuilder.toString();
    }

    public void nullvars(){
        findby = null;
        webelement = null;
        innerxpath = null;
        text=null;
        xpath=null;
        id=null;
        enumPropertiesmodel=null;
        pageObjectmodel=null;
    }



}
