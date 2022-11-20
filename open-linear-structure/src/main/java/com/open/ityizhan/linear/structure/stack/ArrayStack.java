package com.open.ityizhan.linear.structure.stack;

import com.open.ityizhan.linear.structure.array.DynamicArray;

/**
 * @ClassName : ArrayStack
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-11-20 13:36
 * @Version: 1.0.0
 */
public class ArrayStack<E> implements Stack<E> {

    DynamicArray<E> array;

    public ArrayStack(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
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

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
}
