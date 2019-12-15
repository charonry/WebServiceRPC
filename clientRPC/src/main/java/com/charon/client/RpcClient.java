package com.charon.client;

import com.charon.client.entity.RPCInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @description: RPC分布式的客户端
 * @author: charon
 * @create: 2019-12-13 11:45
 **/
public class RpcClient {

    public void connServer(RPCInfo rpcInfo){
        try {
            Socket socket=new Socket("localhost",8089);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcInfo);
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            String result = (String)objectInputStream.readObject();
            System.out.println("result"+"\t"+result);
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
