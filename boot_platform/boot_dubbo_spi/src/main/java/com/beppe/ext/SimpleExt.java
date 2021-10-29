package com.beppe.ext;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("impl1")
public interface SimpleExt {

    @Adaptive
    String echo(URL url, String s);
    @Adaptive({"key1", "key2"})
    String yell(URL url, String s);
    // no @Adaptive
    String bang(URL url, int i);
}
