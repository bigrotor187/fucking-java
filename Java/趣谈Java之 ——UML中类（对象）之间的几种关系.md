> **阅读文本大概需要 6.66 分钟。**



## 前言
<br>


大家好，这是首发于公众号「蜗牛永动机」的趣谈 Java 系列教程。学习一门语言最好的办法，就是教会别人。在这个公众号，我会从最基础的教程开始写起，一方面是为了更好地复习巩固 Java 基础，另一方面也是慢慢进阶的过程。喜欢的朋友请点关注，每天一小步，一年后就是一大步。废话不多说，开始今天的文章。



<br>

## 1 简单了解 UML 中的类图结构
<br>


在学习类（对象）之间的关系之前，首先来了解一下 UML 中一个类是如何表示的。在 UML 中，一个类主要由三个部分组成，具体如下：



> 类名 
> 
> 属性（成员变量）的名称和类型 
> 
> 方法的名称、返回类型和参数



比如，我们可以看到一个 Person 类和一个 Employee 类的类图表示如下：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190630233841778.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)





有些童鞋可能看得很仔细，应该注意到了上图中的属性或方法的前面标有  - 或 + 号。这里也顺便提一下，这几种符号表示的是属性和方法的可见性。通常，在 UML 中表示类图的时候，表示属性或方法可见性的符号主要有以下三种：

>  **+** 表示 public<br>
>  **-** 表示 private<br>
>  **#** 表示 protected



比如，我们可以从上图中 Person 和 Employee 的类图中看出，Person 类有 3 个私有属性和 5 个公有方法，而 Employee 类则有 3 个私有方法和 6 个公有方法。



<br>

## 2 UML 中类之间的关系概述
<br>


类（对象）之间通常有两种主要的结构关系，一种是**一般—>特殊**关系，另一种是**整体—>部分**关系。从这两种类的结构关系中又可以细分出来很多种具体的类（对象）关系。



通常，一般—>特殊关系主要指的是一种 **is a**关系，其中最典型的代表就是泛化关系（继承关系）和实现关系。



> 继承关系（generalization）
> 
> 实现关系（generalization）



整体—>部分关系则指的是一种 **has a**关系，这又怎么理解呢？因为这种结构就是典型的组装结构，也即典型的组合关系。通常，我们会在 Java 中的一个类中嵌入另一个类的对象来实现这种组合关系。整体—>部分关系通常包括以下几种类（对象）关系：



> 关联关系（association）
> 
> 依赖关系（dependency）
> 
> 聚合关系（Aggregation）
> 
> 组合关系（Composition）



<br>

## 3 类（对象）之间的关系详解
<br>


### 3.1 一般—>特殊关系

<br>

#### 3.1.1 继承关系（generalization）
<br>


在 Java 中通过关键字 extends 来表示继承关系。这里的 is a 关系要怎么理解呢？因为 Java 中子类继承自父类，子类是一种特殊的父类，所以简单粗暴地理解就是子类 is a 父类。具体到生活中的例子，比如人—>动物，这就是典型的一般—>特殊关系，人是一种动物这完全说得通，但是反过来说动物是一种人，这很显然就说不通了。



所以，不妨换个角度来理解，父类范围更大，而子类范围更小，也即父类指代的是更泛、更一般的概念，而子类则代表的是一种更特殊、更具体的特指。也就是说，这是完全符合一般—>特殊关系的。再比如猫头鹰是一种鸟，但不能反过来说鸟是一种猫头鹰，这很显然说不通，完全一样的道理。所以，我们可以得出这样的结论：



**继承关系封装了这样一种逻辑：「XX是一种XX」，只要这种关系能说得通，就可以考虑用继承关系来封装它。**



    继承关系在 UML 类图中用 实线 + 实心箭头 表示。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190630234514674.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)



<br>

#### 3.1.2 实现关系（generalization）
<br>


一个类实现一个接口，其实接口也是一种特殊的类。在这里，接口也即父类。我们可以在一个接口中定义一个或多个方法，但是不去具体实现，而是由它的子类去具体实现，这种关系就叫做实现关系。比如，我们定义了一个乐器接口，这个接口中定义了一个方法叫弹奏乐器（），至于它是敲击类乐器还是弦类乐器我们不去关心，由具体的乐器去实现这个方法。比如具体到钢琴就是弹钢琴，具体到吉他就是弹吉他，具体到鼓就是打鼓。



    实现关系在 UML 类图中用 虚线 + 空心箭头 表示。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190630234546556.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)





<br>

### 3.2 整体—>部分关系
<br>


<br>

#### 3.2.1 关联关系（association）
<br>


关联关系是一种比较弱的关系，指两个类之间存在某种对应关系。比如个人和银行卡，一个人是可以拥有多张银行卡的，但是一张银行卡只可能属于某一个人，不可能说一张银行卡既属于你，也属于我，这是根据身份证来办的，很显然是唯一的。



根据方向可以分为单向的和双向的，根据对应的数量可以分为一对一、一对多、多对一和多对多等几种关系。比如，下图中的 Person—>Card 是双向一对多关系，反过来Card—> Person 则是双向多对一关系。关联关系在 UML 中用实线 + 箭头来表示。



