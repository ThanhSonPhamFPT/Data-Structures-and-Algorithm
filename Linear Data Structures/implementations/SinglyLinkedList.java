package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    Node<E> head, tail;
    int size;
    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
        public Node(E element){
            this(element,null);
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node(element);
        if (head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node(element);
        if (head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();
        E data = head.element;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();
        E data = tail.element;
        Node<E> current = head;
        while(current.next!=tail){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
        return data;
    }
    public String toString(){
        Node<E> current = head;
        StringBuilder result = new StringBuilder();
        while(current!=null){
            result.append(current.element+ "\n");
            current = current.next;
        }
        return result.toString();
    }
    @Override
    public E getFirst() {
        ensureNonEmpty();
        return head.element;
    }

    private void ensureNonEmpty() {
        if (size ==0) throw new IllegalStateException("Linklist is empty");
    }

    @Override
    public E getLast() {
        return tail.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
