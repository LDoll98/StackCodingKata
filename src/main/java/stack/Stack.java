package stack;

import javax.management.openmbean.InvalidOpenTypeException;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.List;

public class Stack<TElement> implements StackInterface {
    private int stackSize;
    private Node head = new Node();
    private class Node {
        private TElement element;
        private Node next;
    }

    @Override
    public void push(Object o) {
        Node newNode = new Node();
        newNode.element = (TElement) o;
        newNode.next = head;
        head = newNode;
        stackSize++;
    }

    @Override
    public Object pop() {
        if(head.element == null)
            throw new InvalidDnDOperationException("Cannot remove element from empty Stack!");
        Object elementToRemove = head.element;
        head = head.next;
        stackSize--;
        return elementToRemove;
    }

    @Override
    public Object get(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode.element;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }
}
