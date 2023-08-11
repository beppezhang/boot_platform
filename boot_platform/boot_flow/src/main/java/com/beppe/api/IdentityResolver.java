package com.beppe.api;

public interface IdentityResolver<T> {

    /**
     * 根据领域模型，定位匹配的扩展点
     * @param t  领域模型
     * @return 业务编码
     */
    String getExtensionCode(T t);
}
