package com.example.mbeans;

public interface HelloMBean {
    // operations

    public void sayHello();

    public int add(int x, int y);

    // attributes
    public String getName();

    public int getCacheSize();

    public void setCacheSize(int size);
}
