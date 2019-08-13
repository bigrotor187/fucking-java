package frequency.linkedlist.easy;

/**
 * <p>
 *
 *  题目描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *  示例：
 *
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 *
 * </p>
 *
 * <p>
 *
 *  Definition for singly-linked list.
 *  public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *  }
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/13 22:49
 */
public class _21_MergeTwoSortedLists {

    /**
     * 递归解法
     *
     * 解题思路：可以通过递归的方式实现，不需要构造新链表。当 l1 的值小于 l2 的值时，将 l1.next 与排序好的链表头相连，反之，
     * 将 l2.next 与排序好的链表头相连。换言之，两个链表头部较小的一个与剩下元素合并操作的结果进行合并。
     * 1）终止条件：当链表 l1 为空或 l2 为空时结束递归
     * 2）返回值：每一层调用都返回已经排好序的链表头
     *
     * 时间复杂度：O(m+n)
     * 因为每递归一次，就会去掉 l1 或 l2 的头元素，直到其中一条链表为空，方法中只会遍历每个元素一次，所以
     * 时间复杂度与合并后链表长度呈线性关系。
     *
     * 空间复杂度：O(m+n)
     * 方法递归结束时已经遍历过 l1 和 l2 中的元素，需要 m+n 个栈帧，所以会消耗 O(m+n)的空间复杂度。
     *
     * @param l1 链表 l1
     * @param l2 链表 l2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
