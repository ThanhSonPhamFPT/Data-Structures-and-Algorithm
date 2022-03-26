package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int size;
    public ArrayList(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }
    public ArrayList(int initialCapacity){
        this.elements = new Object[initialCapacity];
    }
    @Override
    public boolean add(E element) {
        if (this.size == elements.length){
            this.elements = grow();
        }
        this.elements[this.size++] = element;
        return true;
    }
    private Object[] grow(){
        return Arrays.copyOf(this.elements, this.elements.length*2);
    }
    private Object[] shrink(){
        return Arrays.copyOf(this.elements, this.elements.length/2);
    }
    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        insert(index,element);
        return false;
    }
    private void insert(int index, E element){
        if (this.size == this.elements.length){
            this.elements= grow();
        }
        E lastElement = this.getElement(index -1);
        for (int i = this.size - 1;i>index;i--){
            this.elements[i] = this.elements[i-1];
        }
        this.elements[this.size] = lastElement;
        this.elements[index] = element;
        this.size++;
    }
    public void checkIndex(int index){
        if (index<0|| index>=elements.length){
            throw new IndexOutOfBoundsException(String.format("Index out of bound: %d for size:%d", index, this.size));
        }
    }
    private E getElement(int index){
        return (E) this.elements[index];
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        return getElement(index);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = getElement(index);
        this.elements[index] = element;
        return oldElement;
    }
    public int getMaxSize(){
        return this.elements.length;
    }
    @Override
    public E remove(int index) {
        checkIndex(index);
        E element = this.getElement(index);
        this.elements[index] = null;
        shift(index);
        this.size--;
        ensureCapacity();
        return element;
    }
    public void shift(int index){
        for (int i=index;i<this.size-1;i++){
            this.elements[i] = this.elements[i+1];
        }
    }
    public void ensureCapacity(){
        if (this.size < this.elements.length/3){
            this.elements = shrink();
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        for (int i =0;i<this.size;i++){
            if (this.getElement(i).equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element)>=0;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index <size;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
    public E[] toArray(){
        E[] array = (E[]) new Object[size];
        System.arraycopy(elements,0,array,0,size);
        return array;
    }
}
