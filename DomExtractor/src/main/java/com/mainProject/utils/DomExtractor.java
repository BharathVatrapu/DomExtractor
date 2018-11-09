package com.mainProject.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class DomExtractor {

    Document document;
    List<String> listStrings = new ArrayList<String>();
    String innerxpath=null;
    String id = null;
    String text = null;
    String xpath=null;
    String findby=null;
    String cachelookup;
    String webelement;

    String pageObjectmodel=null;
    String enumPropertiesmodel=null;
    String pageName;

    public void createAllObjectLocators(String format,String htmlComp,String pomType,ArrayList<String> objList){

        try
        {
            if(format == null) {
                document = Jsoup.parse(htmlComp);

            } else {
                if (format.equalsIgnoreCase("url")) {
                    document = Jsoup.connect(htmlComp).get();
                } else {
                    document = Jsoup.parse(new File(htmlComp), "utf-8");
                }
                pageName = document.title();
            }



            pageName = pageName.replaceAll("\\s+","");
            pageName = pageName.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^|]*", "");
            if(Generic.isFileExist(GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+pageName+".txt")) {
                Generic.fileEmpty(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt");
            }
            for (int k=0;k<= objList.size()-1;k++) {
                switch (objList.get(k)) {
                    case "Link":
                        getLinks(pomType);
                        break;
                    case "Button":
                        getButtons(pomType);
                        break;
                    case "CheckBox":
                        getCheckbox(pomType);
                        break;
                    case "Edit":
                    case "input -Edit":
                        getEdit(pomType);
                        break;

                    case "Image":
                        listStrings.clear();
                        innerxpath=null;
                        Elements imgs = document.getElementsByTag("img");
                        break;

                    case "List":
                        getList(pomType);
                        break;
                    case "RadioButton":
                        getRadioButton(pomType);
                        break;
                    case "input -Button":
                        getinputButton(pomType);
                        break;
                    case "Text":
                        listStrings.clear();
                        innerxpath=null;
                        Elements text_elements_h1 = document.getElementsByTag("h1");
                        Elements text_elements_h2 = document.getElementsByTag("h2");
                        Elements text_elements_h3 = document.getElementsByTag("h3");
                        Elements text_elements_h4 = document.getElementsByTag("h4");
                        Elements text_elements_h5 = document.getElementsByTag("h5");
                        Elements text_elements_h6 = document.getElementsByTag("h6");
                        Elements text_elements_p = document.getElementsByTag("p");
                        Elements text_elements_label = document.getElementsByTag("label");
                        break;
                }
            }


            File file  = new File(GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+pageName+".txt");
            String newfilePath = GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+pageName+"_"+Generic.getDateTime()+".java";
            //Generic.changeExtension(file,"java");
            File newFile = new File(newfilePath);
            file.renameTo(newFile);
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe",newfilePath);
            pb.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void smartExtractor(String htmlContent, String pomType, WebDriver driver, ArrayList<String> objList){

        try
        {

            document = Jsoup.parse(htmlContent);
            if(driver !=null) {
                System.out.println("driver title" + driver.getTitle());
                pageName = Generic.clearSpecialChars(driver.getTitle());
            }

            for (int k=0;k<= objList.size()-1;k++) {
                switch (objList.get(k)) {
                    case "Link":
                        getLinks(pomType);
                        break;
                    case "Button":
                        getButtons(pomType);
                        getinputButton(pomType);
                        break;
                    case "Check Box":
                        getCheckbox(pomType);
                        break;
                    case "Edit Box":
                        getEdit(pomType);
                        break;
                    case "Image":
                        getImages(pomType);
                        break;
                    case "List":
                        getList(pomType);
                        break;
                    case "Radio Button":
                        getRadioButton(pomType);
                        break;
                    case "Combo Box":

                        break;
                    case "Text":
                       getText(pomType);
                        break;
                }
            }


            File file  = new File(GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+pageName+".txt");
            String newfilePath = GlobalConstants.SETTINGS_FOLDER_PATH+File.separator+pageName+"_"+Generic.getDateTime()+".java";
            //Generic.changeExtension(file,"java");
            File newFile = new File(newfilePath);
            file.renameTo(newFile);
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe",newfilePath);
            pb.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void getText(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements text_h1 = document.getElementsByTag("h1");
//        Elements text_h2 = document.getElementsByTag("h2");
//        Elements text_h3 = document.getElementsByTag("h3");
//        Elements text_h4 = document.getElementsByTag("h4");
//        Elements text_h5 = document.getElementsByTag("h5");
//        Elements text_h6 = document.getElementsByTag("h6");
//        Elements text_p = document.getElementsByTag("p");
//        Elements text_abel = document.getElementsByTag("label");
        geth1(pomType);
        geth2(pomType);
        geth3(pomType);
        geth4(pomType);
        geth5(pomType);
        geth6(pomType);
        gethp(pomType);
//        gethlabel(pomType);
        getsmall(pomType);
    }
    public void gethp(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_p = document.getElementsByTag("p");
        for (Element p : text_p) {
            if (!StringUtils.isEmpty(p.text())) {
                id = p.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = p.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void getsmall(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_small = document.getElementsByTag("small");
        for (Element small : text_small) {
            if (!StringUtils.isEmpty(small.text())) {
                id = small.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = small.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
//    public void gethlabel(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements text_label = document.getElementsByTag("label");
//        for (Element label : text_label) {
//            if (!StringUtils.isEmpty(label.text())) {
//                id = label.attr("ID");
//                if (!StringUtils.isEmpty(id)) {
//                    id = "\"" + id + "\"";
//                    findby = "@FindBy(how = How.ID, using = " + id + ")";
//                } else {
//                    String linkInnerH = label.html();
//                    if (linkInnerH.contains("<")) {
//                        Document innerdoc = Jsoup.parse(linkInnerH);
//                        Elements innerelements = innerdoc.getAllElements();
//                        for (Element innerele : innerelements) {
//                            listStrings.add(innerele.tag().getName());
//                        }
//                        innerxpath = listStrings.get(4);
//                        for (int i = 5; i <= listStrings.size() - 1; i++) {
//                            innerxpath = innerxpath + "/" + listStrings.get(i);
//                        }
//                        listStrings.clear();
//
//                    }
//                    text = label.text();
//                    text = "\\\"" + text + "\\\"";
//                    if (innerxpath != null) {
//                        xpath = "//label/" + innerxpath + "[text()=" + text + "]";
//                    } else {
//                        xpath = "//label[text()=" + text + "]";
//                    }
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        xpath = "\"" + xpath + "\"";
//                    }
//                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//                }
//                text = label.text().replaceAll("\\s+", "");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//                cachelookup = "@CacheLookup";
//                webelement = "public WebElement txt" + text + ";";
//
//                if (findby != "") {
//                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
//                }
//                if (StringUtils.isEmpty(id)) {
//                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
//                } else {
//                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
//                }
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                }
//            }
//        }
//    }
    public void geth1(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h1 = document.getElementsByTag("h1");
        for (Element h1 : text_h1) {
            if (!StringUtils.isEmpty(h1.text())) {
                id = h1.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h1.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void geth2(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h2 = document.getElementsByTag("h2");
        for (Element h2 : text_h2) {
            if (!StringUtils.isEmpty(h2.text())) {
                id = h2.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h2.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void getImages(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements imgs = document.getElementsByTag("img");
        for (Element img : imgs) {
            if (!StringUtils.isEmpty(img.text())) {
                id = img.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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

                        //  }
                       // text = link.text();
                        text = "\\\"" + text + "\\\"";
                        if (innerxpath != null) {
                            xpath = "//a/" + innerxpath + "[text()=" + text + "]";
                        } else {
                            xpath = "//a[text()=" + text + "]";
                        }
                        if (pomType.equalsIgnoreCase("pom")) {
                            xpath = "\"" + xpath + "\"";
                        }
                        findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                    }

                }
            }
        }
    }
    public void getLinks(String pomType){
        listStrings.clear();
        innerxpath=null;
        //     Link
        Elements links = document.select("a[href]");
        for (Element link : links) {
            if (!StringUtils.isEmpty(link.text())) {
                id = link.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = link.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement lnk" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }

    public void getButtons(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements buttons = document.getElementsByTag("button");
        for (Element button : buttons){
            if(!StringUtils.isEmpty(button.ownText())) {
                id = button.attr("ID");
                if (id != "") {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                        xpath = "//a/" + innerxpath + "[text()=" + text + "]";
                    } else {
                        xpath = "//a[text()=" + text + "]";
                    }
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";

                }

                text = button.text().replaceAll("\\s+", "");

                cachelookup = "@CacheLookup";
                webelement = "public WebElement btn" + text + ";";
                if (findby != "") {
                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
                }
                if(StringUtils.isEmpty(id)){
                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+xpath+"@@@xpath";
                } else {
                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+id+"@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }
                }
            }
        }
    }
    public void geth3(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h3 = document.getElementsByTag("h3");
        for (Element h3 : text_h3) {
            if (!StringUtils.isEmpty(h3.text())) {
                id = h3.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h3.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void geth4(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h4 = document.getElementsByTag("h4");
        for (Element h4 : text_h4) {
            if (!StringUtils.isEmpty(h4.text())) {
                id = h4.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h4.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void geth5(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h5 = document.getElementsByTag("h5");
        for (Element h5 : text_h5) {
            if (!StringUtils.isEmpty(h5.text())) {
                id = h5.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h5.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void geth6(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements text_h6 = document.getElementsByTag("h6");
        for (Element h6 : text_h6) {
            if (!StringUtils.isEmpty(h6.text())) {
                id = h6.attr("ID");
                if (!StringUtils.isEmpty(id)) {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = h6.text().replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement txt" + text + ";";

                if (findby != "") {
                    pageObjectmodel = cachelookup+System.lineSeparator()+ findby + System.lineSeparator() + webelement+System.lineSeparator();
                }
                if (StringUtils.isEmpty(id)) {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + xpath + "@@@xpath";
                } else {
                    enumPropertiesmodel = pageName + "Page." + text + ".Link = " + id + "@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                }
            }
        }
    }
    public void getCheckbox(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements input_checkbox = document.getElementsByTag("input");
        for (Element chkbox : input_checkbox){
            if(chkbox.attr("type").equalsIgnoreCase("checkbox")){
                text = chkbox.text();
                if(text.isEmpty()){
                    text = chkbox.attr("name");
                    if(text.isEmpty()){
                        text = chkbox.attr("ID");
                    }
                }
                text = text.replaceAll("\\s+","");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");

                id=chkbox.attr("ID");
                id= "\""+id+"\"";

                findby = "@FindBy(how = How.ID, using = "+id+")";
                cachelookup  = "@CacheLookup";
                webelement = "public WebElement chkbox"+text+";";
                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
                enumPropertiesmodel = pageName+"Page."+text+".Checkbox = "+id+"@@@id";


                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }
                }
            }
        }
    }
    public void getEdit(String pomType){
        listStrings.clear();
        innerxpath=null;
        //Elements input_edit = document.getElementsByTag("//ng-form[@name='emailFieldForm']//input");
        Elements input_edit = document.getElementsByTag("input");
        for (Element edit : input_edit){
            System.out.println("Edit Attr-bute::"+edit.attr("type"));
            if(edit.attr("type").equalsIgnoreCase("input")||edit.attr("type").equalsIgnoreCase("text") || edit.attr("type").equalsIgnoreCase("password")){
                text = edit.text();
                if(text.isEmpty()){
                    text = edit.attr("name");
                    if(text.isEmpty()){
                        text = edit.attr("ID");
                    }
                }
                text = text.replaceAll("\\s+","");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");

                id=edit.attr("ID");
                id= "\""+id+"\"";

                findby = "@FindBy(how = How.ID, using = "+id+")";
                cachelookup  = "@CacheLookup";
                webelement = "public WebElement edt"+text+";";
                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement+System.lineSeparator();
                enumPropertiesmodel = pageName+"Page."+text+".Edit = "+id+"@@@id";

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }
                }
            }

        }

    }

    public void getList(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements lists = document.getElementsByTag("select");
        for (Element list : lists){
            id=list.attr("ID");

            if (id != "") {
                id = "\"" + id + "\"";
                findby = "@FindBy(how = How.ID, using = " + id + ")";
            } else {

                text = list.ownText();
                text = "\\\"" + text + "\\\"";
                xpath = "//select[text()=" + text + "]";
                if (pomType.equalsIgnoreCase("pom")) {
                    xpath = "\"" + xpath + "\"";
                }
                findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
            }
            text = list.attr("ID").replaceAll("\\s+", "");
            text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+*^]", "");
            cachelookup = "@CacheLookup";
            webelement = "public WebElement list" + text + ";";


            if (findby != "") {
                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement+System.lineSeparator();
                enumPropertiesmodel = pageName+"Page."+text+".List = "+id+"@@@id";
                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }
                }
            }

        }
    }

    public void getRadioButton(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements input_radio = document.getElementsByTag("input");
        for (Element radio : input_radio) {
            if (radio.attr("type").equalsIgnoreCase("radio")) {

                id = radio.attr("ID");

                if (id != "") {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
                } else {

                    text = radio.ownText();
                    text = "\\\"" + text + "\\\"";
                    xpath = "//input[text()=" + text + "]";
                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }

                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
                }
                text = radio.attr("ID").replaceAll("\\s+", "");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+*^]", "");
                cachelookup = "@CacheLookup";
                webelement = "public WebElement radio" + text + ";";

                if (findby != "") {
                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
                    enumPropertiesmodel = pageName+"Page."+text+".RadioButton = "+id+"@@@id";
                    if (pomType.equalsIgnoreCase("pom")) {
                        if(pageObjectmodel==null){
                            JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                                Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                            }
                        }

                    } else {
                        if(enumPropertiesmodel==null){
                            JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                                Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                            }
                        }
                    }
                }
            }
        }
    }

    public void getinputButton(String pomType){
        listStrings.clear();
        innerxpath=null;
        Elements input_buttons = document.getElementsByTag("input");
        for (Element button : input_buttons){
            if(button.attr("type").equalsIgnoreCase("submit")){
                id=button.attr("ID");
                if (id != "") {
                    id = "\"" + id + "\"";
                    findby = "@FindBy(how = How.ID, using = " + id + ")";
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
                    //text = button.text();

                    text = button.attr("value");


                    text = "\\\"" + text + "\\\"";
                    if (innerxpath != null) {
                        xpath = "//input/" + innerxpath + "[@value=" + text + "]";
                    } else {
                        xpath = "//input[@value=" + text + "]";
                    }

                    if (pomType.equalsIgnoreCase("pom")) {
                        xpath = "\"" + xpath + "\"";
                    }
                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";

                }
                text = button.attr("value").replaceAll("\\s+","");
                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");

                cachelookup  = "@CacheLookup";
                webelement = "public WebElement btn"+text+";";
                if (findby != "") {
                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
                }
                if(StringUtils.isEmpty(id)){
                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+xpath+"@@@xpath";
                } else {
                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+id+"@@@id";
                }

                if (pomType.equalsIgnoreCase("pom")) {
                    if(pageObjectmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(pageObjectmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }

                } else {
                    if(enumPropertiesmodel==null){
                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (Generic.createFile(GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt")) {
                            Generic.writeText(enumPropertiesmodel, GlobalConstants.SETTINGS_FOLDER_PATH + File.separator + pageName + ".txt", true);
                        }
                    }
                }
            }
        }
    }
}
