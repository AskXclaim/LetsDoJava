package com.advancetopics;

import java.util.Iterator;

public class GenericListIterator<T> implements Iterator<T> {
    private final GenericList<T> list;
    private int currentIndex = 0;

    public GenericListIterator(GenericList<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return (currentIndex < list.getCount());
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(currentIndex++);
        }
        return null;
    }
}
