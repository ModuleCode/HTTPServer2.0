package com.modulecode.server.tools;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.net.URL;

public class XMLTool {

    public static Document load(URL url) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(url); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return document;
    }
}
