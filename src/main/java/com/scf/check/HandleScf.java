package com.scf.check;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by xuxin on 17/1/20.
 */

public class HandleScf
{
    public static void main(String[] args)
    {
        getScf();
    }
    static void getScf() {
        WriteDeleteUtil.deleteFile("logs/scf.txt");
        String path = "resource/scf.config";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(path));
            NodeList nodeList = document.getElementsByTagName("add");
            for (int i = 0; i < nodeList.getLength(); i++) {
                String str = "";
                str = str + nodeList.item(i).getParentNode().getParentNode().getParentNode().getAttributes().getNamedItem("name").toString().split("[\"]")[1] + " ";
                str = str + nodeList.item(i).getAttributes().getNamedItem("host").toString().split("[\"]")[1] + " ";
                str = str + nodeList.item(i).getAttributes().getNamedItem("port").toString().split("[\"]")[1];
                WriteDeleteUtil.writeFile("logs/scf.txt", str);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}