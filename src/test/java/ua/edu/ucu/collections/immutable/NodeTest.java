package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node node1;
    Node node2;

    @Before
    public void setUp(){
        this.node1 = new Node();
        this.node2 = new Node();

        this.node1.setNext(this.node2);
        this.node2.setPrevious(this.node1);

        this.node1.setValue(1);
        this.node2.setValue(2);
    }

    @Test
    public void testToString() {
        assertEquals("1", node1.toString());
        assertEquals("2", node1.getNext().toString());
    }

    @Test
    public void getPrevious() {
        assertEquals(node1, node2.getPrevious());
    }

    @Test
    public void setPrevious() {
        node1.setPrevious(node2);
        assertEquals(node2, node1.getPrevious());
    }

    @Test
    public void getValue() {
        assertEquals(1, node1.getValue());
    }

    @Test
    public void setValue() {
        node2.setValue("2");
        assertEquals("2", node2.getValue());
    }

    @Test
    public void getNext() {
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void setNext() {
        node2.setNext(node1);
        assertEquals(node1, node2.getNext());
    }
}