package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;
    private int size;

    public ImmutableArrayList(Object[] elements) {
        this.size = elements.length;
        this.elements = Arrays.copyOf(elements, this.size);
    }

    public ImmutableArrayList() {
        this.size = 0;
        this.elements = new Object[] {};
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
        Object[] finalArr = new Object[this.size + len];
        for (int i = 0; i < finalArr.length; ++i) {
            if (i < index) {
                finalArr[i] = this.elements[i];
            } else if (i < index + len) {
                finalArr[i] = c[i - index];
            } else if (i >= len) {
                finalArr[i] = this.elements[i - len];
            }
        }
        return new ImmutableArrayList(finalArr);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] initialArr = this.toArray();
        Object[] finalArr = new Object[this.size - 1];
        for (int i = 0; i < this.size; ++i) {
            if (i < index) {
                finalArr[i] = initialArr[i];
            }
            else if (i > index) {
                finalArr[i - 1] = initialArr[i];
            }
        }
        return new ImmutableArrayList(finalArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList immutableArrayList = this.remove(index);
        return immutableArrayList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
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
        return new ImmutableArrayList(finalArr);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }
}
