package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> implements Iterable<T> {

    // ==========================================
    // 1. NODE CLASS
    // ==========================================

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // ==========================================
    // 2. ATTRIBUTES
    // ==========================================

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // ==========================================
    // 3. CONSTRUCTOR
    // ==========================================

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // ==========================================
    // 4. BASIC METHODS
    // ==========================================

    // Return number of elements
    public int size() {
        return size;
    }

    // Check whether list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Remove all elements
    public void clear() {
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    // ==========================================
    // 5. INSERT METHODS
    // ==========================================

    // Add element at the beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    // Add element at the end
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Alias for addLast
    public void add(T data) {
        addLast(data);
    }

    // Insert element at a specific index
    public void add(int index, T data) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> previous = getNode(index - 1);
        Node<T> newNode = new Node<>(data);

        newNode.next = previous.next;
        previous.next = newNode;

        size++;
    }

    // ==========================================
    // 6. ACCESS METHODS
    // ==========================================

    // Get first element
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        return head.data;
    }

    // Get last element
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        return tail.data;
    }

    // Get element at specific index
    public T get(int index) {
        checkElementIndex(index);

        return getNode(index).data;
    }

    // Internal method to retrieve a node
    private Node<T> getNode(int index) {
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    // ==========================================
    // 7. UPDATE METHODS
    // ==========================================

    // Replace element at specific index
    public T set(int index, T data) {
        checkElementIndex(index);

        Node<T> current = getNode(index);

        T oldData = current.data;
        current.data = data;

        return oldData;
    }

    // ==========================================
    // 8. REMOVE METHODS
    // ==========================================

    // Remove first element
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T removedData = head.data;

        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return removedData;
    }

    // Remove last element
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<T> previous = getNode(size - 2);

        T removedData = tail.data;

        previous.next = null;
        tail = previous;

        size--;

        return removedData;
    }

    // Remove element at specific index
    public T remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> previous = getNode(index - 1);
        Node<T> removedNode = previous.next;

        previous.next = removedNode.next;

        T removedData = removedNode.data;

        removedNode.next = null;
        size--;

        return removedData;
    }

    // Remove first occurrence of a value
    public boolean remove(Object value) {
        if (isEmpty()) {
            return false;
        }

        if (Objects.equals(head.data, value)) {
            removeFirst();
            return true;
        }

        Node<T> previous = head;
        Node<T> current = head.next;

        while (current != null) {
            if (Objects.equals(current.data, value)) {
                previous.next = current.next;

                if (current == tail) {
                    tail = previous;
                }

                current.next = null;
                size--;

                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    // ==========================================
    // 9. SEARCH METHODS
    // ==========================================

    // Find index of first occurrence
    public int indexOf(Object value) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (Objects.equals(current.data, value)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    // Find index of last occurrence
    public int lastIndexOf(Object value) {
        Node<T> current = head;
        int index = 0;
        int result = -1;

        while (current != null) {
            if (Objects.equals(current.data, value)) {
                result = index;
            }

            current = current.next;
            index++;
        }

        return result;
    }

    // Check whether list contains a value
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    // ==========================================
    // 10. REVERSE
    // ==========================================

    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;

        tail = head;

        while (current != null) {
            Node<T> next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;
    }

    // ==========================================
    // 11. CONVERT TO ARRAY
    // ==========================================

    public Object[] toArray() {
        Object[] array = new Object[size];

        Node<T> current = head;

        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    // ==========================================
    // 12. VALIDATE INDEX
    // ==========================================

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    // ==========================================
    // 13. ITERATOR
    // ==========================================

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = current.data;
                current = current.next;

                return data;
            }
        };
    }

    // ==========================================
    // 14. PRINT
    // ==========================================

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[");

        Node<T> current = head;

        while (current != null) {
            result.append(current.data);

            if (current.next != null) {
                result.append(" -> ");
            }

            current = current.next;
        }

        result.append("]");

        return result.toString();
    }
}
