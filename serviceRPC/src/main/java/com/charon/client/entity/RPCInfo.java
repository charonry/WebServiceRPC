package com.charon.client.entity;

import java.io.Serializable;

public class RPCInfo implements Serializable {

    private static final long serialVersionUID = -4772766439335505298L;
    private String packageName;
    private String className;
    private String methodName;
    private Object[] args;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
