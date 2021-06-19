package com.beppe.fuse.command;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mon co
 * @description 命令上下文 主要用于参数传递 整条链路的参数传递和结果传递
 * @time 2021/4/30 3:42 下午
 */
public class CommandContext implements Serializable {

    private static final long serialVersionUID = 3888859963023798589L;

    public static final String VAR_OPERATOR = "operator";

    /**
     * 参数集
     */
    private Map<String, Object> parameters = new ConcurrentHashMap<>();

    /**
     * 结果集
     */
    private Map<String, CommandResult> results = new ConcurrentHashMap<>();

    public Map<String, CommandResult> getResults() {
        return results;
    }

    public void setResults(Map<String, CommandResult> results) {
        this.results = results;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Object getParameter(String var) {
        return parameters.get(var);
    }

    public void setParameter(String var, Object obj) {
        if (obj == null) {
            return;
        }
        parameters.put(var, obj);
    }
}
