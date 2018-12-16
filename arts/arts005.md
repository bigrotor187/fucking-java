> ## ARTS是什么？
> - **Algorithm**：每周至少做一个leetcode的算法题；
> - **Review**：阅读并点评至少一篇英文技术文章；
> - **Tip/Techni**：学习至少一个技术技巧；
> - **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm
**230. Kth Smallest Element in a BST(查找二叉查找树中的第 K 个元素)**

**题目描述**

> Given a binary search tree, write a function kthSmallest to find the
> kth smallest element in it.

**Note:**

> Given a binary search tree, write a function kthSmallest to find the
> kth smallest element in it.

**Example**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181210002733733.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)

**解答**

要查找二叉查找树的第 K 个元素，自然而然想到的方法是利用二叉查找树的中序遍历解决，通过中序遍历二叉查找树，可以得到有小到大的有序数组，从而可以得知第 K 个元素。

```swift
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	private int count = 0; // 计数器
	private int val;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }
    
    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        count ++;
        if (count == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
```

## Review
今天要 review 的文章是 Meduim 上的一篇关于软件工程和编程之间的思考的一篇文章，题为《[Software Engineering is different from Programming](https://edgecoders.com/software-engineering-is-different-from-programming-b108c135af26)》。文章的题目直译过来很直白，也就是软件工程不同于编程。其实标题下面还有一个副标题，很有意思，`所有的软件工程师都会编程，但是并不是所有的程序员都会开发软件`。非常的简洁明了，简单粗暴，仔细想想，好像还真是那么一回事。

编程其实相对来说是比较容易的，门槛也不怎么高，所以很多人都会点编程的。但是，知道如何编程并不会让你成为一名软件工程师。就好比说：

 - 每个人都会唱歌（有些人可能五音不全，自己开心就行哈哈），通过唱唱歌来自娱自乐，但并不意味着 TA 们能够出唱片
 - 我们在学校的时候都学习过数学和写作，但那并不会让我们成为数学家和作家（能不能成为当然还是得靠自己）
 - 我们当中的大多数人都能够很容易的就学会烹饪，但是当我们宴请多人吃饭的时候，还是会找专门的厨师来弄
 - 等等
作者通过各种论述无非就是想要说明`简单程序与工程程序差别是非常巨大的`。所以，作为一名软件工程师，要了解要解决的问题是什么并给出相应的解决方案，以及这些解决方案有哪些局限性，有哪些可能的影响和安全隐患。

那么，如何成为一名软件工程师呢？

 - `要有思考解决方案的心态。`要学会从满足需求和解决问题的角度去思考，而不是永远只会想着编码，并不是什么问题都是通编码解决的。
 - `代码质量。`优秀的程序是清晰、可读并且易维护的。
 - `环境和测试。`作为一名软件工程师，在编写程序时，要确保程序能够在不同的环境中或是在资源不同的机器上以及在不同的时区中运行起来。
 - `成本和效率。`在很多情况下，作为一名软件工程师要能够快速解决问题，节约成本。
 -  `可用性。`优秀程序的设计要考虑用户体验，要注重可用性、实用性。
 - `可靠性和安全性。`这点很重要，真正的软件工程师会往往会意识到编写安全可靠的解决方案是他们的职责所在。
 - `拥抱工具。`有句话说得好嘛，工欲善其事必先利其器，说得就是这个理。毋庸置疑，我们需要学会使用很多好的工具，好的工具是可以极大地提升效率的。
 
 那是不是说，只要跟以上几条沾边了你就是所谓的（优秀的）软件工程师了呢？答案是否定的，文章的最后，作者谈到，没有人是能够通过两个月、六个月甚至是一年时间来学通软件工程的，更不可能在所谓的训练营中学习成为软件工程师。毕竟像作者这样一位软件工程的大牛，也是通过 20 多年的不断学习和实践，并且如今还在坚持不断的学习才达到了现在的水平的。

这让我想起了之前在看耗子叔的一篇文章中提到的，要端正学习态度， 要做好不断学习，坚持学习，十年如一日的默默坚持的准备。渍渍渍，历史总是惊人的相似，大佬们的认知好像都异曲同工。说句玩笑话，`一入 IT 深似海嘛`，不多说，扶我起来，还能再战。。

<br>

## Tip/Techni
这周工作比较忙，没有学到很多的技术技巧。工作之余，主要抽空看了《Spring Boot 实战》，还有就是重新回顾、学习了下链表、二叉查找树、栈等数据结构。

工作中，开发项目的时候公司都是直接将 Spring Boot 整合到公司的平台中，封装的比较死，所以对于 Spring Boot 也仅仅局限于会用，对很多的一些原理和细节不是很了解。所以这周工作之余主要在学习 Spring Boot 的一些知识。主要学习了 Spring Boot 的自动配置、起步依赖以及自定义配置、外置配置等。
<br>

## Share

很多时候，当我们想要放弃一件事的时候，都会找借口说什么不合适，在这方面没有天赋等等。正如学习这件事，本身就是反人类的事，很多人想要偷懒不想学习的时候总会找点借口，自己不适合学这些东西，在这些地方没有天赋。想想，是不是这样?就拿编程来说吧，肯定有不少人学习编程的过程中都是半途而废的状态，学着学着就学不下去了，是真的学不下去了吗？未必，可能真有极少部分的人确实不适合，但是放弃的这部分人中，大部分都是在为自己的懒找借口罢了。理由无非就是自己没有编程的天赋，在编程上面没有激情，没有耐心等等，试想，就算换成其他的真就有天赋了？就有激情了？未必，不过是为自己的不愿努力编织一个理由而已。

《[Programming Doesn’t Require Talent or Even Passion](https://medium.com/@WordcorpGlobal/programming-doesnt-require-talent-or-even-passion-11422270e1e4)》这篇文章中的观点挺不错的，值得好好思考一番。文中通过 PHP 之父 Rasmus Lerdorf 、Django 之父 Jacob Kaplan-Moss、Rails 之父 David Heinemeier Hansson 等编程界的鬼才、怪才的一些采访或言论，来表达了作者的观点：`编程其实很多时候并不需要天赋，也并不需要激情`。其实仔细想想，是有一定道理的，很多事情其实根本就没轮到拼天赋的时候，只有为之拼尽全力以致无能为力的时候才有资格说放弃，才有资格说不合适，才有资格说在这方面没天赋。不然说实在的，其实就是在为自己的懒找借口，连最基本的努力都做不到，何来轻言放弃呢？

文章的最后，作者提出了几点。

 - 要多尝试多种不同的方法来学习，不要去做一些无畏的担心。
 - 问题常常在于你的学习方式，或者你对学习编程的态度。
 - 永远不要轻言放弃，除非努力拼尽全力仍旧无能为力。
 - 编程不要求天赋，甚至不要求激情。

所以，即使天冷了，少年们该奋斗还是要奋斗啊，生命不息，奋斗不止，别总是连基本的努力都没做到呢就轻言放弃，轻易断言没有天赋！


