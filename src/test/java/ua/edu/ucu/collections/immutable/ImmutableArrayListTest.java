package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList immutableArrayList;

    @Before
    public void setUp() {
        immutableArrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, immutableArrayList.add(6).toArray());
        assertArrayEquals(new Object[]{0, 1, 2, 3, 4, 5}, immutableArrayList.add(0, 0).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7}, immutableArrayList.addAll(new Object[] {6, 7}).toArray());
        assertArrayEquals(new Object[]{0, 1, 1, 2, 3, 4, 5}, immutableArrayList.addAll(0, new Object[] {0, 1}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(4, immutableArrayList.get(3));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[] {2, 3, 4, 5}, immutableArrayList.remove(0).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[] {0, 2, 3, 4, 5}, immutableArrayList.set(0, 0).toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, immutableArrayList.indexOf(3));
    }

    @Test
    public void testSize() {
        assertEquals(5, immutableArrayList.size());
    }

    @Test
    public void testClear() {
        assertEquals(5, immutableArrayList.clear().size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(immutableArrayList.isEmpty());
        assertTrue(new ImmutableArrayList().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, immutableArrayList.toArray());
    }
}