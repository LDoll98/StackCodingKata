import stack.Stack;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.awt.dnd.InvalidDnDOperationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StackTest{

    private static final String FIRST_PUSH = "First push";
    private static final String SECOND_PUSH = "Second push";
    private static final String EXCEPTION_MESSAGE = "Cannot remove element from empty Stack!";

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
        stringElements.push(FIRST_PUSH);

        // then
        assertEquals(1, stringElements.size());
        assertEquals(FIRST_PUSH, stringElements.get(0));
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
        Object removeTheThree = integerStack.pop();
        Object removeTheTwo = integerStack.pop();
        Object removeTheOne = integerStack.pop();

        // then
        assertEquals(3, (Integer) removeTheThree);
        assertEquals(2, (Integer) removeTheTwo);
        assertEquals(1, (Integer) removeTheOne);
        assertTrue(integerStack.isEmpty());
    }

    @Test
    void pop_from_empty_stack() {
        // give
        Stack<Integer> emptyStack = new Stack<>();

        // when
        Exception exception = assertThrows(InvalidDnDOperationException.class, emptyStack::pop);
        String currentMessage = exception.getMessage();

        // then
        assertEquals(EXCEPTION_MESSAGE, currentMessage);
    }

    @Test
    void pop_string_elements_from_stack() {
        // given
        Stack<String> stringStack = new Stack<>();

        // when
        stringStack.push(FIRST_PUSH);
        stringStack.push(SECOND_PUSH);
        Object removeSecondPush = stringStack.pop();
        Object removeFirstPush = stringStack.pop();

        // then
        assertEquals(SECOND_PUSH, (String) removeSecondPush);
        assertEquals(FIRST_PUSH, (String) removeFirstPush);
    }

    @Test
    void push_and_pop_in_random_order() {
        // given
        Stack<Integer> integerStack = new Stack<>();

        // when
        integerStack.push(5);
        Object removeTheFive = integerStack.pop();
        Exception exception = assertThrows(InvalidDnDOperationException.class, integerStack::pop);
        String currentMessage = exception.getMessage();
        integerStack.push(7);
        integerStack.push(9);
        integerStack.push(1);
        Object removeTheOne = integerStack.pop();
        Object removeTheNine = integerStack.pop();
        Object removeTheSeven = integerStack.pop();

        // then
        assertEquals(5, removeTheFive);
        assertEquals(EXCEPTION_MESSAGE, currentMessage);
        assertEquals(1, removeTheOne);
        assertEquals(9, removeTheNine);
        assertEquals(7, removeTheSeven);
    }
}
