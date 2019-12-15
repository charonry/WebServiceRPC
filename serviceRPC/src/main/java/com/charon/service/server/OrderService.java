package com.charon.service.server;


import com.charon.service.anno.Luban;

@Luban
public class OrderService {

    public void mod1(String name){
        System.out.println(name);
    }

    public String mod2(String name,Integer count){
        System.out.println(name+"\t"+count);
        System.out.println("------------");
        return " result server";
    }
}
