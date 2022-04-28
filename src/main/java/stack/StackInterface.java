package stack;

/**
 * Stack.Stack Interface which works according the First-In-Last-Out principle
 * @param <TElement> Specifies what datatype you want to use for your Stack.Stack
 */
public interface StackInterface<TElement> {

    /**
     * Add an element to your Stack.Stack.
     * @param element you want to add to the Stack.Stack.
     */
    void push(TElement element);

    /**
     * deletes the element that was added last.
     * @return element that was deleted
     */
    TElement pop();

    /**
     * Returns the value at the index you want.
     * @param index where the value is saved
     * @return the value at the index
     */
    TElement get(int index);

    /**
     * Returns the current size of the Stack.
     * @return the size of your Stack.
     */
    int size();

    /**
     * Checks if Stack is empty
     * @return true if empty, false if not
     */
    boolean isEmpty();
}
