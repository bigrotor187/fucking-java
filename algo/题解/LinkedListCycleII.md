# [Linked List Cycle II][title]

## Description

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

**Example 1:**

```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。

```

**Example 2:**

```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```

**Example 3:**

```
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```

**Tags:** LinkedList


## 思路 0（双指针法）

题意是给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。对于这道题，我们可以通过双指针法来解决，
定义一个快指针 fast 和一个慢指针 slow，其中快指针每次走两步，而慢指针每次走一步。如果链表有环，那么快指针最终一定会追上慢指针，
也就是说，快慢指针一定会在链表的某处相遇。首先先判断链表是否有环，如果链表没环，则返回 null，反之说明链表有环。当链表有环时，我们可以做出如下假设：

- 链表头结点到环的入口点的距离为 x1；
- 环的入口点到快慢指针相遇点的距离为 x2；
- 快慢指针的相遇点到环的入口点的距离为 x3。

![](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E9%93%BE%E8%A1%A8%E6%9C%89%E7%8E%AFII.png)

当快慢指针第一次在环中某处相遇时，可以得出快慢、指针走过的距离分别为：`x1 + x2 + x3 + x2`、`x1 + x2`，因为快指针每次走 `2` 步，而慢指针每次走
`1` 步，所以两者走过的距离存在这样的关系：`x1 + x2 + x3 + x2 = 2 * (x1 + x2) ==> x1 = x3`。也就是说，头结点到环的入口点的距离 `x1` 等于
快慢指针相遇点到环入口点的距离。

所以，当快慢指针相遇时，这时我们可以定义一个新的慢指针 `newSlow`，从链表头开始走，每次也只走 `1` 步，而慢指针 `slow` 继续从相遇点往前走，当
`newSlow` 走到环的入口点（即走的距离为 x1）时，慢指针 `slow` 也正好走到换的入口点（走的距离为 x3），因为 `x1 = x3`，所以两者肯定都是走到环的入口点。

**时间复杂度：** O(n) 
<br> 
**空间复杂度：** O(1) 只需要临时存储快慢指针等几个指针的内存，因此只需常数级别的空间复杂度

```java
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

```


## 结语

如果你同我一样想要征服数据结构与算法、想要刷 LeetCode，欢迎关注我 GitHub 上的 LeetCode 题解：[awesome-java-notes][ajl]



[title]: https://leetcode.com/problems/linked-list-cycle-ii/
[ajl]: https://github.com/bigrotor187/awesome-java-notes
