package algorithms;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<E> {

    // Node đại diện cho một nút trong danh sách
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head; // Nút đầu tiên
    private Node<E> tail; // Nút cuối cùng
    private int size;     // Số lượng phần tử

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // =========================
    // BASIC OPERATIONS
    // =========================

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // =========================
    // ADD
    // =========================

    // Thêm phần tử vào đầu danh sách: O(1)
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);

        newNode.next = head;
        head = newNode;

        // Nếu danh sách ban đầu rỗng
        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // Thêm phần tử vào cuối danh sách: O(1)
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);

        // Nếu danh sách rỗng
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Thêm phần tử tại index: O(n)
    public void insert(int index, E data) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<E> prev = getNode(index - 1);
        Node<E> newNode = new Node<>(data);

        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    // =========================
    // GET
    // =========================

    // Lấy phần tử tại index: O(n)
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).data;
    }

    // Lấy Node tại index: O(n)
    private Node<E> getNode(int index) {
        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    // =========================
    // REMOVE
    // =========================

    // Xóa phần tử đầu tiên: O(1)
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        E removedData = head.data;
        head = head.next;

        size--;

        // Nếu sau khi xóa danh sách rỗng
        if (size == 0) {
            tail = null;
        }

        return removedData;
    }

    // Xóa phần tử cuối cùng: O(n)
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<E> prev = getNode(size - 2);

        E removedData = tail.data;

        prev.next = null;
        tail = prev;

        size--;

        return removedData;
    }

    // Xóa phần tử tại index: O(n)
    public E remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<E> prev = getNode(index - 1);
        Node<E> removedNode = prev.next;

        prev.next = removedNode.next;

        size--;

        return removedNode.data;
    }

    // Xóa lần xuất hiện đầu tiên của value: O(n)
    public boolean removeValue(E value) {
        if (isEmpty()) {
            return false;
        }

        if (Objects.equals(head.data, value)) {
            removeFirst();
            return true;
        }

        Node<E> current = head;

        while (current.next != null) {
            if (Objects.equals(current.next.data, value)) {

                // Nếu node cần xóa là tail
                if (current.next == tail) {
                    tail = current;
                }

                current.next = current.next.next;
                size--;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // =========================
    // SEARCH
    // =========================

    // Kiểm tra có chứa value hay không: O(n)
    public boolean contains(E value) {
        Node<E> current = head;

        while (current != null) {
            if (Objects.equals(current.data, value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Trả về index đầu tiên của value, không có thì -1
    public int indexOf(E value) {
        Node<E> current = head;
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

    // =========================
    // DISPLAY
    // =========================

    public void display() {
        Node<E> current = head;

        System.out.print("HEAD -> ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // =========================
    // INDEX VALIDATION
    // =========================

    // Index dùng để truy cập hoặc xóa: [0, size - 1]
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    // Index dùng để thêm: [0, size]
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);

        list.display();
        // HEAD -> 10 -> 20 -> 30 -> 40 -> NULL

        list.insert(2, 25);
        list.display();
        // HEAD -> 10 -> 20 -> 25 -> 30 -> 40 -> NULL

        System.out.println(list.get(2));
        // 25

        list.remove(2);
        list.display();
        // HEAD -> 10 -> 20 -> 30 -> 40 -> NULL

        list.removeValue(30);
        list.display();
        // HEAD -> 10 -> 20 -> 40 -> NULL

        System.out.println(list.contains(20)); // true
        System.out.println(list.indexOf(40)); // 2
        System.out.println(list.size());      // 3
    }
}
