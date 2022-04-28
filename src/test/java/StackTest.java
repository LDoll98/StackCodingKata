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
    }

    @Test
    void push_first_string_element() {
        // give
        Stack<String> stringElements = new Stack<>();

        // when
        stringElements.push(FIRST_PUSH);

        // then
        assertEquals(1, stringElements.size());
    }

    @Test
    void push_first_double_element() {
        // give
        Stack<Double> doubleElements = new Stack<>();

        // when
        doubleElements.push(1.5);

        // then
        assertEquals(1, doubleElements.size());
    }

    @Test
    void push_first_char_element() {
        // give
        Stack<Character> charElements = new Stack<>();

        // when
        charElements.push('a');

        // then
        assertEquals(1, charElements.size());
    }

    @Test
    void push_more_elements() {
        // given
        Stack<Integer> integerElements = new Stack<>();

        // when
        integerElements.push(1);
        integerElements.push(2);
        integerElements.push(3);
        integerElements.push(4);

        // then
        assertEquals(4, integerElements.size());
    }

    @Test
    void pop_elements_from_stack_and_check_return_values() {
        // given
        Stack<Integer> integerElements = new Stack<>();

        // when
        integerElements.push(1);
        integerElements.push(2);
        integerElements.push(3);
        int removeTheThree = integerElements.pop();
        int removeTheTwo = integerElements.pop();
        int removeTheOne = integerElements.pop();

        // then
        assertEquals(3, removeTheThree);
        assertEquals(2, removeTheTwo);
        assertEquals(1, removeTheOne);
        assertTrue(integerElements.isEmpty());
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
        Stack<String> stringElements = new Stack<>();

        // when
        stringElements.push(FIRST_PUSH);
        stringElements.push(SECOND_PUSH);
        String removeSecondPush = stringElements.pop();
        String removeFirstPush = stringElements.pop();

        // then
        assertEquals(SECOND_PUSH, removeSecondPush);
        assertEquals(FIRST_PUSH, removeFirstPush);
    }

    @Test
    void push_and_pop_in_random_order() {
        // given
        Stack<Integer> integerElements = new Stack<>();

        // when
        integerElements.push(5);
        int removeTheFive = integerElements.pop();
        Exception exception = assertThrows(InvalidDnDOperationException.class, integerElements::pop);
        String currentMessage = exception.getMessage();
        integerElements.push(7);
        integerElements.push(9);
        integerElements.push(1);
        int removeTheOne = integerElements.pop();
        int removeTheNine = integerElements.pop();
        int removeTheSeven = integerElements.pop();

        // then
        assertEquals(5, removeTheFive);
        assertEquals(EXCEPTION_MESSAGE, currentMessage);
        assertEquals(1, removeTheOne);
        assertEquals(9, removeTheNine);
        assertEquals(7, removeTheSeven);
    }
}
