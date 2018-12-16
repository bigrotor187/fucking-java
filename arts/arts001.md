
> ## ARTS是什么？
> - Algorithm：每周至少做一个leetcode的算法题；
> - Review：阅读并点评至少一篇英文技术文章；
>- Tip/Techni：学习至少一个技术技巧；
>- Share：分享一篇有观点和思考的技术文章。

## Algorithm

**26. Remove Duplicates from Sorted Array**

>Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.<br>
>Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

**Example 1**

```swift
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```
**Example 2**                                                                                                                                                                                                                                                                                             

```swift
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```
**解答**

 在一个排好序的数组里面删除重复的元素，首先我们需要知道，对于一个排好序的数组来说， a[n + 1] >= a[n] ，那我们使用两个游标 i 和 j 来处理，假设现在 i = j + 1，如果 a[i] == a[j]，那么递增 i，直到 a[i] != a[j]，这时候设置a[j + 1] = a[i]，同时递增 i 和 j，重复上述过程直到遍历结束。

譬如一个数组为 1，1，2，3，首先 i = 1，j = 0，这时候 a[i] = a[j]，于是递增 i，此时 a[i] =  2，不等于1，所以设置 a[j + 1] = a[i]，也就是 a[1] = a[2]，同时递增 i 和 j 分别为 3 和 1，此时 a[3] != a[1]，所以设置 a[j + 1] = a[i]，也就是 a[2] = a[3]，再次递增，遍历结束。这时候新的数组长度就为 2 + 1，也就是3。

```swift
public class Solution {
	public int removeDuplicates(int a[]) {
		if(a.length == 0) {
			return 0;
		}
		
		int j = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[j] != a[i]) {
				a[++j] = a[i];
			}
		}
		return j + 1;
	}

}
```

<br>

## Review
《[How does a HashMap work in JAVA](http://coding-geek.com/how-does-a-hashmap-work-in-java/)》这篇文章看成是经典中的经典了，逻辑清晰，讲解更是精辟，虽然没有上一堆代码带你一步步去读源码，但并不影响它的经典性。我想，多数程序员或多或少都会看过或者了解过 HashMap 的源码，这篇文章中，作者从以下几个方面一次展开，为我们慢慢铺开 HashMap 的清明上河图，我想，如果多度几遍，肯定会有不少收获。

 1. 内部存储器
 2. 自动扩容
 3. 线程安全
 4. 键的不变性
 5. Java 8 中的改进
 6. 内存开销
 7. 性能问题
 8. 结论
 
<br>

## Tip
这周主要跟着王争老师的《数据结构与算法之美》学习了冒泡排序、插入排序、归并排序、快速排序以及线性排序和排序的优化。这些排序基本以前也都学过，也都写过相应的代码，现在再学一遍算是印象更加深刻吧。经过这些学习，我发现理解特别重要，以前学的因为不经常写很容易就忘了，少练是一方面，但也间接说明了学的时候没有好好的去理解这些排序的核心思想或者说是原理，所以才会那么容易学了就忘。

<br>

## Share
今天要分享的这篇文章其实几天之前就看了，是一位法国的编程怪才写的，反复读了几遍，一方面可能是英文不太好，需要通读几遍；另一方面，这篇文章我觉得确实写得很经典，值得每一个程序员去思考，所以有种「爱不释手」的感觉。

这篇文章的题目是 《[the best programming language](http://coding-geek.com/the-best-programming-language/)》，翻译过来就是《最好的编程语言》。单看题目，你可能觉得又是一篇侃大山、立山头的文章，其实并不是，这篇文章中，作者给了我们一个不一样的视角去辩证看待各门编程语言的优劣势，我们不能单纯地给出结论，断定哪一门语言是最好的，这是不客观的。

在一些分析的基础上，作者发表了自己的观点「没有最好的编程语言，好不好都要取决于具体情况」。作者从以下几个维度去论证什么才是最好的编程语言：

1）你需要性能吗？

从性能的角度来看，如果我们谈论的是「秒」，那么每种语言都能做到；谈论的是「毫秒」，那每门语言的优秀程序员都能做到；谈论的是「微妙」，那基本所有的解释型语言都可以排除在外了（比如 python，尽管这是门很好的语言），当然一个经过良好调优的 JVM 和非常优秀的 Java 程序员可以做到这一点，C# 也是如此；谈论的是「纳秒」？也许只有汇编和 C 能做到。

所以，在大多数情况下，开发人员的技能才是最主要的。

2）什么是生态系统？

比语言本身更重要的是生态系统。比如，如果你经常用 eclipse、IntelliJ IDEA 或者 Visual Studio，你要学会更好地集成这些工具，形成一个良好丰富的生态系统。正所谓「工欲善其事，必先利其器」嘛，好的工具能够让你用的更舒服，提升学习和工作效率。

3）什么是在线帮助？

作者认为学习一门众所周知的编程语言是非常有帮助的，因为一门好的编程语言应该具备好的文档，以及在网上能够很容易找到相应的帮助等等，不然遇到问题很麻烦，站在前人的肩膀上前行往往更好。

...

还有几点就不列举了，在论证完这些方方面面之后，作者也得出了相应的结论：

没有最好的编程语言或者架构；现在最好的也许以后将会不复存在。一门编程语言只是一个工具，最重要的还是你解决问题的能力。

对于这这结论，我高度认同，授之以鱼不如授之以渔，对于程序员来说，最重要的不是你学了多少语言，懂得多少架构，而是你解决问题的能力有多强。
