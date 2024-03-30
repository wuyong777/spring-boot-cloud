package com.walle.designPattern.c.prototype;

public interface Prototype extends Cloneable {
    // 定义克隆方法
    Object clone() throws CloneNotSupportedException;
}