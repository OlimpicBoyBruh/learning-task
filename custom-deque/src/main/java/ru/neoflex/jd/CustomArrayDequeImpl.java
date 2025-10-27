package ru.neoflex.jd;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * CustomArrayDequeImpl - реализация двусторонней очереди (Deque),
 * основана на кольцевом буфере для избежания необходимости в сдвиге всех элементов
 * при добавлении новых
 */
public class CustomArrayDequeImpl<T> implements CustomDeque<T> {

    private int head = 0;
    private int tail = 1;
    private Object[] internal;
    private final static int DEFAULT_CAPACITY = 16;
    private final static int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private final static int MIN_CAPACITY = 2;
    private final static double GROWTH_FACTOR = 1.5;

    public CustomArrayDequeImpl() {
        internal = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayDequeImpl(int capacity) {
        if (capacity < MIN_CAPACITY) {
            capacity = MIN_CAPACITY;
        }
        internal = new Object[capacity];
    }

    public CustomArrayDequeImpl(Collection<T> c) {
        if (c.size() < DEFAULT_CAPACITY) {
            internal = new Object[DEFAULT_CAPACITY];
        } else {
            internal = new Object[(int) (c.size() * GROWTH_FACTOR)];
        }
        tail = c.size();
        int i = head;
        for (T element : c) {
            internal[i] = element;
            i++;
        }
    }

    @Override
    public int size() {
        if (tail - head == 1 && internal[head] == null) {
            return 0;
        }
        if (head < tail) {
            return tail - head;
        } else {
            return tail + internal.length - head;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T element) {
        addLast(element);
        return true;
    }

    @Override
    public void addFirst(T element) {
        add(element, true, true);
    }

    @Override
    public void addLast(T element) {
        add(element, false, true);
    }

    @Override
    public boolean offer(T element) {
        return offerLast(element);
    }

    @Override
    public boolean offerFirst(T element) {
        return add(element, true, false);
    }

    @Override
    public boolean offerLast(T element) {
        return add(element, false, false);
    }

    @Override
    public void push(T element) {
        addFirst(element);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public T removeFirst() {
        return remove(true, true);
    }

    @Override
    public T removeLast() {
        return remove(false, true);
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T pollFirst() {
        return remove(true, false);
    }

    @Override
    public T pollLast() {
        return remove(false, false);
    }

    @Override
    public T peek() {
        return pollFirst();
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) internal[head];
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            return null;
        }
        int actualTail = nextIndex(tail, false);
        return (T) internal[actualTail];
    }

    @Override
    public boolean contains(T item) {
        if (head < tail) {
            return contains(item, head, tail);
        } else {
            return contains(item, 0, tail) || contains(item, head, internal.length);
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        if (head < tail) {
            res.append(toString(head, tail));
        } else {
            res.append(toString(head, internal.length));
            res.append(toString(0, tail));
        }
        res.delete(res.length() - 2, res.length());
        res.append("]");
        return res.toString();
    }

    private boolean add(T element, boolean toHead, boolean throwsException) {
        if (head == tail && throwsException) {
            expandInternal(true);
        }
        if (head == tail && !throwsException) {
            if (!expandInternal(false)) {
                return false;
            }
        }
        if (toHead) {
            if (internal[head] != null) {
                head = nextIndex(head, false);
            }
            internal[head] = element;
        } else {
            if (isEmpty()) {
                internal[head] = element;
            } else {
                internal[tail] = element;
                tail = nextIndex(tail, true);
            }
        }
        return true;
    }

    private boolean expandInternal(boolean throwException) {
        if (internal.length == MAX_CAPACITY) {
            if (!throwException) {
                return false;
            }
            throw new IllegalStateException("Deque full - maximum capacity reached");
        }

        Object[] expandedInternal;
        if (internal.length * GROWTH_FACTOR > MAX_CAPACITY) {
            expandedInternal = new Object[MAX_CAPACITY];
        } else {
            expandedInternal = new Object[(int) (internal.length * GROWTH_FACTOR)];
        }

        if (head < tail) {
            if (tail - head >= 0) {
                System.arraycopy(internal, head, expandedInternal, head, tail - head);
            }
        } else {
            if (tail >= 0) {
                System.arraycopy(internal, 0, expandedInternal, 0, tail);
            }
            int difference = expandedInternal.length - internal.length;
            if (internal.length - head >= 0) {
                System.arraycopy(internal, head, expandedInternal, head + difference,
                        internal.length - head);
            }
            head += difference;
        }
        internal = expandedInternal;
        return true;
    }

    private int nextIndex(int index, boolean forward) {
        if (forward) {
            return index == (internal.length - 1) ? 0 : (index + 1);
        }
        return index == 0 ? (internal.length - 1) : (index - 1);
    }

    private T remove(boolean fromHead, boolean throwsException) {
        if (isEmpty() && throwsException) {
            throw new NoSuchElementException();
        }
        if (isEmpty() && !throwsException) {
            return null;
        }
        T element;
        if (fromHead) {
            element = (T) internal[head];
            internal[head] = null;
            head = nextIndex(head, true);
        } else {
            tail = nextIndex(tail, false);
            element = (T) internal[tail];
            internal[tail] = null;
        }
        return element;
    }

    private boolean contains(T item, int start, int end) {
        for (int i = start; i < end; i++) {
            if (internal[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    private StringBuilder toString(int start, int end) {
        StringBuilder res = new StringBuilder();
        for (int i = start; i < end; i++) {
            res.append(internal[i]);
            res.append(", ");
        }
        return res;
    }
}