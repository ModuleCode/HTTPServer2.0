package com.modulecode.server.core;

import com.modulecode.server.constants.Constants;
import com.sun.deploy.net.HttpRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCore extends ServerSocket {
    private Analysis analysis;

    public ServerCore(Analysis analysis) throws IOException {
        super(analysis.getPort());

        this.analysis = analysis;
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = this.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //执行下一步
                    donext(socket);
                }
            }).start();
        }
    }

    //执行下一步
    private void donext(Socket socket) {
        System.out.println(socket);
    }
}
