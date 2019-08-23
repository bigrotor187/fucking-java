package frequency.linkedlist.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目描述：反转一个链表
 * <p>
 * 示例
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶
 * <p>
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * <pre>
 *  Definition for singly-linked list.
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 *   }
 *  </pre>
 *
 * @author Rotor
 * @since 2019/8/22 22:37
 */
public class _206_ReverseLinkedList {
    /**
     * 迭代解法
     * <p>
     * 思路：在遍历链表时，为了反转链表，我们需要将当前结点的 next 指针指向它的前驱结点，但要注意，因为在单链表中，当前结点没有直接
     * 指向（引用）它的前驱结点，所以在反转之前我们需要先记录当前结点的前驱结点。同时，为了不让链表断掉，还需记录当前节点的后继结点
     * （下一个结点）。
     * <p>
     * 时间复杂度：O(n) 只需遍历一遍链表
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseListByIterate(ListNode head) {
        // 前驱结点
        ListNode prev = null;
        // 当前结点（指向头结点）
        ListNode curr = head;
        // 后继节点，初始化为 null
        ListNode next = null;
        while (curr != null) {
            // 保存当前结点的后继结点
            next = curr.next;
            // 反转当前结点的 next 指针
            curr.next = prev;
            // 继续遍历，前驱结点指向下一个结点
            prev = curr;
            curr = next;
        }
        // curr == null 时，prev 指向链表的最后一个元素，即新链表的第一个元素
        return prev;
    }

    /**
     * 递归解法
     *
     * 思路：把链表分为 head 和 head.next 两部分，为了便于理解，我们可以假设链表只有 head 和 head.next 两个结点，递归的时候，当
     * 链表指向的当前结点为 head.next 时（尾结点），它的 next 指针会指向 NULL，即 head.next.next == null，这时结束递归。 改变
     * head.next 结点的 next 指针的指向，将其指向它的前驱结点 head，即 head.next.next == head。同时，将 head 结点的 next 指针
     * 指向其前驱结点（因为没有，所以也就是指向 NULL），即 head.next == null。
     *
     * 时间复杂度：O(n) 需要递归 n 次
     * 空间复杂度：O(n) 普通递归可能需要 n 次入栈操作（尾递归貌似可以避免这个问题）
     *
     * @param head
     * @return
     */
    public static ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 保存当前结点的next指针（也即它的 next 指针）
        ListNode next = head.next;
        ListNode newHead = reverseListByRecursive(next);
        // 将 next 结点（也即 head.next 结点）的 next 指针指向前驱结点
        next.next = head;
        // 将 head 结点的 next 指针指向前驱结点
        next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(10);
        System.out.println("链表只有一个结点时，输出为：" + reverseListByIterate(list).val);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
