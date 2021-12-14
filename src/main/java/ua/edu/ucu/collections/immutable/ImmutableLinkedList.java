package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size;

    public ImmutableLinkedList(Object[] elements) {
        this.size = 0;
        this.head = null;
        this.tail = null;

        final int LEN = elements.length;
        Object val;
        Node cur, next;
        cur = new Node();

        if (LEN > 0) {
            val = elements[0];

            cur.setValue(val);
            this.head = cur;
            this.size = 1;
        }

        for (int i = 1; i < LEN; i++) {
            next = new Node();
            next.setValue(elements[i]);
            next.setPrevious(cur);
            cur.setNext(next);
            this.size += 1;
            cur = next;
        }
        this.tail = cur;
    }

    public ImmutableLinkedList() {
        this.size = 0;
        this.tail = null;
        this.head = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.size, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        int len = c.length;
        Object[] initialArr = new Object[this.size];
        if (this.size > 0) {
            Node cur;
            cur = this.head;
            for (int i = 0; i < this.size; i++) {
                initialArr[i] = cur.getValue();
                cur = cur.getNext();
            }
        }
        Object[] finalArr = new Object[this.size + len];
        for (int i = 0; i < finalArr.length; i++) {
            if (i < index) {
                finalArr[i] = initialArr[i];
            }
            else if (i >= index && i < index + len) {
                finalArr[i] = c[i - index];
            }
            else {
                finalArr[i] = initialArr[i - len];
            }
        }
        return new ImmutableLinkedList(finalArr);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = this.head;
        for (int i = 1; i < index; i++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] initialArr = new Object[this.size];
        if (this.size > 0) {
            Node cur;
            cur = this.head;
            for (int i = 0; i < this.size; i++) {
                initialArr[i] = cur.getValue();
                cur = cur.getNext();
            }
        }
        Object[] finalArr = new Object[this.size - 1];
        for (int i = 0; i < this.size; i++) {
            if (i < index) {
                finalArr[i] = initialArr[i];
            }
            else if (i > index) {
                finalArr[i - 1] = initialArr[i];
            }
        }
        return new ImmutableLinkedList(finalArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList immutableLinkedList = this.remove(index);
        return immutableLinkedList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node cur = this.head;
        int index = 0;
        while (cur != null) {
            if (cur.getValue() == e) {
                return index;
            }
            cur = cur.getNext();
            index++;
        }
        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        Object[] finalArr = new Object[this.size];
        return new ImmutableLinkedList(finalArr);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        if (this.size == 0) {
            return new Object[] {};
        }
        Object[] finalArr = new Object[this.size];
        Node cur;
        cur = this.head;
        for (int i = 0; i < this.size; i++) {
            finalArr[i] = cur.getValue();
            cur = cur.getNext();
        }
        return finalArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] initialArr = Arrays.copyOf(this.toArray(), this.size);
        Object[] finalArr = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            finalArr[i + 1] = initialArr[i];
        }
        finalArr[0] = e;
        return new ImmutableLinkedList(finalArr);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] initialArr = Arrays.copyOf(this.toArray(), this.size);
        Object[] finalArr = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            finalArr[i] = initialArr[i];
        }
        finalArr[this.size] = e;
        return new ImmutableLinkedList(finalArr);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.head == null) {
            throw new InputMismatchException();
        }
        return this.head.getValue();
    }

    public Object getLast() {
        if (this.tail == null) {
            throw new InputMismatchException();
        }
        return this.tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableList immutableList = this.remove(0);
        return (ImmutableLinkedList) immutableList;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableList immutableList = this.remove(this.size - 1);
        return (ImmutableLinkedList) immutableList;
    }
}
