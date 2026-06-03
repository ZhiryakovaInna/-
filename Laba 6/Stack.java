package Laba_6.Task_2;
import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        // В Java нельзя создавать массивы обобщенных типов напрямую,
        // поэтому создаем массив Object и приводим его к T[]
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен");
        }
        data[size] = element;
        size++;
    }

    // Метод для удаления и возврата верхнего элемента
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }

    // Метод для получения верхнего элемента без его удаления
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);   // Кладём 1 в стек
        stack.push(2);
        stack.push(3);

        System.out.println("Извлечен (pop): " + stack.pop());
        System.out.println("Верхний элемент (peek): " + stack.peek());

        stack.push(4);
        System.out.println("Извлечен (pop): " + stack.pop());
        System.out.println("Извлечен (pop): " + stack.pop());
    }
}