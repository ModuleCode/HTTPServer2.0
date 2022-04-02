package com.modulecode.server.tools;

import com.testRes.Test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class PathTool {
    public static PathTool pathTool = new PathTool();

    public String getStr(String url) throws IOException {
        InputStream is = PathTool.class.getClassLoader().getResourceAsStream(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }
        return stringBuffer.toString();
    }

    public URL getURL(String url) {
        URL resource = PathTool.class.getClassLoader().getResource(url);
        return resource;
    }
}
