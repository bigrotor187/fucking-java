package com.java.yxsi.algonrithm.array;

/**
 * @author Rotor
 * @date 2019/7/14 20:20
 */
public class Array {

    // 定义整型数组 data 保存数据
    public int data[];
    // 定义数组长度
    private int n;
    // 定义数组中实际的个数
    private int count;

    // 构造方法，定义数组大小
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0; // 一开始一个数都没有，所以实际个数为 0
    }

    // 根据索引，找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    // 插入元素：头部插入，尾部插入
    public boolean insert(int index, int value) {
        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        // 如果数组还没满，就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        // 位置合法
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1]; // 将数据往后移动一位
        }
        data[index] = value;
        count ++;
        return true;
    }

    // 根据索引，删除数组中元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        // 从删除位置开始，将后面数据往前移动一位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    // 打印数组元素
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
    }
}
