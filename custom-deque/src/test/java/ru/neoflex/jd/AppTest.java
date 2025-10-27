package ru.neoflex.jd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    void size_ReturnsRightSize_WhenHeadBeforeTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(2);
        deque.add(41);
        deque.add(90);

        assertEquals(3, deque.size());
    }

    @Test
    void size_ReturnsRightSize_WhenHeadAfterTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>(10);
        deque.add(2);
        deque.add(41);
        deque.add(90);
        deque.addFirst(90);
        deque.addFirst(90);

        assertEquals(5, deque.size());
    }

    @Test
    void size_Returns0_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertEquals(0, deque.size());
    }

    @Test
    void isEmpty_ReturnsTrue_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>(5);

        assertTrue(deque.isEmpty());
    }

    @Test
    void isEmpty_ReturnsFalse_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(100);

        assertFalse(deque.isEmpty());
    }

    @Test
    void add_AddsElementToTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(100);

        assertEquals(100, deque.peekLast());
    }

    @Test
    void addFirst_AddsElementToHead_WhenDequeIsNotFull() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.addFirst(100);

        assertEquals(100, deque.peekFirst());
    }

    @Test
    void addFirst_AddsElementToHead_WhenDequeIsFull() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>(3);
        deque.add(9);
        deque.add(21);
        deque.add(78);
        deque.addFirst(100);

        assertEquals(100, deque.peekFirst());
    }

    @Test
    void addLast_AddsElementToTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.addLast(100);

        assertEquals(100, deque.peekLast());
    }

    @Test
    void offer_AddsElementToTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.offer(9);
        deque.offer(21);
        deque.offer(100);

        assertEquals(100, deque.peekLast());
    }

    @Test
    void offerFirst_AddsElementToHead() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.offerFirst(100);

        assertEquals(100, deque.peekFirst());
    }

    @Test
    void offerLast_AddsElementToTail() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.offerLast(100);

        assertEquals(100, deque.peekLast());
    }

    @Test
    void push_AddsElementToHead() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.push(9);
        deque.push(21);
        deque.push(100);

        assertEquals(100, deque.peekFirst());
    }

    @Test
    void pop_removesElementFromHeadAndReturnsIt() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.push(9);
        deque.push(21);
        deque.push(100);
        int res = deque.pop();

        assertEquals(100, res);
        assertEquals(21, deque.peekFirst());
    }

    @Test
    void removeFirst_removesElementFromHeadAndReturnsIt_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.addFirst(30);
        int res = deque.removeFirst();

        assertEquals(30, res);
        assertEquals(9, deque.peekFirst());
    }

    @Test
    void removeFirst_ThrowsException_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertThrows(NoSuchElementException.class, deque::removeFirst);
    }

    @Test
    void removeLast_removesElementFromTailAndReturnsIt_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(30);
        deque.add(100);
        int res = deque.removeLast();

        assertEquals(100, res);
        assertEquals(30, deque.peekLast());
    }

    @Test
    void removeLast_ThrowsException_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertThrows(NoSuchElementException.class, deque::removeLast);
    }

    @Test
    void poll_removesElementFromHeadAndReturnsIt() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(100);
        int res = deque.poll();

        assertEquals(9, res);
        assertEquals(21, deque.peekFirst());
    }

    @Test
    void pollFirst_removesElementFromHeadAndReturnsIt_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(30);
        deque.add(100);
        int res = deque.pollFirst();

        assertEquals(9, res);
        assertEquals(21, deque.peekFirst());
    }

    @Test
    void pollFirst_ReturnsNull_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertNull(deque.pollFirst());
    }

    @Test
    void pollLast_removesElementFromTailAndReturnsIt_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(30);
        deque.add(100);
        int res = deque.pollLast();

        assertEquals(100, res);
        assertEquals(30, deque.peekLast());
    }

    @Test
    void pollLast_ReturnsNull_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertNull(deque.pollLast());
    }

    @Test
    void peek_returnsElementFromHead() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(100);

        assertEquals(9, deque.peek());
    }

    @Test
    void peekFirst_returnsElementFromHead_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(30);
        deque.add(100);

        assertEquals(9, deque.peekFirst());
    }

    @Test
    void peekFirst_returnsNull_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertNull(deque.peekFirst());
    }

    @Test
    void peekLast_returnsElementFromTail_WhenDequeIsNotEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(9);
        deque.add(21);
        deque.add(30);
        deque.add(100);

        assertEquals(100, deque.peekLast());
    }

    @Test
    void peekLast_returnsNull_WhenDequeIsEmpty() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();

        assertNull(deque.peekLast());
    }

    @Test
    void contains_returnsTrue_WhenElementIsInDeque() {
        List arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("hello");
        arrayList.add("java");
        CustomDeque<String> deque = new CustomArrayDequeImpl<>(arrayList);

        assertTrue(deque.contains("hello"));
    }

    @Test
    void contains_returnsFalse_WhenElementIsNotInDeque() {
        List arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("hello");
        arrayList.add("java");
        CustomDeque<String> deque = new CustomArrayDequeImpl<>(arrayList);

        assertFalse(deque.contains("php"));
    }

    @Test
    void toString_returnsRightString() {
        CustomDeque<Integer> deque = new CustomArrayDequeImpl<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        assertEquals("[1, 2, 3]", deque.toString());
    }
}
