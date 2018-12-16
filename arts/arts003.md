> ## ARTS是什么？
> **Algorithm**：每周至少做一个leetcode的算法题；
> **Review**：阅读并点评至少一篇英文技术文章；
> **Tip/Techni**：学习至少一个技术技巧；
> **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm
**206. Reverse Linked List**


**Example**

> 
> Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL


**解答**

具体就不分析了，注释写在代码里面了。单链表的翻转也不难，一般有两种方式，一种是循环遍历的方式，还有一种是递归的方式。不过不同的是，通过循环遍历的方式翻转链表，是从前往后遍历，不断改变结点的 next 指针的指向。而递归的方式是，将链表分为两部分，head 和 rest，然后不断递归到链表尾，之后才开始从后往前翻转链表的 next 指针的指向。

***递归方式***
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
    	//链表为空，返回 null
        if (head == null) {
            return null;
        }
        //链表只有一个结点，即头结点，则直接返回
        if (head.next == null) {
        	return head;
        }
        //将链表分成 head 和 rest 两部分
        ListNode rest = head.next;
        //断开 head 与 rest 的连接，否则会形成环
        head.next = null;
        //翻转 rest 部分链表
        ListNode reverseRest = reverse(rest);
        //连接链表的两部分，head 和 rest
        rest = head;
        return reverseRest;
    }
}
```
***非递归方式***
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
       ListNode prev = null; //前驱结点
       ListNode curr = head; //当前结点
       ListNode next = null; //后继结点
       //链表不为空或者不是链表尾时继续遍历
       while (curr != null && curr.next != null) {
			next = curr.next; //先保存当前结点的下一个结点
			curr.next = prev; // 当前结点的指针域指向前驱结点
			prev = curr; //继续遍历，此时前驱结点往后移动，指向当前结点
			curr = next; //当前结点往后移动，指向后继结点
	   }
		head = curr; //改变头结点的指向，此时头结点指向链表尾
		return head;
    }
}
```

## Review
分享一篇关于 Lambdas 和 FP（Functional Programming，函数式编程）的文章《[Lambdas are not functional programming](https://medium.com/@johnmcclean/lambdas-are-not-functional-programming-63533ce2eb74)》，这篇文章开头作者就指出了 Java 中不存在函数式编程，仅仅只是使用 Lambda expressions（Lambda 表达式）而已，这并不意味着正在做函数式编程。

接下来作者从多个角度、多个维度进行论证说明。首先，列举了 FP 的几个特征：

 - 延迟加载，这是 FP 的核心内容
 - 延迟加载和性能，这里指出了延迟加载可以可以性能，并给出了 Haskell 在 wiki 上给出的一段关于`延迟加载`和`性能`的引用说明。

> Laziness can be a useful tool for improving performance, but more often than not it reduces performance by adding a constant overhead to everything. Because of laziness, the compiler can’t evaluate a function argument and pass the value to the function, it has to record the expression in the heap in a suspension (or thunk) in case it is evaluated later. Storing and evaluating suspensions is costly, and unnecessary if the expression was going to be evaluated anyway.

 - 功能组成，这是函数式编程的重要组成部分
 - 不可变性，这同样是函数式编程的重要特征之一，很多语言默认都是支持不可变性的
 - 编译时正确性，函数式编程能够帮助我们摆脱导致运行时错误的坏习惯
 - 等等

文章的最后，作者指出了面向对象和函数式编程之间并没有冲突，比如可以是面向对象的同时，仍然采用驱动功能范例优势的核心约束。
<br>

## Tip/Techni

Spring Boot 也用了一段时间了，之前是直接上手公司的项目，也仅仅局限于会用的阶段，这周购买的《Spring Boot 实战》到手，重新再好好学习和认识下 Spring Boot。对 Spring boot 现在有了一个更系统的认识，知道了 Spring Boot 最重要的四个核心是：

 - 自动配置：针对很多 Spring 应用常见的应用功能，Spring Boot 能自动提供相关配置。
 - 起步依赖：告诉 Spring Boot 需要什么功能，它就能引入需要的库。
 - 命令行界面：这是 Spring Boot 的可选特性，借此只需写代码就能完成完整的应用程序，无需传统构建项目。
 - Actuator：让你能够深入运行中的 Spring Boot 应用程序，一探究竟。

学习了解了 Spring Boot CLI 的几种安装方式。

 - [ ] 用下载的分发包进行安装
 - [ ] 用 Groovy Environment Manager 进行安装
 - [ ] 通过 OS X Homebrew 进行安装
 - [ ] 使用 MacPorts 进行安装
<br>

## Share

这周看了不少英文文章，很多都写得很棒。不过今天要分享的是耗子叔之前在专栏中所推荐的《[Teach Yourself Programming in Ten Years](http://norvig.com/21-days.html)》。从事编程的同学读完这边文章应该还是会比较有感触的。

我们经常看到市面上的一些什么 21 天从从入门到精通 xxx 编程语言的书籍，但现实是真的 21 天就能从入门到精通吗？显然不是，21 天能够简单入门都不错了，精通更是谈不上了。想必我们都听过「一万小时定律」，这是作家格拉德威尔在《异类》一书中所给出的定律，具体是：`人们眼中的天才之所以卓越非凡，并非天资超人一等，而是付出了持续不断的努力。1万小时的锤炼是任何人从平凡变成世界级大师的必要条件。`当然，这里 1 万小时并不是指具体的数字，主要是想表达如果想要在某一领域中学有所成，要学到精通，肯定是需要投入大量时间的。

在这篇文章中，作者的观点很棒，这里稍微用蹩脚的英文总结几条吧，具体的建议看一下原文（可能需要科学上网），非常值得一读。

 - 做好用十年时间教会自己编程、投入 10000 小时的心理准备
 - 先激发自己学习编程的兴趣，毕竟兴趣是最好的老师
 - 动手写代码，学习编程最好的方式是边学边练
 - 与其他的程序员交流，阅读别人的优秀源码，这比任何的书籍或者培训课程都重要
 - 与其他程序员一起开发项目
 - 至少学习几门编程语言

     ...

精彩之处实在太多，感觉全文都很精彩，强烈建议读一读原文。

