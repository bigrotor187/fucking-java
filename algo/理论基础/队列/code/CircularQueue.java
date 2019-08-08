package com.java.rotor.algonrithm.queue;

/**
 * @author Rotor
 * @date 2019/7/16 23:31
 *
 * 循环队列
 */
public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    private CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    private boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == 0) {
            System.out.println("队列满了");
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail，那么表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    private void printAll() {
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(8);
        for (int i = 1; i < 8; i++) {
            circularQueue.enqueue("hello" + i);
        }
        circularQueue.printAll();
        circularQueue.enqueue("world"); // 此时队列已满，再入队时会提示队列已经满了
    }
}