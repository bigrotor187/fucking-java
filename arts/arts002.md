> ## ARTS是什么？
> **Algorithm**：每周至少做一个leetcode的算法题；
> **Review**：阅读并点评至少一篇英文技术文章；
> **Tip/Techni**：学习至少一个技术技巧；
> **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm
**876. Middle of the Linked List**
> Given a non-empty, singly linked list with head node head, return a middle node of linked list.<br>
> If there are two middle nodes, return the second middle node.

**Example 1**

> Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

**Example 2**
> Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

**note**
>The number of nodes in the given list will be between 1 and 100.

**解答**

这个题目不难，这是一道典型的单链表反转的题目，但是这里有一点需要注意一下，就是当有连个中间结点的时候，按要求返回的是后面一个，稍一不小心返回的是前面一个，提交就会不通过，虽然返回的也是中间结点，但不符合题目要求，所以这是一个小小的坑，需要注意。

这里，如果我们按常规的方法的话，想到的肯定是先遍历一遍链表获取链表的长度 n，然后再重新遍历一遍链表找到中间结点。但是，这样子性能会很低，开销很大，时间复杂度会是 O(n) + O(n/2)。

所以，我们可以想到这一类题目惯用的「快慢指针」的方法来解答，因为快慢指针有一个很重要的性质：`慢指针走的长度等于快、慢指针之间的距离`。我们设置慢指针每次`走一步`，快指针每次`走两步`，这样，当快指针遍历到链表尾时，慢指针正好是中间结点。但是，这里需要注意，当结点个数为`奇数`个的的时候，这时候慢指针正好是中间结点；而结点个数为`偶数`个的时候，中间结点有两个，这时候慢指针指向的是`前一个中间结点`，而题目要求返回的是后一个中间结点，所以我们需要判断一下再返回。多的就不说了，`Talk is cheap, show you the code`。

```swift
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //fast.next 不为 null，说明有偶数个结点，此时的 slow 指向前一个中间结点
        if (fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }
}
```

## Review

这周在 Medium、DZone 等平台多多少少看了几篇技术文章，这里暂且选一篇来谈一谈吧。今天要谈的这篇文章是一篇关于 Java 异常的文章，同时也是一篇面试类的文章，不过说实在的，这篇文章虽然是作者总结的关于 Java 异常的面试题，但其实可以说是很详尽了，几乎囊括了 Java 异常的方方面面。

文中一种整理了 21 个面试中经常遇到的 Java 异常的题目，并且按照问题的先后顺序依次展开，给出了一些基本的、详细的、亦或是思考性的「参考答案」，其中有些问题的参考答案中又给我们做了「引路人」，正如耗子叔专栏中一样，让我们自己到源头找水源，让你发现更大的桃花源。

Java 面试中基本都少不了异常这块，看了这篇文章会对异常有个更系统的了解和认知。看了这篇文章突然觉得以前所了解的异常基本就停留在了所谓 `try ... catch` 这些表层了，相信看了这篇文章，对于 Java 异常这块会有个更全面的认识，或者说是开开眼界哈哈（`大神请忽视这条`）。

文章的链接是 《[Java Exceptions Handling Interview Questions and Answers](https://dzone.com/articles/java-exception-handling-interview-questions-and-an-1)》，有兴趣建议可以看一看。
<br>

## Tip/Techni
技术技巧谈不上吧，因为数据结构与算法这块确实很薄弱，所以这周主要是继续学了和巩固了一下链表的一些操作：链表的反转、合并两个有序链表、判断链表是否有环、求出链表倒数第 k 个值等，以及二分查找、跳表等数据结构的知识。

其中，在学习跳表这一块的时候，知道了 redis 之所以用跳表来实现（严格来讲，也用到了散列表），而不用红黑树来实现，主要是因为总体上红黑树的效率没有跳表高。虽然对于`插入、删除、查找以及迭代输出有序序列`这几个操作而言，效率是一样的，但是对于按照区间查找数据而言，跳表效率更高。

当然，还有另外一个原因是因为跳表的代码相对于红黑树而言更容易写，这就意味着代码更容易读，更容易维护。


<br>

## Share

这几天在 Medium 上看到一篇有点意思的文章《[Goodbye, Object Oriented Programming](https://medium.com/@cscalfani/goodbye-object-oriented-programming-a59cda4c0e53)》，这篇文章咋一看有点标题党的感觉，作者是一位有着多年面向对象编程经验的开发者，文中开始就谈到了面向对象的三个主要特征：`继承、封装、多态`，这三个特征可谓是面向对象编程语言的优势。但文中作者对于面向对象编程的思考值得我们好好体会一番。

文中提到了三个非常有意思的观点，作者先后阐述了`继承是面向堕落的第一个原因、封装是面向对象堕落的第二原因、多态是面向对象堕落的第三个原因`，我想平时谈论面向对象的三个特征的时候都会觉得这是面向对象原因的三大优势，面向对象编程带来了极大的方便，虽然偶尔还是会有些缺点和不足，但还是会觉得优点远远大于不足。

文中对这三点都做了非常详细有力的阐述，有些不是很看得懂，但文章可以说是非常精彩了，在文章最后作者极力推荐函数式编程，这有点意思。这篇文章在 Medium 上也很热门，有兴趣可以去看看。

