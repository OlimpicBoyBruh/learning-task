# Java Collections Framework

* Реализовать класс `CustomArrayDequeImpl<T>`, который представляет динамический массив.
* Класс `CustomArrayDequeImpl` реализует интерфейс CustomArrayDeque<T>
* Класс `CustomArrayDequeImpl` может хранить объекты любого типа
* Класс `CustomArrayDequeImpl` может динамически расширяться

## Конструкторы

* `CustomArrayDequeImpl()`;
* `CustomArrayDequeImpl(int capacity)`;
* `CustomArrayDequeImpl(Collection<T> c)`;

# Критерии приемки

1. Создать ветку `feature/customDeque` от `develop`
2. Написать реализацию класса `CustomArrayDequeImpl`
3. Предоставить на проверку Pull Request из ветки `feature/customDeque` в ветку develop
4. Каждый публичный метод класса CustomArrayDequeImpl должен быть покрыт unit тестом по возможности
5. !!! Вносить правки в интерфейс CustomArrayDequeImpl<T> нельзя