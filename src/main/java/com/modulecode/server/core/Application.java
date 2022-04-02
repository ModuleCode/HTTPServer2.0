package com.modulecode.server.core;

import com.modulecode.server.constants.Constants;
import com.modulecode.server.tools.PathTool;

import java.io.IOException;

/**
 * 服务器启动类
 */
public class Application {
    private ServerCore serverCore;

    public Application(String configURL) throws IOException {
        //解析xml
        AnalysisXML analysisXML = new AnalysisXML(configURL);
        //创建服务器
        this.serverCore = new ServerCore(analysisXML);

    }

    //开启服务器
    public void start() throws IOException {
        //启动服务器
        this.serverCore.start();
    }

}
