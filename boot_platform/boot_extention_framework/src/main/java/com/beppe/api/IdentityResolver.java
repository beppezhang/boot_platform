package com.beppe.api;

/**
 * 业务身份确认
 * @param <T>
 */
public interface IdentityResolver<T> {

    String getExtensionCode(T t);
}
