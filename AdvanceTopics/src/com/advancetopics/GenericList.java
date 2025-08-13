package com.advancetopics;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {
    private T[] items = null;
    private int count = 0;

    public GenericList(int initialCapacity) {
        this.items = (T[]) new Object[initialCapacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericListIterator<>(this);
    }

    public void add(T item) throws IndexOutOfBoundsException {
        if (count >= items.length)
            throw new IndexOutOfBoundsException("GenericList is full");

        items[count++] = item;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException("Index out of bounds");

        return items[index];
    }

    public int getCount() {
        return count;
    }
}
