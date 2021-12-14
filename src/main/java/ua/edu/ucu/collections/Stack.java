package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList immutableLinkedList;

    public Stack() {
        this.immutableLinkedList = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.immutableLinkedList = immutableLinkedList.addLast(e);
    }

    public Object pop() {
        Object next = this.peek();
        this.immutableLinkedList = immutableLinkedList.removeLast();
        return next;
    }

    public Object peek() {
        return this.immutableLinkedList.getLast();
    }
}
