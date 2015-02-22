package testers;

import mylinkedlist.MyComparator;
import mylinkedlist.MyLinkedList;
import mylinkedlist.impl.MyDoublyLinkedList;
import mylinkedlist.impl.MyDummyLinkedList;
import mylinkedlist.impl.MySinglyLinkedList;

public class MyLinkedListTester {
    public static void main(String[] args) {
        // Test DummyLinkedList
        MyLinkedList<Integer> list = new MyDummyLinkedList<Integer>();
        TestLinkedList(list);

        // TestSinglyLinkedList
        list = new MySinglyLinkedList<Integer>();
        TestLinkedList(list);

        // TestDoublyLinkedList
        list = new MyDoublyLinkedList<Integer>();
        TestLinkedList(list);
    }

    private static void TestLinkedList(MyLinkedList<Integer> list) {
        for (int i = 0; i < 10; i++) {
             list.put(2*i);
        }

        System.out.println(list.size()); // should see 10
        System.out.println(list.get()); // should see 0
        System.out.println(list.size()); // should see 9
        System.out.println(list.get()); // should see 2
        System.out.println(list.size()); // should see 8

        MyComparator<Integer> c = new MyComparator<Integer>() {
            public boolean equal(Integer t1, Integer t2) {
                return t1.intValue() == t2.intValue();
            }
        };

        list.remove(12, c);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get()); // should see 4, 6, 8, 10, 14, 16, 18
        }
    }
}
