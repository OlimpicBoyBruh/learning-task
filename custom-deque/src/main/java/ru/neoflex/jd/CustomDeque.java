package ru.neoflex.jd;

/**
 * CustomDeque представляет собой интерфейс для двусторонней очереди (Deque),
 * который поддерживает операции добавления, удаления и доступа к элементам
 * как с начала, так и с конца.
 *
 * @param <T> тип элементов, хранящихся в Deque
 */
public interface CustomDeque<T> {

    /**
     * Возвращает количество элементов в Deque.
     *
     * @return количество элементов в Deque
     */
    int size();

    /**
     * Проверяет, пуст ли Deque.
     *
     * @return true, если Deque пуст, иначе false
     */
    boolean isEmpty();

    /**
     * Добавляет элемент в конец Deque.
     *
     * @param element элемент, который нужно добавить
     * @return true, если элемент был успешно добавлен
     * @throws IllegalStateException если нет доступного места
     */
    boolean add(T element);

    /**
     * Добавляет элемент в начало Deque.
     *
     * @param element элемент, который нужно добавить
     */
    void addFirst(T element);

    /**
     * Добавляет элемент в конец Deque.
     *
     * @param element элемент, который нужно добавить
     */
    void addLast(T element);

    /**
     * Добавляет элемент в конец Deque и возвращает true, если добавление прошло успешно.
     *
     * @param element элемент, который нужно добавить
     * @return true, если элемент был успешно добавлен
     */
    boolean offer(T element);

    /**
     * Добавляет элемент в начало Deque и возвращает true, если добавление прошло успешно.
     *
     * @param element элемент, который нужно добавить
     * @return true, если элемент был успешно добавлен
     */
    boolean offerFirst(T element);

    /**
     * Добавляет элемент в конец Deque и возвращает true, если добавление прошло успешно.
     *
     * @param element элемент, который нужно добавить
     * @return true, если элемент был успешно добавлен
     */
    boolean offerLast(T element);

    /**
     * Добавляет элемент в начало Deque.
     *
     * @param element элемент, который нужно добавить
     */
    void push(T element);

    /**
     * Удаляет и возвращает элемент из начала Deque.
     *
     * @return удаленный элемент из начала Deque
     */
    T pop();

    /**
     * Удаляет элемент из начала Deque.
     *
     * @return удаленный элемент из начала Deque
     */
    T removeFirst();

    /**
     * Удаляет элемент из конца Deque.
     *
     * @return удаленный элемент из конца Deque
     */
    T removeLast();

    /**
     * Извлекает и удаляет голову очереди (первый элемент) из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return первый элемент из Deque или null, если Deque пуст
     */
    T poll();

    /**
     * Извлекает и удаляет первый элемент из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return первый элемент из Deque или null, если Deque пуст
     */
    T pollFirst();

    /**
     * Извлекает и удаляет последний элемент из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return последний элемент из Deque или null, если Deque пуст
     */
    T pollLast();

    /**
     * Извлекает, но не удаляет голову очереди (первый элемент) из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return первый элемент из Deque или null, если Deque пуст
     */
    T peek();

    /**
     * Извлекает, но не удаляет первый элемент из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return первый элемент из Deque или null, если Deque пуст
     */
    T peekFirst();

    /**
     * Проверяет, существует ли указанный элемент в Deque.
     *
     * @param item элемент для проверки
     * @return true, если элемент существует в Deque, иначе false
     */
    boolean contains(T item);

    /**
     * Извлекает, но не удаляет последний элемент из Deque,
     * или возвращает null, если Deque пуст.
     *
     * @return последний элемент из Deque или null, если Deque пуст
     */
    T peekLast();

}
