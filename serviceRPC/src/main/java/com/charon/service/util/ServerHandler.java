package com.charon.service.util;

import com.charon.client.entity.RPCInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-14 13:21
 **/
public class ServerHandler implements Runnable {
    Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("--------------run--------------");
        /**
         * 获取客户端信息
         * 根据客户端的信息调用方法
         * 返回给客户端
         *
         * 调用方法的步骤
         * 得到对象--得到类
         * 得到方法--得到方法名 得到参数类型
         *
         * 反射调用
         */
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            RPCInfo rpcInfo=(RPCInfo)objectInputStream.readObject();
            //获取包名
            String packageName=rpcInfo.getPackageName();
            //获取类名
            String className = rpcInfo.getClassName();
            //类对象
            Class clazz = Class.forName(packageName + "." + className);
            Object targetObject = clazz.newInstance();
            //方法名
            String methodName=rpcInfo.getMethodName();
            //参数
            Object[] params = rpcInfo.getArgs();
            //参数对象
            Class types[]=new Class[params.length];
            for(int i=0;i<params.length;i++){
                types[i]=params[i].getClass();
            }
            Method targetMethod = clazz.getDeclaredMethod(methodName, types);
            Object result = targetMethod.invoke(targetObject, params);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException | IllegalAccessException |
                InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
