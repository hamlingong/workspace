package com.hamlin.designpatterns.iterator;

public interface Collection {
    public Iterator iterator();

    public Object get(int i);

    public int size();
}
