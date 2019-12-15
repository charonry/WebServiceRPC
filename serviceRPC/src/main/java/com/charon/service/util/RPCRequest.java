package com.charon.service.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-14 13:18
 **/
public class RPCRequest {
    ExecutorService executorService= Executors.newFixedThreadPool(10);
    public void provideServer(){
        try {
            ServerSocket serverSocket=new ServerSocket(8089);
            while(true){
                System.out.println("wait client conn");
                Socket socket = serverSocket.accept();
                System.out.println("client success conn");
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
