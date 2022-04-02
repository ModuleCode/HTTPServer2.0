package com.xg;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ArrayList<MyServletMapping> myServletMappings = new ArrayList<>();
    private int port;

    public Server(int port) {
        this.port = port;
    }


    public void addServlet(Class<? extends Servlet> clazz, ArrayList<String> urls) throws IllegalAccessException, InstantiationException {

        myServletMappings.add(new MyServletMapping(clazz.newInstance(), urls));
    }

    public void initServer() throws IOException, ServletException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket= serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        accept(socket);
                    } catch (IOException | ServletException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    private void accept(Socket socket) throws IOException, ServletException {
        MyRequest myRequest = new MyRequest(socket.getInputStream());
        MyResponse myResponse = new MyResponse(socket.getOutputStream());

        String requestURI = myRequest.getRequestURI();
        System.out.println(requestURI);
        HttpServlet servlet = (HttpServlet) myServletMappings.get(0).getServlet();
        PrintWriter w = myResponse.getWriter();
        w.write("HTTP/1.1 200 OK\r\n");
        w.write("Accept-Encoding: gzip\r\n");
        w.write("Content-Type: text/html;charset=utf-8\r\n");
        w.write("\r\n");
        w.write("\r\n");
        servlet.init();
        servlet.service(myRequest, myResponse);
        myResponse.flushBuffer();
        socket.close();

    }
}
