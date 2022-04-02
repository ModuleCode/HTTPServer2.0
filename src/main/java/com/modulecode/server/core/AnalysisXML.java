package com.modulecode.server.core;

import com.modulecode.server.constants.XMLConstantsName;
import com.modulecode.server.definition.Project;
import com.modulecode.server.tools.PathTool;
import com.modulecode.server.tools.XMLTool;
import org.dom4j.Document;
import org.dom4j.Element;

import java.net.URL;
import java.util.ArrayList;

public class AnalysisXML implements Analysis {
    private String configUrl;
    private Document document;

    public AnalysisXML(String configUrl) {
        this.configUrl = configUrl;
        URL url = PathTool.pathTool.getURL(configUrl);

        this.document = XMLTool.load(url);
    }

    @Override
    public int getPort() {
        Element rootElement = document.getRootElement();
        Element element = rootElement.element(XMLConstantsName.CONFIG);
        Element element1 = element.element(XMLConstantsName.PORT);
        int value = Integer.parseInt(element1.attributeValue("value"));
        return value;
    }

    @Override
    public ArrayList<Project> getProjects() {
        return null;
    }
}
