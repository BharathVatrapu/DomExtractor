//package com.mainProject.utils;
//
//import org.apache.commons.lang3.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import javax.swing.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PageObjectGenerator {
//
//    Document document;
//    List<String> listStrings = new ArrayList<String>();
//    String innerxpath=null;
//    String id = null;
//    String text = null;
//    String xpath=null;
//    String findby=null;
//    String cachelookup;
//    String webelement;
//
//    String pageObjectmodel=null;
//    String enumPropertiesmodel=null;
//    String pageName;
//
//    public void createAllObjectLocators(String format,String htmlComp,String pomType,ArrayList<String> objList){
//
//        try
//        {
//            if(format.equalsIgnoreCase("url")){
//                document = Jsoup.connect(htmlComp).get();
//            } else{
//                document= Jsoup.parse( new File( htmlComp ) , "utf-8" );
//            }
//
//            pageName = document.title();
//            pageName = pageName.replaceAll("\\s+","");
//            pageName = pageName.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^|]*", "");
//            if(Generic.isFileExist(GlobalConstants.Xtractor_pom_folder+File.separator+pageName+".txt")) {
//                Generic.fileEmpty(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt");
//            }
//            for (int k=0;k<= objList.size()-1;k++) {
//                switch (objList.get(k)) {
//                    case "Link":
//                        getLinks(pomType);
//                        break;
//                    case "Button":
//                        getButtons(pomType);
//                        break;
//                    case "CheckBox":
//                        getCheckbox(pomType);
//                        break;
//                    case "Edit":
//                    case "input -Edit":
//                        getEdit(pomType);
//                        break;
//
//                    case "Image":
//                        listStrings.clear();
//                        innerxpath=null;
//                        Elements imgs = document.getElementsByTag("img");
//                        break;
//
//                    case "List":
//                        getList(pomType);
//                        break;
//                    case "RadioButton":
//                        getRadioButton(pomType);
//                        break;
//                    case "input -Button":
//                        getinputButton(pomType);
//                        break;
//                    case "Text":
//                        listStrings.clear();
//                        innerxpath=null;
//                        Elements text_elements_h1 = document.getElementsByTag("h1");
//                        Elements text_elements_h2 = document.getElementsByTag("h2");
//                        Elements text_elements_h3 = document.getElementsByTag("h3");
//                        Elements text_elements_h4 = document.getElementsByTag("h4");
//                        Elements text_elements_h5 = document.getElementsByTag("h5");
//                        Elements text_elements_h6 = document.getElementsByTag("h6");
//                        Elements text_elements_p = document.getElementsByTag("p");
//                        Elements text_elements_label = document.getElementsByTag("label");
//                        break;
//                }
//            }
//
//            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", GlobalConstants.Xtractor_pom_folder+File.separator+pageName+".txt");
//            pb.start();
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//    public void getLinks(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        //     Link
//        Elements links = document.select("a[href]");
//        for (Element link : links) {
//            if (!StringUtils.isEmpty(link.text())) {
//
//                id = link.attr("ID");
//
//                if (!StringUtils.isEmpty(id)) {
//                    id = "\"" + id + "\"";
//                    findby = "@FindBy(how = How.ID, using = " + id + ")";
//                } else {
//                    String linkInnerH = link.html();
//                    if (linkInnerH.contains("<")) {
//
//                        Document innerdoc = Jsoup.parse(linkInnerH);
//                        Elements innerelements = innerdoc.getAllElements();
//
//                        for (Element innerele : innerelements) {
//                            listStrings.add(innerele.tag().getName());
//                        }
//
//                        innerxpath = listStrings.get(4);
//                        for (int i = 5; i <= listStrings.size() - 1; i++) {
//                            innerxpath = innerxpath + "/" + listStrings.get(i);
//                        }
//                        listStrings.clear();
//
//                    }
//                    text = link.text();
//                    text = "\\\"" + text + "\\\"";
//                    if (innerxpath != null) {
//                        xpath = "//a/" + innerxpath + "[text()=" + text + "]";
//                    } else {
//                        xpath = "//a[text()=" + text + "]";
//                    }
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        xpath = "\"" + xpath + "\"";
//                    }
//                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//                }
//
//
//                text = link.text().replaceAll("\\s+", "");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//                cachelookup = "@CacheLookup";
//                webelement = "public WebElement lnk" + text + ";";
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
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
//    public void getButtons(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements buttons = document.getElementsByTag("button");
//        for (Element button : buttons){
//            if(!StringUtils.isEmpty(button.ownText())) {
//                id = button.attr("ID");
//                if (id != "") {
//                    id = "\"" + id + "\"";
//                    findby = "@FindBy(how = How.ID, using = " + id + ")";
//                } else {
//                    String linkInnerH = button.html();
//                    if (linkInnerH.contains("<")) {
//                        Document innerdoc = Jsoup.parse(linkInnerH);
//                        Elements innerelements = innerdoc.getAllElements();
//
//                        for (Element innerele : innerelements) {
//                            listStrings.add(innerele.tag().getName());
//                        }
//
//                        innerxpath = listStrings.get(4);
//                        for (int i = 5; i <= listStrings.size() - 1; i++) {
//                            innerxpath = innerxpath + "/" + listStrings.get(i);
//                        }
//                        listStrings.clear();
//
//                    }
//                    text = button.text();
//                    text = "\\\"" + text + "\\\"";
//                    if (innerxpath != null) {
//                        xpath = "//a/" + innerxpath + "[text()=" + text + "]";
//                    } else {
//                        xpath = "//a[text()=" + text + "]";
//                    }
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        xpath = "\"" + xpath + "\"";
//                    }
//                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//
//                }
//
//                text = button.text().replaceAll("\\s+", "");
//
//                cachelookup = "@CacheLookup";
//                webelement = "public WebElement btn" + text + ";";
//                if (findby != "") {
//                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                }
//                if(StringUtils.isEmpty(id)){
//                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+xpath+"@@@xpath";
//                } else {
//                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+id+"@@@id";
//                }
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void getCheckbox(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements input_checkbox = document.getElementsByTag("input");
//        for (Element chkbox : input_checkbox){
//            if(chkbox.attr("type").equalsIgnoreCase("checkbox")){
//                text = chkbox.text();
//                if(text.isEmpty()){
//                    text = chkbox.attr("name");
//                    if(text.isEmpty()){
//                        text = chkbox.attr("ID");
//                    }
//                }
//                text = text.replaceAll("\\s+","");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//
//                id=chkbox.attr("ID");
//                id= "\""+id+"\"";
//
//                findby = "@FindBy(how = How.ID, using = "+id+")";
//                cachelookup  = "@CacheLookup";
//                webelement = "public WebElement chkbox"+text+";";
//                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                enumPropertiesmodel = pageName+"Page."+text+".Checkbox = "+id+"@@@id";
//
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public void getEdit(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        //Elements input_edit = document.getElementsByTag("//ng-form[@name='emailFieldForm']//input");
//        Elements input_edit = document.select("//ng-form[@name='emailFieldForm']//input");
//        for (Element edit : input_edit){
//            if(edit.attr("type").equalsIgnoreCase("input")){
//                text = edit.text();
//                if(text.isEmpty()){
//                    text = edit.attr("name");
//                    if(text.isEmpty()){
//                        text = edit.attr("ID");
//                    }
//                }
//                text = text.replaceAll("\\s+","");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//
//                id=edit.attr("ID");
//                id= "\""+id+"\"";
//
//                findby = "@FindBy(how = How.ID, using = "+id+")";
//                cachelookup  = "@CacheLookup";
//                webelement = "public WebElement edt"+text+";";
//                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                enumPropertiesmodel = pageName+"Page."+text+".Edit = "+id+"@@@id";
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//
//        }
//        for (Element editPsw : input_edit) {
//            if (editPsw.attr("type").equalsIgnoreCase("password")) {
//                text = editPsw.text();
//                if (text.isEmpty()) {
//                    text = editPsw.attr("name");
//                    if (text.isEmpty()) {
//                        text = editPsw.attr("ID");
//                    }
//                }
//                text = text.replaceAll("\\s+", "");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//
//
//                id = editPsw.attr("ID");
//                id = "\"" + id + "\"";
//
//                findby = "@FindBy(how = How.ID, using = " + id + ")";
//                cachelookup = "@CacheLookup";
//                webelement = "public WebElement edt" + text + ";";
//                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                enumPropertiesmodel = pageName+"Page."+text+".Edit = "+id+"@@@id";
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void getList(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements lists = document.getElementsByTag("select");
//        for (Element list : lists){
//            id=list.attr("ID");
//
//            if (id != "") {
//                id = "\"" + id + "\"";
//                findby = "@FindBy(how = How.ID, using = " + id + ")";
//            } else {
//
//                text = list.ownText();
//                text = "\\\"" + text + "\\\"";
//                xpath = "//select[text()=" + text + "]";
//                if (pomType.equalsIgnoreCase("pom")) {
//                    xpath = "\"" + xpath + "\"";
//                }
//                findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//            }
//            text = list.attr("ID").replaceAll("\\s+", "");
//            text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+*^]", "");
//            cachelookup = "@CacheLookup";
//            webelement = "public WebElement list" + text + ";";
//
//
//            if (findby != "") {
//                pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                enumPropertiesmodel = pageName+"Page."+text+".List = "+id+"@@@id";
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//
//    public void getRadioButton(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements input_radio = document.getElementsByTag("input");
//        for (Element radio : input_radio) {
//            if (radio.attr("type").equalsIgnoreCase("radio")) {
//
//                id = radio.attr("ID");
//
//                if (id != "") {
//                    id = "\"" + id + "\"";
//                    findby = "@FindBy(how = How.ID, using = " + id + ")";
//                } else {
//
//                    text = radio.ownText();
//                    text = "\\\"" + text + "\\\"";
//                    xpath = "//input[text()=" + text + "]";
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        xpath = "\"" + xpath + "\"";
//                    }
//
//                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//                }
//                text = radio.attr("ID").replaceAll("\\s+", "");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+*^]", "");
//                cachelookup = "@CacheLookup";
//                webelement = "public WebElement radio" + text + ";";
//
//                if (findby != "") {
//                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                    enumPropertiesmodel = pageName+"Page."+text+".RadioButton = "+id+"@@@id";
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        if(pageObjectmodel==null){
//                            JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                        } else {
//                            if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                                Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                            }
//                        }
//
//                    } else {
//                        if(enumPropertiesmodel==null){
//                            JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                        } else {
//                            if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                                Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void getinputButton(String pomType){
//        listStrings.clear();
//        innerxpath=null;
//        Elements input_buttons = document.getElementsByTag("input");
//        for (Element button : input_buttons){
//            if(button.attr("type").equalsIgnoreCase("submit")){
//                id=button.attr("ID");
//                if (id != "") {
//                    id = "\"" + id + "\"";
//                    findby = "@FindBy(how = How.ID, using = " + id + ")";
//                } else {
//                    String linkInnerH = button.html();
//                    if (linkInnerH.contains("<")) {
//
//                        Document innerdoc = Jsoup.parse(linkInnerH);
//                        Elements innerelements = innerdoc.getAllElements();
//
//                        for (Element innerele : innerelements) {
//                            listStrings.add(innerele.tag().getName());
//                        }
//
//                        innerxpath = listStrings.get(4);
//                        for (int i = 5; i <= listStrings.size() - 1; i++) {
//                            innerxpath = innerxpath + "/" + listStrings.get(i);
//                        }
//                        listStrings.clear();
//
//                    }
//                    //text = button.text();
//
//                    text = button.attr("value");
//
//
//                    text = "\\\"" + text + "\\\"";
//                    if (innerxpath != null) {
//                        xpath = "//input/" + innerxpath + "[@value=" + text + "]";
//                    } else {
//                        xpath = "//input[@value=" + text + "]";
//                    }
//
//                    if (pomType.equalsIgnoreCase("pom")) {
//                        xpath = "\"" + xpath + "\"";
//                    }
//                    findby = "@FindBy(how = How.XPATH, using = " + xpath + ")";
//
//                }
//                text = button.attr("value").replaceAll("\\s+","");
//                text = text.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^]*", "");
//
//                cachelookup  = "@CacheLookup";
//                webelement = "public WebElement btn"+text+";";
//                if (findby != "") {
//                    pageObjectmodel = findby + System.lineSeparator() + cachelookup + System.lineSeparator() + webelement;
//                }
//                if(StringUtils.isEmpty(id)){
//                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+xpath+"@@@xpath";
//                } else {
//                    enumPropertiesmodel = pageName+"Page."+text+".Link = "+id+"@@@id";
//                }
//
//                if (pomType.equalsIgnoreCase("pom")) {
//                    if(pageObjectmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(pageObjectmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//
//                } else {
//                    if(enumPropertiesmodel==null){
//                        JOptionPane.showMessageDialog(null, "Objects are not found", "Warning" , JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        if (Generic.createFile(GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt")) {
//                            Generic.writeText(enumPropertiesmodel, GlobalConstants.Xtractor_pom_folder + File.separator + pageName + ".txt", true);
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
