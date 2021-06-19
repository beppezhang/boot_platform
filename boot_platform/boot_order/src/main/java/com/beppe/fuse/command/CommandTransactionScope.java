package com.beppe.fuse.command;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 5:04 下午
 */
public interface CommandTransactionScope {

    void executeWithRollback();

}
