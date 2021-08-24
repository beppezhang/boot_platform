package com.beppe.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.testng.annotations.Test;

public class DubboDemo1 {

    @Test
    public void test1(){
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class)
                .getAdaptiveExtension();
    }
}
