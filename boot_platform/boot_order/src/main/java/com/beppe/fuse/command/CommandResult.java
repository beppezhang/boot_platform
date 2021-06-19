package com.beppe.fuse.command;

import java.util.Map;

/**
 * @author Mon co
 * @description
 * @time 2021/4/30 5:00 下午
 */
public interface CommandResult {

    Object getResultObj();

    Exception getException();

    Map getParams();

}
