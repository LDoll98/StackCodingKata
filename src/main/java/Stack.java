import java.awt.dnd.InvalidDnDOperationException;

public class Stack<T> {
    private int stackSize;
    private Node head = new Node();
    private class Node {
        private T element;
        private Node next;
    }


    public void push(T o) {
        Node newNode = new Node();
        newNode.element = o;
        newNode.next = head;
        head = newNode;
        stackSize++;
    }


    public T pop() {
        if(head.element == null)
            throw new InvalidDnDOperationException("Cannot remove element from empty Stack!");
        T elementToRemove = head.element;
        head = head.next;
        stackSize--;
        return elementToRemove;
    }


    public int size() {
        return stackSize;
    }


    public boolean isEmpty() {
        return stackSize == 0;
    }
}
