package ua.bondarenkojek.homework.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomArrayList<E> implements List<E> {
    private Object[] data;
    private int size;

    public CustomArrayList() {
        data = new Object[10];
    }

    public CustomArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Cannot construct CustomArrayList with negative capacity");
        }
        data = new Object[capacity];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        Object[] tmpData = new Object[size - index];
        for (int i = 0; i < tmpData.length; i++) {
            tmpData[i] = data[index + i];
        }
        data[index] = element;
        for (int i = 0; i < tmpData.length; i++) {
            data[index + 1 + i] = tmpData[i];
        }
        size++;
    }

    @Override
    public E remove(int index) {
        E element = get(index);

        Object[] tmpData = new Object[size - index - 1];
        for (int i = 0; i < tmpData.length; i++) {
            tmpData[i] = data[index + i + 1];
        }

        for (int i = 0; i < tmpData.length; i++) {
            data[index + i] = tmpData[i];
        }
        size--;
        return element;
    }

    private void ensureCapacity(int capacity) {
        if (this.data.length < capacity) {
            Object[] tmpData = new Object[this.data.length * 2];
            for (int i = 0; i < this.data.length; i++) {
                tmpData[i] = this.data[i];
            }
            data = tmpData;
        }
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
