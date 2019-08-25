package frequency.linkedlist.meduim;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3:
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 图片示例请看 leetcode: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * 进阶：你是否可以不用额外空间解决此题？
 *
 * <p>
 * Definition for singly-linked list.
 *   class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) {
 *          val = x;
 *          next = null;
 *      }
 *  }
 *  </p>
 *
 * @author Rotor
 * @since 2019/8/25 21:04
 */
public class _142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 定义一个新的慢指针
                ListNode newSlow = head;
                while (newSlow != slow) {
                    newSlow = newSlow.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    // 定义一个链表类
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
