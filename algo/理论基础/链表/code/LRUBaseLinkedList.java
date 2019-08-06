package com.java.yxsi.algonrithm.linkedlist;

import javax.net.ssl.SNIHostName;
import java.util.Scanner;

/**
 * <p>
 *
 *  基于单链表实现的 LRU（最近最少使用） 算法
 *
 *  解题思路：
 *
 *  可以维护一个有序的单链表，越靠近尾部的结点是越早之前访问的。当一个新数据被访问时，从链表头开始顺序遍历链表。
 *  1、如果此数据之前已经被缓存在链表中，则遍历得到这个数据对应的结点，并将其从原来位置中删除，然后再插入到链表的头部；
 *  2、如果此数据没有在缓存链表中，可以分为两种情况：
 *      如果此时缓存未满，则将此结点直接插入链表的头部；
 *      如果此时缓存已满，则删除链表尾结点，将新的数据结点插入链表头部。
 *
 * 时间复杂度：O(n)
 *
 * 不管缓存是否已满，都需要遍历一遍链表。
 *
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/4 22:35
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 往链表中添加元素
     *
     * @param data
     */
    public void add(T data) {
        // 先找到要添加元素的前驱结点（如果要添加元素原本存在，并且链表中不只一个结点时）
        SNode preNode = findPreNode(data);

        // 链表中已经存在，删除原数据，然后插入链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        // 链表中不存在
        } else {
            if (length >= this.capacity) {
                // 删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除链表尾部的结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        //SNode tmp = ptr.getNext(); // 创建一个临时结点存储链表尾结点
        ptr.setNext(null);
        //tmp = null; // 回收临时结点的内存空间
        length--;
    }

    /**
     * 在链表首插入结点
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 删除前驱结点 preNode 的下一个结点，也就是删除指定结点
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode tmp = preNode.getNext(); // 保存指向下一个结点（要删除结点）的链接
        preNode.setNext(tmp.getNext());
        tmp = null; // 回收临时结点 tmp
        length--;
    }

    /**
     * 查找并返回指定元素的前一个结点
     *
     * @param data 指定元素的值
     * @return 指定元素
     */
    private SNode findPreNode(T data) {
        SNode node = headNode; // 保存指向头结点的链接
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    /**
     * 定义单链表的数据结构
     */
    public class SNode<T> {

        /**
         * 数据域
         */
        private T element;

        /**
         * 后继指针
         */
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.next());
            list.printAll();
        }
    }
}
