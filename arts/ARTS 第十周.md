## ARTS是什么？<br>
> **Algorithm**：每周至少做一个leetcode的算法题；<br>
> **Review**：阅读并点评至少一篇英文技术文章；<br>
> **Tip/Techni**：学习至少一个技术技巧；<br>
> **Share**：分享一篇有观点和思考的（技术）文章。<br>

<br>

## Algorothm
这次的算法做了 leetcode 上的一道 3sum 算法题：[LeetCode15.3sum](https://blog.csdn.net/Big_Rotor/article/details/90354566)
## Review
[《送给初学编程者的 5 个 GitHub 技巧》](https://medium.com/free-code-camp/5-github-tips-for-new-coders-2f312689ffd5)

这篇文章中，作为一个已经在 gitHub  工作了 5 年的员工，作者根据自己经验和所踩过的坑给初学的程序员提供了 5 个 github 的技巧。

1、**Change your default text editor associated with Git**。更改与 Git 关联的默认文本编辑器 VIM。因为对于大部分 hacker 甚至 [@haacked](https://twitter.com/haacked)本人来说，VIM 都是很不友好的。特别是党羽要合并冲突的时候更是欲哭无泪，当你想要使用 VIM 来解决冲突的时候，你得记住一大推详细命令。

那有没有什么更好的办法呢？我们可以将 VIM 切换成 Atom, Sublime 或 TextMate 这些文本编辑器，将大大便利我们的操作。具体可以跟着 [GitHub Help](https://help.github.com/en/articles/associating-text-editors-with-git) 这个教程来。

2、**Change your dotfiles**。Dotfiles允许自定义终端提示，以便我们可以看到所使用的 git 分支以及是否有未经提交的更改。具体可以跟着 [my dotfiles](https://github.com/alysonla/dotfiles) 这个教程来学习。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190530231940685.png)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190530231954422.png)

3、**Install Hub**。[Hub](https://github.com/github/hub)是一个命令行工具，可以更轻松地使用 GitHub。通常在终端上的仓库工作，但是想在 GitHub 上查看问题或提取请求的时候，会分散我们的注意力。不过，通过在终端中键入 `hub browe`，将直接在浏览器中自动神奇地打开存储库的 URL，以免分散注意力。

4、**Practice merge conflicts**。使用 Git 遇到冲突是我们无法避免的坑，所以建议建一个专门的仓库来练习。当然，可以参照步骤 1，切换文本编辑器，而不是使用 VIM 来操作。具体可以跟着 [fix simple merge conflicts](https://github.blog/2016-12-12-resolve-simple-merge-conflicts-on-github/)这个简单的教程或者 [Git & GitHub: Merge Conflicts](https://youtu.be/sfT0WrChMrM)这个 youtube 视频来。

5、**Make a GitHub Page**。GitHub page 是 GitHub 免费托管的个人或项目网站！有一个实际的项目来推动 GitHub 练习你的 Git 和 GitHub 技能总是有帮助的。

具体可以使用编码教程中的 HTML，CSS 和 JavaScript 创建一个简单的网站，然后按照[步骤](https://pages.github.com/)在 GitHub 上托管它，或者跟着这个[视频](https://www.youtube.com/watch?v=rRGrT0wsJxI)手把手来，也可以尝试更简单的[方法](https://github.com/jlord/forkngo)。

<font size='2' color='red'>PS：作为一个合格的程序员，平时要想完全不跟 Git 和 GitHub 是不太现实的，讲真，由此听到一个同事说他不知道 GitHub 是什么的时候，我和我的小伙伴真的是惊呆了都。扯远了，话说回来，学会更好地使用 GitHub 无疑将会是一笔巨大的财富。</font>

<font size='2.5' color='red'>不过，毕竟 GitHub 也就是一个工具，工欲善其事，必先利其器，所以，学会一些技巧可以帮助我们更加便利地使用 GitHub，同时减少一些不必要地时间浪费和精力分散。</font>
## Tip/Techni
在项目中我们估计多多少少都会用到 `SimpleDateFormat` 这个类来做一些时间的转换，有些同学通常会直接定义为  `private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");`这样的形式，也没考虑太多，但其实这是不安全的，因为 SimpleDateFormat 是线程不安全的类，所以使用的时候尽量不要定义为 static 变量。

这一块《阿里巴巴Java开发手册》中第六个模块**并发处理**的第 5 条有专门说这个事情。![在这里插入图片描述](https://img-blog.csdnimg.cn/201906021343258.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)
另外，看到有一篇关于 SimpleDateFormat 线程不安全的博客《[SimpleDateFormat的线程安全问题与解决方案](https://www.cnblogs.com/zemliu/archive/2013/08/29/3290585.html)》写得挺好的，有兴趣也可以看一下。
## Share
`阅读是唯一短期内可能没什么太大帮助，但长期积累下来一堆会对你有巨大影响的一件事`这句话对我影响很大，其实主要想说的还是`学习是有滞后性的`。现在很多同学都很浮躁，觉得买了一个课程，看了几篇文章立马就能提升一大截，立马就能变大 V 一样。其实这很不可取，可能我们每个人身上多多少少都会经历过这样的阶段，但是能够静下来，长期坚持阅读，坚持积累，技术也好其他也好，坚持下来才会看到知识的复利作用，毕竟人生是一条复利增长曲线，不是看谁走得快，而是看谁走得远。

之前只坚持了九周的 ARTS 着实有些忏愧，希望这次能认真的重拾起来，不要好高骛远，其实每周认真写一下 ARTS还是挺有收获的，以房买你能够督促自己不要偷懒，另一方面其实对自己的表达和写作能力也是有帮助的。

这次就不 share 技术文章了，在知识大爆炸的今天，学会做好个人知识管理很重要，接受过几次知识管理的咨询和答疑后，返现确实还是不过错的，有助于管理自己的知识和接触到的信息，减少大脑的压力，提高效率。分享一篇自己的知识管理学习笔记——《[为什么需要学习个人知识管理](https://app.yinxiang.com/fx/6a08ecea-2bf0-4878-8e1d-88c2fa7eff32)》，有兴趣可以看看。
