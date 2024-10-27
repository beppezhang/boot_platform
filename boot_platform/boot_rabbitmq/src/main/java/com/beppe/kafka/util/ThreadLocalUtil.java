package com.beppe.kafka.util;

/**
 * @author beppe
 * @data 2020/8/8 15:38
 * @description :
 */
public class ThreadLocalUtil {

    private static final ThreadLocal<String> stringContext = new ThreadLocal<>();

    /**
     * 塞入上下文对象
     *
     * @param context
     */
    public static void set(String context) {
        stringContext.set(context);
    }

    /**
     * 从上下文中取得userVo
     */
    public static String get() {
        return stringContext.get();
    }

    /**
     * 删除当前线程的上下文
     */
    public static void remove() {
        stringContext.remove();
    }
}
