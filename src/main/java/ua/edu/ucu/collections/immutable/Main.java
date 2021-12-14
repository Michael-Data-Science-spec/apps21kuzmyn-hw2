package ua.edu.ucu.collections.immutable;

import ua.edu.ucu.collections.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        Object val = stack.peek();
        System.out.println(val);
    }
}
