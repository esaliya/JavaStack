package mylinkedlist.impl;

import mylinkedlist.MyComparator;
import mylinkedlist.MyLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class MyDummyLinkedList<T> implements MyLinkedList<T>{
    private LinkedList<T> list;

    public MyDummyLinkedList() {
        list = new LinkedList<T>();
    }

    public void put(T t) {
        list.add(t);
    }

    public T get() {
        T t = list.getFirst();
        list.remove(0);
        return t;

    }

    public int size() {
        return list.size();
    }

    public void remove(T t, MyComparator<T> c) {
        int size = list.size();
        T temp;
        for (int i = 0; i < size; i++) {
            temp = list.get(i);
            if (c.equal(temp, t)) {
                list.remove(i);
                break;
            }
        }
    }
}
