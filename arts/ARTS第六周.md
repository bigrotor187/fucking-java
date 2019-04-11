> ## ARTS是什么？

> **Algorithm**：每周至少做一个leetcode的算法题；

> **Review**：阅读并点评至少一篇英文技术文章；

> **Tip/Techni**：学习至少一个技术技巧；

> **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm
**744. Find Smallest Letter Greater Than Target(easy)**


> Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.<br>
> Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

**题目描述** &nbsp;&nbsp;给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。

**Note:**

 1. letters has a length in range [2, 10000].
 2.  letters consists of lowercase letters, and contains at least 2 unique letters. 
 3. target is a lowercase letter. 

**Example**

> Input: 
> letters = ["c", "f", "j"] 
> target = "a" Output: "c"
> <br>
> Input: 
> letters = ["c", "f", "j"] 
> target = "c" Output: "f"
> <br>
> Input: 
> letters = ["c", "f", "j"] 
> target = "d" Output: "f"
> <br>
> Input:
>  letters = ["c", "f", "j"] 
>  target = "g" Output: "j"
> <br>
> Input: 
> letters = ["c", "f", "j"]
>  target = "j" Output: "c"
> <br>
> Input: 
> letters = ["c", "f", "j"] 
> target = "k" Output: "c"

**解答**
这题相对较简单，主要就是使用二分查找来解决。

```swift
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low < n ? letters[low] : letters[0];
    }
}
```



## Review
`Clean Code` 这个词我们肯定都没少听说过，我们经常会听到身边的一些有经验的老同事或者是一些网上的大 V 们强调代码整洁的重要性，并且不少人都会推荐的一本关于代码整洁的数`《代码整洁之道》`。可见，代码整洁是多么的重要，但是其实很多人并没有这个意识的，有些是工作了些许年的老同志，有些则是初出茅庐的毛头小子，比如我这样刚毕业的小伙子（假装很年轻）。很多时候，我们对待代码整洁的理解很局限，比如我，平时的代码整洁更多的是写的规规矩矩，不乱空格，不乱换行，等等。但其实，代码整洁里面的学问是很有讲究的。