![在这里插入图片描述](https://img-blog.csdnimg.cn/20190630234603161.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)



对应到代码中如下：


```swift
public class Person {
    private Integer id;
    private String name;
    private Set<Card> cards;

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}

class Card {
    private Integer id;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
```

#### 3.2.2 依赖关系（dependency）
<br>


依赖关系通常指的是一种单向的关系，指的是调用关系。具体到代码中往往表现为一个类的方法里面的参数是另一个类的某个具体的对象。换句话说，如果 A 依赖于 B，那么代码中 B 表现为 A 的方法参数、局部变量或静态方法调用等。比如，一支球队中的教练和球员的关系，教练可以教球员练习球技，教这个动作是教练这个类中的一个方法，那么教哪个球员呢？这里某个球员是球员这个类中的某个具体的对象，在这里作为教练这个类中的教（）这个方法的参数出现。



    依赖关系在 UML 中用虚线 + 箭头来表示。

如下图，表示 Coach 和 Player 这两个类是依赖关系，其中，Coach 依赖于 Player。


<div align=center><img src="https://img-blog.csdnimg.cn/20190630234648509.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70" alt="图片来源于网络"/></div>





具体到 Java 代码中如下：


```swift
public class Coach {
    public void teach(Player player) {
        player.play();
    }
}

class Player {
    public void play() {
        System.out.println("打球最重要的就是动作要快，姿势要帅！");
        System.out.println("教练怎么教我就怎么打！");
        System.out.println("重要的是要风靡万千少女和老太太！");
    }
}
```

#### 3.2.3 聚合关系（Aggregation）
<br>


聚合关系和组合关系其实是更切合整体—>部分关系的，通常我们更喜欢将关联关系和依赖关系形容为 use a 的关系，而聚合关系和组合关系则形容为 has a 的关系。



那么，到底什么是聚合关系呢？聚合关系更加强调整体和部分的关系，通常，我们会说 xx 是 xx 的一部分，只要说得通，那么他们之间就是聚合关系。比如，主板是电脑的一部分，显卡是电脑的一部分，电池是电脑的一部分，很显然这都是说得通的。



但是，有一点需要注意的是，聚合关系中的部分是相互独立的，并不是说部分离开了整体不能独立存在。比如，一块显卡、主板或电池既可以装在电脑 A 中，同样也可以装在电脑 B 中，并不是固定在某台电脑上面，就像这里 A 中的主板离开了 A 装在 B 中仍然是有意义的。



聚合关系表示成 UML 中的类图时，他们之间的关系使用空心菱形+实线表示，具体如下：

<div align=center><img src="https://img-blog.csdnimg.cn/20190630234707209.png" alt="图片来源于网络"/></div>
<div align='center'><font size="1px"  color='gray'>图片来源于网络</font></div>

 

<br>

#### 3.2.4 组合关系（Composition）

<br>

前面说了聚合关系，那组合关系又是什么呢？组合关系与聚合关系其实大同小异，打最大的不同在于，组合关系中的整体和部分密不可分，不像聚合关系中部分离开了整体还是有意义的。组合关系则不同，比如人体是由头、手、脚等组成的，一个人的脑袋不可能说既属于自己又属于别人，手和脚也是一样的道理。你的头和手、脚等离开了你的身体也没有什么存在的意义。



那么，组合关系在 UML 的类图中是如何表示的呢？`组合使用实心菱形和实线表示。`比如下图中表示 People 是由 Head、Hand、Leg等组成。


<div align=center><img src="https://img-blog.csdnimg.cn/20190630235717715.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70" alt="图片来源于网络"/></div>
<div align='center'><font size="1px"  color='gray'>图片来源于网络</font></div>

<br>

## 4 需要注意的地方
<br>


上面我们详细地解释了关联、依赖、聚合和组合关系，但有时候仍然很容易混淆。无论对象 A 和对象 B 之间是关联、依赖、聚合还是组合关系，具体到代码中，A 都有可能调用 B，这是它们的相同之处。



所以，简单地通过 A 调用 B 我们是无法判断出来 A 和 B 的关系的。那么，这四者之间的不同在哪儿呢？



当两个相对独立的对象之间存在某种特殊的对应关系时，比如上文说所说的个人与银行卡之间的关系就是**关联关系**。具体到代码中表现为在人这个类中定义了银行卡类型的属性。



当两个相对独立的对象之间，存在一个对象作为另一个对象的方法参数或局部变量出现时，这种关系就叫**依赖关系**。与关联关系最大的区别在于，不需要在一个对象中定义另一个对象类型的属性。



聚合和组合之间单从代码中是看不出区别的，通常要根据具体的业务环境来区分。例如，汽车和轮胎，假如你新买了一辆车，肯定是有轮胎的，在这个业务背景下汽车和轮胎之间就是**组合关系**，分开了这辆车等同于废车，没有实际意义。但是，对于汽修店来说，车轮是可以更换的，这是有实际的业务意义的。这里汽车和轮胎之间不再是组合关系，而是**聚合关系**。



<br>

## 写在最后
<br>


至此「趣谈 Java 之 UML 中类（对象）之间的几种关系」篇就已结束，接下来给自己三分钟的时间回想一下，今天这篇都学习到了什么。



如果你按我说的去做，你会发现你只能回忆起一些内容，很难把全部的知识都记住。这是很正常的情况，所以需要温故而知新。最后，我把这篇文章的知识点整理成思维导图送给大家。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190630235929170.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)<div align='center'><font size='1'  color='gray'>点击放大查看</font></div>


<br>


> **如果觉得文章还不错，请大家点赞分享给你的朋友，TA 可能正需要，你的肯定是对我最大的支持和鼓励。**

<br>

---

**推荐阅读：**


[全网最全的编程学习资源，PDF 电子书大合集](https://blog.csdn.net/Big_Rotor/article/details/91352247)
