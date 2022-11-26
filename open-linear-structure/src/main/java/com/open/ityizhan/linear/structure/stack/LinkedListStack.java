package com.open.ityizhan.linear.structure.stack;

import com.open.ityizhan.linear.structure.linked.LinkedList;

/**
 * @ClassName : LinkedListStack
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-11-26 10:14
 * @Version: 1.0.0
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
