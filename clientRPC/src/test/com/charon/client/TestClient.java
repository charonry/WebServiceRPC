package com.charon.client;

import com.charon.client.entity.RPCInfo;
import org.junit.Test;

/**
 * @description:
 * @author: charon
 * @create: 2019-12-14 13:03
 **/
public class TestClient {
    @Test
    public void client(){
        RpcClient rpcClient=new RpcClient();
        RPCInfo rpcInfo=new RPCInfo();
        rpcInfo.setPackageName("com.charon.service.server");
        rpcInfo.setClassName("OrderService");
        rpcInfo.setMethodName("mod2");
        Object params[]=new Object[]{"luban",999};
        rpcInfo.setArgs(params);
        rpcClient.connServer(rpcInfo);
    }
}
