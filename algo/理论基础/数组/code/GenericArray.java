package com.java.yxsi.algonrithm.array;

/**
 * @author Rotor
 * @date 2019/7/14 21:06
 */
public class GenericArray<T> {
    private T[] data; // 定义一个泛型数组 data 保存数据
    private int size;

    // 根据传入容量，构造 Array
    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造方法，默认数组容量为 10
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看数组是否包含元素 e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标，未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素 e，时间复杂度为 O(m+n)
    public void add(int index, T e) {
        checkIndex(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的 2 倍
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndexForRemove(index);

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        /**
         * 缩容：数组元素个数为当前容量的 1/4 时，缩容为当前容量的一半。
         * 为什么缩容不是 1/2 时缩容呢？
         * 因为：如果在 1/2 时缩容，会导致在扩容的临界点添加、删除一个元素都是 O(n) 复杂度的情况（临界点
         * 添加一个元素，导致扩容为 2 倍，此时删除刚添加的元素，又会缩容为 1/2）。
         */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 重写数组打印时的展示形式，只需要重写 String 方法
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    // 扩容方法,时间复杂度 O(n)
    public void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData; // 将扩容后的数组赋值为 data 数组
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    public void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }

    // 打印数组
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericArray array = new GenericArray(4);
        for (int i = 0; i < array.getCapacity(); i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        System.out.println("数组容量为：" + array.getCapacity());
        System.out.println("size为：" + array.count());

        for (int i = 0; i < array.count(); i++) {
            array.remove(i);
        }
        array.remove(0);
        System.out.println("size为：" + array.count());

        System.out.println("数组容量为：" + array.getCapacity());

        System.out.println(array);
    }
}
