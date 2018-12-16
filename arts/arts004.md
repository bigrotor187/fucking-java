> ## ARTS是什么？
> - Algorithm：每周至少做一个leetcode的算法题；
> - Review：阅读并点评至少一篇英文技术文章；
>- Tip/Techni：学习至少一个技术技巧；
>- Share：分享一篇有观点和思考的技术文章。

<br>


## Algorithm
**530. Minimum Absolute Difference in BST**

**题目描述**
> Given a binary search tree with non-negative values, find the minimum
> absolute difference between values of any two nodes.

**Example**
> Input:
>&nbsp;  1
>    &nbsp; &nbsp;  \\
>  &nbsp; &nbsp; &nbsp; 3
>  &nbsp; &nbsp; &nbsp;  /
>   &nbsp; &nbsp; 2<br>
>   Output:
1<br>
Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).<br>
Note: There are at least two nodes in this BST.

<br>

**解答**

二叉查找树（BST）中有一条很重要的特性，就是通过`中序遍历`得到的结果是有序数组。题目要求是查找任意两个节点之间差的最小绝对值，在 BST 中，那就是对每个节点的值找到与其最近的节点的值，然后求差。如果是一个有序数组的话，这样的最小值就是按顺序，后一个元素与前一个元素的差的最小值了。正好对于 BST 中序遍历时，求当前节点与前一个节点的差，最终得到的差的最小值即为所求。

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
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (prev != null) {
                    result = Math.min(result, node.val - prev);
                }
                prev = node.val;
                root = node.right;
            }
        }
        return result;
    }
}
```


## Review
MVC 想必大家都是很了解了，很多时候这也是面试爱问的，所谓 MVC，也就是 Model-View-Controller 的缩写。今天要分享的是一篇关于 MVC 的文章(需要梯子)《[Does MVC still matter and should you use it?](https://medium.com/@cameron.manavian/does-mvc-still-matter-and-should-you-use-it-3e355b4e09b6)》。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181202160049297.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)

在这篇文章中，对于 MVC 是不是依然很重要，作者从以下几个方面来谈。

 - 在一些编程语言中，MVC 一直很有争议。作者提到在一些编程语言中，根本就不存在 view、model、controller 的概念。
 - 在浏览器（SPAs）中的应用。在浏览器语言层面的应用方面，比如对于经典的 React，在大多数情况了，view 是你的 React 的组件，cotroller 则是没有的，而 model 则是很难准确界定的。所以很多时候，很难分清对应的 model、view、controller 分别指向啥。
 - 在视频游戏方面，作者认为谈论 MVC 是没意义的，是不切实际的。因为在视频游戏方面，你可以在某处拥有一个 model ，比如游戏角色的信息存储在数据库中。也可以拥有一个 controller，比如控制游戏角色或动作的代码，但是这些层面的 MVC 与我们用来 web 开发的 MVC 的完全不一样的。
 - 在服务器端，作者认为传统意义上人们 view 相对应的是 HTML 或者 UI 的组件是不对的，他认为 XML、JSON、CSV 以及其他的文件过滤器都应该被视作 view。通过 GraphQL 和 Falcor，JSON 替换 view，仍然是 MVC。

在文章的最后，作者认为 MVC 仍然是很重要的，因为在很多时候，不管你是否使用 APIs、Web Sockets 这些技术，你仍然还在使用某种形式的 MVC，不管你是否将之称为 MVC，但你仍然使用着它。有条件科学上网的建议看下原文，毕竟英语水平有限，翻译的不一定准确。

<br>

## Tip/Techni
这周工作之外主要学习了散列表、哈希算法以及二叉树等几个数据结构与算法，写了一篇关于树、二叉树和二叉查找树的文章《[树、二叉树、二叉查找树（二叉搜索树）](https://blog.csdn.net/Big_Rotor/article/details/84716113)》简单记录了一下。
<br>

## Share

如何成为一名优秀的软件开发工程师？这样的文章估计大家也没少看，作为程序员，很多工作了一定年限估计都或多或少有思考过这个问题。刚好在　Meduim 上看到一篇《[How to Become a Better Software Developer](https://medium.com/devtrailsio/how-to-become-a-better-software-developer-dd16072c974e)》。在这篇文章中，作者根据自己的一些成功的个人经验，给出了以下几点建议，这里就不翻译了，直接上英文可能比较直观。这篇文章比较长，具体的话建议有条件的看下原文，这篇文章还是值得读一读的。

 - Understand the Process End to End
 - Understand Your Client's Needs
 - Pick the Rights Tools for the Job
 - Experiment Safely
 - Build on the Shoulders of Giants
 - Learn Through Reimplementing
 - Work on How You Work
 - Remove obstacles
 - Focus on the Fundamentals
 - Bonus Tips
 - Share the knowledge
 - Don't blame yourself or others
 - Don't be an asshole
 - Wrapping it up
