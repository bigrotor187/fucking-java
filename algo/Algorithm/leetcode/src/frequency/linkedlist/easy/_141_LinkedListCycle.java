package frequency.linkedlist.easy;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 说明：图片示例请看 leetcode: https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 进阶：用 O(1)（即，常量）内存解决此问题。
 *
 * <p>
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 * </p>
 *
 * @author Rotor
 * @since 2019/8/14 20:01
 */
public class _141_LinkedListCycle {
    /**
     * 双指针法
     *
     * 解题思路：定义两个指针，分别是快指针fast和慢指针low，其中快指针每次移动两步，而慢指针每次移动一步。
     * 如果链表中有环，那么快慢指针会在某处相遇。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) 因为只需要额外的快慢指针的临时存储空间，所以只需 O(1) 空间复杂度
     *
     * @param head 链表
     * @return 是否链表有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快指针，初始时指向链表头
        ListNode fast = head;
        // 慢指针，初始时指向链表头
        ListNode low = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
        }
        return false;
    }

}
