package com.open.ityizhan.linear.structure.queue;

import com.open.ityizhan.linear.structure.array.DynamicArray;

/**
 * 基于数组实现的队列
 *
 * @ClassName : ArrayQueue
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-11-20 14:48
 * @Version: 1.0.0
 */
public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }
}
