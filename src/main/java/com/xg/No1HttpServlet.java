package com.xg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class No1HttpServlet extends HttpServlet {
    private ArrayList<String> urlList = new ArrayList<>();

    public No1HttpServlet(String... urls) {
        for (int i = 0; i < urls.length; i++) {
            urlList.add(urls[i]);
        }
        System.out.println(urlList);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        for (String urls : urlList) {
            if (requestURI.equals(urls)) {
                System.out.println(urls);
            }
            ;
        }
    }
}
