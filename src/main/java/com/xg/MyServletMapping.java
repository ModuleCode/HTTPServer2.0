package com.xg;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

public class MyServletMapping {
    private HttpServlet servlet;
    private ArrayList<String> urls;

    public MyServletMapping(Servlet servlet, ArrayList<String> urls) {
        this.servlet = (HttpServlet) servlet;
        this.urls = urls;
    }

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = (HttpServlet) servlet;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }
}
