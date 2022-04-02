package com.testRes;

import java.io.*;
import java.net.URL;

public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStream is = Test1.class.getClassLoader().getResourceAsStream("server.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }

//        System.out.println(stringBuffer.toString().replaceAll(" ", ""));
    }
}
