package com.open.ityizhan.linear.structure.array;

/**
 * @ClassName : Array
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-11-19 16:39
 * @Version: 1.0.0
 */
public class GenericArray<E> {

    private E[] data;

    private int size;

    // 这里其实可以不用维护capacity这个变量，它就等于 data.length

    /**
     * 构造一个容量为capacity的Array类
     *
     * @param capacity 容量
     */
    public GenericArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认创建的数组容量为 10
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前面添加一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在索引为index的位置插入一个元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        // 可以简化为 : System.arraycopy(data, index, data, index + 1, size - index);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index元素的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E temp = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return temp;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
