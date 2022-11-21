package com.open.ityizhan.linear.structure.queue;

import java.util.Arrays;

/**
 * @ClassName : CyclicQueue
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-11-21 08:05
 * @Version: 1.0.0
 */
public class CyclicQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public CyclicQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public CyclicQueue() {
        this(10);
    }


    @Override

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E temp = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return temp;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        builder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");

        return builder.toString();
    }
}
