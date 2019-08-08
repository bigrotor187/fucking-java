package com.java.rotor.algonrithm.queue;


/**
 * @author Rotor
 * @date 2019/7/16 22:55
 *
 * 用数组实现的队列
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队列头下标，tail 表示队列尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果 tail == n，表示队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    // 优化后的入队操作，将 item 放入队尾。
    // 随着不停的入队、出队操作，head 和 tail 都会持续往后移动，当 tail 移到最右边时，
    // 即使队列有空闲位置，仍然无法再继续入队。
    // 解决办法：出队时无需搬移数据，只需入队时，再集中触发一次数据的搬移工作。
    public boolean enqueueOpt(String item) {
        // tail == n 表示队列末没有空间了
        if (tail == n) {
            // tail == n && head == 0，表示整个队列都满了
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新 head 和 tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail，表示队列为空
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
