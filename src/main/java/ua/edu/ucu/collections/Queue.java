package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList immutableLinkedList;

    public Queue() {
        this.immutableLinkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        return immutableLinkedList.getFirst();
    }

    public Object dequeue() {
        Object next = this.peek();
        this.immutableLinkedList = immutableLinkedList.removeFirst();
        return next;
    }

    public void enqueue(Object e) {
        this.immutableLinkedList = immutableLinkedList.addLast(e);
    }
}