所以，分享 Medium 上读到的一篇关于代码整洁的文章《[What Is Clean Code?](https://medium.com/s/story/reflections-on-clean-code-8c9b683277ca)》。这篇文章首先谈到了三点：

 - 精湛的工艺

作为一个优秀的程序员，作为一个出色的软件工匠，尽最大程度的努力开发出更好的代码是首要任务，是最应该应先考虑的。对于软件开发来说，代码能够工作并不意味着完成了，还应该要追求更高的质量。高质量的软件开发在长期来看都是受益的，无论是对于客户、用户、公司还是开发者来说。那么如何才能开发出高质量的软件呢？那就要求我们要有该质量的输入（考虑周到、易维护、灵活的代码），从而会给我们带来高质量的输出（长期的业务受益）。

 - 今天的额外努力会拯救明天的痛苦

 但看这句话很别扭，原话是`Extra Effort Today Saves Pain Tomorrow`，直译过来是有些尴尬。不过说得也很明白了，也就是说，花费更多的精力开发出更完美的软件会大大减少日后维护的代价，其实就跟我们生活中的道理一样，学习一样东西、一样技能的时候马马虎虎糊弄过去了，那以后终究是要还的，而还的代价就特别大了，说的就是这个道理。出来混总是要还的，这点深有体会，大学的时候数据结构上课不好好听，课下也不好好学，现在补起来真的是要吐血啊，真的是悔不当初啊。

所以说，开发的时候我们要多考虑的周到一点，多花点精力把代码写的健壮一点，以后花在维护上面的时间就会很少，说白了还是给自己省时间。

- 你的代码并不只属于你自己

`你的代码并不只属于你自己`这句话怎么理解呢？这句话其实是在强调我们要有这样的意识，要对自己的工作感到自豪，同时也要意识到你写的代码并不只属于你一个人。为什么呢？因为你的代码并不是给你自己使用，说白了主要目的还是要提供给他人使用，比如你的同事，你的客户，甚至是未来你自己要使用。所以，如果你写的代码在将来的某个时候别人使用的时候根本不知道你写这个代码的用意是什么，那么毫无疑问，他们必须花费宝贵的时间和精力来解读你留给他们的谜题，这是十分不好的。

最后，也就是本文的核心了，什么是整洁的代码？整洁的代码其实要满足以下条件（英文比较直观，这里就不强行翻译过来了）。

 - Clean code is simple
 - Clean code is readable
 - Clean code is considerate
 - Clean code is tested
 - Clean code is practiced
 - Clean code is relentlessly refactored
 - Clean code is SOLID

乍一看，虽然代码整洁有很多的规则，但是作为程序员，越是注意代码整洁，对以后的工作越是有益。

<br>

## Tip/Techni

对于分布式版本控制系统，目前主流的主要有 Git、Svn 等，不过毫无疑问 Git 才是目前世界上最先进的分布式版本控制系统，也是目前最受欢迎的分布式版本控制系统。不过，比较遗憾的是我们公司这方面比较落后，还在使用古老的 Svn，实在是无力吐槽。

之前对 Git 用的很少，也仅限于简单结合 Github 使用一些简单的操作。所以这周抽空相对系统地学习了 Git 的知识和一些操作，学习了 Git 的安装、版本库的创建、工作区和暂存区、版本的回退等，学习的教程主要是廖雪峰的官方网站上的 `Git 教程`和 stormzhang 的电子书`《learn-github-from-zero》`。Git 的一些常规操作有：

 - git add <file> ——将文件添加到暂存区
 - git commit -m <提交信息> ——把暂存区的所有内容提交到当前分支
 - git diff HEAD -- file(文件名)——此命令可以查看工作区和版本库里面最新版本的区别
 - git status——git status命令用于显示工作区和暂存区的状态。
 - git log --graph --pretty=oneline --abbrev-commit
- git branch——查看分支
- git branch <name>——>git branch dev——创建分支
- git checkout <name>——切换分支
- git checkout -b <name>——创建+切换分支
- git merge <name>——合并某分支到当前分支
- git branch -d <name>——删除分支
- 等等

Git 的命令和一些操作比较多，学习的过程中也用幕布笔记做了下笔记，具体可以查看[Git 教程](https://mubu.com/doc/3SHLGZuCdk)。

<br>

## Share

分享一篇关于软件开发管理者的文章《[Three Management Methods (Introduction)](https://www.joelonsoftware.com/2006/08/07/three-management-methods-introduction/)》。很多程序员最终都会「转行」走向管理岗位，带新团队。而接手新的团队对于没有过任何管理经验的程序员来说，无疑是一项很大的挑战。如果想要领导一个新的团队，那么首先要面临的主要问题无疑就是要确保每个团队成员处在同一战线上，委婉点说就是`让团队成员撸起袖子放开了去做他们想做的事`。

那么，要带领新团队，有三种流行的方法可以学习并合理试用到团队里面。

 - 指挥与控制方法，说白了就是发号施令
 - 经济 101 法
 - 身份方法

这里简单说下`经济 101 方法`和`身份方法`，具体可以点开链接查看英文原文。

`经济101管理者`认为所有人都是为钱工作的，激励员工工作最好的手段就是用金钱刺激或者惩罚。但是，这种方式的最大问题在于它用外在的激励代替了内在的激励。内在的激励来自于每个人内心的渴望，他们都希望把事情做好。人们常常具有很强烈的内在激励性，他们希望把工作完成得很出色。比如，客服人员想要用户理解：每月付给AOL公司24美元是值得的；程序员想要写一些bug更少的代码。 外在的激励是来自外部的激励，比如说你因为完成特定的事情而获得报酬。 

内在激励的效果比外在激励要强烈得多。人们在做他们想做的事情时，会更加努力地工作。这无可置疑。 

但是当你付钱让人们做他们想做的事情时，这会带来过度理由效应（overjustification effect）的问题。”我必须写没有bug的代码，因为我喜欢奖金”，他们这样想的时候，内在激励已经被外在激励所替代了。因为外在激励效果微弱得多，结果他们的工作积极性被实际削弱了。当你停止发奖金，或者他们不再关心奖金的时候，就不会在写代码的同时注意修改bug。

经济101管理的另一个大问题是：人们倾向于寻找局部最大化利益。他们会针对你所提出的指标，找到一些急功近利的方法来完成，但忽视了你真正想让他们做的事情。

经济101管理方法的最大问题在于它根本不是管理。它是管理的退化。它回避寻找真正能把事情做得更好的方法。这意味着管理团队不知道如何教会人们把工作做好，所以他强迫系统中的每个人自己想办法去做。

而作为`身份管理者`则要求你创建一个有凝聚力，凝聚力的团队，感觉像一个家庭，以便人们对他们的同事有一种忠诚感和承诺感。身份方法的目标是通过让人们认同你想要实现的目标来进行管理。当然，最主要的还在于，`经济 101 管理`的问题在于它颠覆了内在动机，而`身份方法`则是一种创造内在动机的方法。
<br>

---
<br>

> 参考<br>
> 1、[经济101管理方法](https://www.douban.com/group/topic/1371781/)（经济 101 方法）

>2、[The Econ 101 Management Method](https://www.joelonsoftware.com/2006/08/09/the-econ-101-management-method/)（经济 101 方法）

> 3、[The Identity Management Method](https://www.joelonsoftware.com/2006/08/10/the-identity-management-method/)(身份方法)

> 4、[The Command and Control Management Method](https://www.joelonsoftware.com/2006/08/08/the-command-and-control-management-method/)（指挥与控制方法）
