package queues.impl;

import linkedlists.impl.LinkedList;

public class MyQueue {
    private LinkedList head, tail;
    private int size;
    public Object dequeue() throws Exception{
        if (head != null){
            Object val = head.val;
            head = head.next;
            if (head != null){
                // remove pointer to previous head
                head.prev = null;
                // at this point there's a pointer from previous head to current head, but if garbage collector
                // is smart enough it'll find that previous head is not reachable, thus removing it from heap.
            }
            --size;
            return val;
        }
        throw new Exception("Queue is empty");
    }

    public int getSize(){
        return size;
    }

    public void enqueue(Object val){
        LinkedList n = new LinkedList(val);
        if (tail != null){
            tail.next = n;
            n.prev = tail;
        }
        tail = n;
        ++size;
    }
}

