package com.open.ityizhan.linear.structure.queue;

/**
 * @ClassName : Deque
 * @Description : 双端队列，支持队首队尾插入和删除元素
 * @Author : 林俊豪
 * @Date: 2022-11-22 13:34
 * @Version: 1.0.0
 */
public class Deque<E> {

    private E[] data;

    private int front, tail, size;

    public Deque(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
    }

    public Deque() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队尾插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new IllegalArgumentException("xxx");
        }

        tail = tail == 0 ? data.length - 1 : tail - 1;
        E temp = data[tail];
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }
        return temp;
    }

    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("aaa");
        }

        E temp = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }
        return temp;
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

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) dq.addLast(i);
            else dq.addFront(i);
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for (int i = 0; !dq.isEmpty(); i++) {
            if (i % 2 == 0) dq.removeFront();
            else dq.removeLast();
            System.out.println(dq);
        }
    }

}
