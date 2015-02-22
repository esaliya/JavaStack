package mylinkedlist;

public interface MyLinkedList<T> {
    public void put(T t);

    public T get();

    public int size();

    public void remove(T t, MyComparator<T> c);


}
