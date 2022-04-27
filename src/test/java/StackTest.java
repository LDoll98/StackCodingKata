import stack.Stack;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.awt.dnd.InvalidDnDOperationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StackTest{


    @Test
    void push_first_integer_Element() {
        // given
        Stack<Integer> integerStack = new Stack<>();

        // when
        integerStack.push(1);

        // then
        assertEquals(1, integerStack.size());
        assertEquals(1, integerStack.get(0));
    }

    @Test
    void push_first_string_element() {
        // give
        Stack<Integer> stringElements = new Stack<>();

        // when
        stringElements.push("First Element");

        // then
        assertEquals(1, stringElements.size());
        assertEquals("First Element", stringElements.get(0));
    }

    @Test
    void push_first_double_element() {
        // give
        Stack<Double> doubleElements = new Stack<>();

        // when
        doubleElements.push(1.5);

        // then
        assertEquals(1, doubleElements.size());
        assertEquals(1.5, doubleElements.get(0));
    }

    @Test
    void push_first_char_element() {
        // give
        Stack<Character> charElements = new Stack<>();

        // when
        charElements.push('a');

        // then
        assertEquals(1, charElements.size());
        assertEquals('a', charElements.get(0));
    }

    @Test
    void push_more_elements() {
        // given
        Stack<Integer> integerStack = new Stack<>();

        // when
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        // then
        assertEquals(4, integerStack.size());
        assertEquals(1, integerStack.get(integerStack.size()-1));
    }

    @Test
    void pop_elements_from_stack_and_check_return_values() {
        // given
        Stack<Integer> integerStack = new Stack<>();

        // when
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        Object removedLastElement = integerStack.pop();
        Object removedOneMoreElement = integerStack.pop();
        Object removedFirstPushedElement = integerStack.pop();

        // then
        assertEquals(3, (Integer) removedLastElement);
        assertEquals(2, (Integer) removedOneMoreElement);
        assertEquals(1, (Integer) removedFirstPushedElement);
        assertTrue(integerStack.isEmpty());
    }

    @Test
    void pop_from_empty_stack() {
        // give
        Stack<Integer> emptyStack = new Stack<>();

        // when
        Exception exception = assertThrows(InvalidDnDOperationException.class, emptyStack::pop);
        String exceptedMessage = "Cannot remove element from empty Stack!";
        String currentMessage = exception.getMessage();

        // then
        assertEquals(exceptedMessage, currentMessage);
    }
}
