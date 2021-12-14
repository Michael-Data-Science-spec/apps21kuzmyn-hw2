package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList immutableLinkedList;

    @Before
    public void setUp() {
        immutableLinkedList = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6}, immutableLinkedList.add(6).toArray());
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6}, immutableLinkedList.add(5, 6).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6, 7}, immutableLinkedList.addAll(new Object[] {6, 7}).toArray());
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6, 7}, immutableLinkedList.addAll(5, new Object[] {6, 7}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(2, immutableLinkedList.get(2));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{2, 3, 4, 5}, immutableLinkedList.remove(0).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[] {0, 2, 3, 4, 5}, immutableLinkedList.set(0, 0).toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(immutableLinkedList.indexOf(1), 0);
    }

    @Test
    public void testSize() {
        assertEquals(5, immutableLinkedList.size());
    }

    @Test
    public void testClear() {
        assertEquals(5, immutableLinkedList.clear().size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(immutableLinkedList.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, immutableLinkedList.toArray());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[] {0, 1, 2, 3, 4, 5}, immutableLinkedList.addFirst(0).toArray());
    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[] {1, 2, 3, 4, 5, 6}, immutableLinkedList.addLast(6).toArray());
    }

    @Test
    public void testGetHead() {
        assertEquals(1, immutableLinkedList.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(5, immutableLinkedList.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, immutableLinkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(5, immutableLinkedList.getLast());
    }

    @Test
    public void removeFirst() {
        assertArrayEquals(new Object[] {2, 3, 4, 5}, immutableLinkedList.removeFirst().toArray());
    }

    @Test
    public void removeLast() {
        assertArrayEquals(new Object[] {1, 2, 3, 4}, immutableLinkedList.removeLast().toArray());
    }
}