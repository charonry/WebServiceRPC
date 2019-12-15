package com.charon.service;

import com.charon.service.util.RPCRequest;
import org.junit.Test;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-14 13:37
 **/
public class TestService {
    @Test
    public void service(){
        RPCRequest rpcRequest=new RPCRequest();
        rpcRequest.provideServer();
    }
}
