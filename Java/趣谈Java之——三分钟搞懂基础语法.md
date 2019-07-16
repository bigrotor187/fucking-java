## 一、标识符


### 定义

Java 对各种变量、方法和类等程序中的要素进行命名时所使用的字符序列就是标识符。


### Java 标识符命名规则

 - 标识符以字母、下划线（_）、美元符号（$）开始；
 - 标识符由字母、数字、下划线、美元符号组成；
 - 标识符对大小写敏感，没有最大长度限制；
 - 标识符不能和关键字相同。


### 一些合法和非法的标识符示例
<br>

 - HelloWorld 合法
 - _test 合法
 - $hello 合法
 - Hello World 非法，因为中间有间隔
 - class 非法，因为与 Java 的关键字 class 重复
 - 123 非法，因为以数字开始
 - ab%、ab# 非法，因为标识符不能由 %、# 等符号组成

<br>

## 二、关键字


关键字是 Java 中具有特殊含义的字符序列，是程序的重要组成部分。并且关键字都是小写的，不允许赋予其他含义，



**用于数据类型的关键字**

> byte short int long char float double boolean

**用于流程控制语句的关键字**

> if else switch case for while do continue break

**方法、类型、变量的关键字**

> public private protected static final abstract volatile synchronized
> void return

**异常处理关键字**

> try catch throw throws finally

**与对象相关的关键字**

> new extends implements class this super instanceof

**字面值常量关键字**

> false true null

**与包相关的关键字**

> import package


<br>

## 三、Java 常量和变量


### 常量  

Java 中常量和变量的定义基本相同，在类型名称的前面加上修饰符 `final` 即可。

 - 整型常量 final int Max = 100;
 - 字符常量 final char a = 'hello';
 - 逻辑常量 final boolean flag = true; 
 - 字符串常量 final String s = "Hello World!";
 - 浮点型常量 final float f = 3.14f;

> **PS：要注意区分字符常量和字符串常量，字符常量只有一个字符。**


### 变量 

 - 变量是 Java 程序中的基本存储单元，其要素包括变量名、变量类型、值和作用域；
 - 变量类型决定了变量的数据性质、范围、变量存储在内存中所占的空间（字节数）以及可以进行的合法操作；
 - 变量名必须是一个合法的标识符；
 - 变量使用之前必须先进行声明。格式为：`[修饰符]<类型><变量名>[=<初值>][,<变量名>[=<初值>]···]`;



其中，<>表示一个占位符，在实际声明变量时需要替换成具体的类型名称和变量标识符以及变量初值。比如：



> int i;  // 声明了一个 int 类型变量，系统将会默认分配内存空间并初始化为 0
> 
> private int j = 100;  // 声明了一个私有的 int 类型变量并初始化为 100
> 
> float f = 3.14f;  // 声明了一个 float 类型变量并初始化为 3.14
> 
> double d1, d2 = 0.314; // 声明了两个 double 类型变量 d1、d2，并分别初始化为 0 和 0.314
> 
> String s = "Good"; // 声明一个 String 类型变量并初始化为 Good



从本质上讲，变量其实是内存中的一小块区域，我们可以通过变量名访问它的值。在一个作用域中，变量名应该是唯一的，这点与 C++ 不同。在使用一个变量之前，要先声明，然后进行赋值才能使用（成员变量不赋值系统会默认赋初值，局部变量要求必须赋值）。



通常，程序在运行的时候会源源不断地在内存中给变量分配内存空间，每个变量在内存中就是一小块区域，其中由两部分组成：变量名和变量值。也就是说这一小块区域也是有名称的，通过变量名我们就可以访问到这一小块区域中的内容（变量值）了。



那么，这一小块区域的大小是怎么分配的呢？这个是根据变量的类型不同来分配不同的内存空间。每个变量声明的数据类型不同，分配的内存空间大小也就不同。
            

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701002053390.png)


<br>

### 变量的分类


![在这里插入图片描述](https://img-blog.csdnimg.cn/2019070100291878.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)



有一点需要注意的是，变量出了它所在的大括号就不起作用了，反之只要是在它的大括号内的任何地方都起作用，也即在作用域内都起作用。

![变量存储区域](https://img-blog.csdnimg.cn/20190701003048929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)
<div align='center'><font size='1'  color='gray'>变量存储区域</font></div>


<br>


## 四、Java 数据类型



Java 的数据类型主要分为两类：`基本数据类型`和`引用类型`。其中，基本数据类型都有固定的长度，不会随着平台的变化而变化，而引用数据类型则是用类或对象来实现。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003200175.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)




<br>

### 数据类型详解

<br>

#### 1 布尔型-boolean

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003448552.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)


<br>

#### 2 字符型-char

![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E5%AD%97%E7%AC%A6%E5%9E%8B.png)


<br>

#### 3 整数类型-byte、short、int、long

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019070100351424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)



<br>

#### 4 浮点类型-float、double

![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E6%B5%AE%E7%82%B9%E5%9E%8B.png)




<br>

### 数据类型转换 
<br>





```swift
public class TestConvert {
    public static void main(String arg[]) {
        int i1 = 123; 
        int i2 = 456;
        double d1 = (i1 + i2) * 1.2; //系统将转换为double型运算
        float f1 = (float)((i1+i2)*1.2);//需要加强制转换符
        byte b1 = 67; 
        byte b2 = 89;
        byte b3 = (byte)(b1+b2); //系统将转换为int型运算，需要强制转换符
        System.out.println(b3); //结果：-100

        double d2 = 1e200;
        float f2 = (float)d2; //会产生溢出
        System.out.println(f2); //infinity(无限)

        float f3 = 1.23f; //必须加 f
        long l1 = 123;
        long l2 = 30000000000L; //必须加 l
        float f = l1+l2+f3; //系统将转换为float型计算
        long l = (long)f; //强制转换会舍去小数部分（不是四舍五入）
    }
}
```


<br>

## 五、运算符
<br>

![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E8%BF%90%E7%AE%97%E7%AC%A6.png)




### 1 逻辑运算符

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003645391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)





### 2 字符串连接符

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003659963.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)





### 3 赋值运算符

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003714840.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)




### 4 算术运算符（自增和自减运算符）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190701003751794.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0JpZ19Sb3Rvcg==,size_16,color_FFFFFF,t_70)




自增和自减在前和在后的情况很多童鞋经常搞混，当初开始接触的时候我也经常傻傻分不清。这里需要注意一下，++/-- 在前的时候表示先运算再取值，什么意思呢？也就是先把这个变量的值 -- 或 ++ 之后取到新的值后再去做其他的运算。而 ++/-- 在后的情况则正好相反，就不重复赘述了。

<br>

### 5 条件运算符



![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E6%9D%A1%E4%BB%B6%E8%BF%90%E7%AE%97%E7%AC%A6.png)




<br>

## 六、表达式

<br>


![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E8%A1%A8%E8%BE%BE%E5%BC%8F.png)


### 结论

 - 赋值运算符的优先级别最低，因为赋值运算符要使用表达式的结果；
 - 关系运算符的优先级比布尔运算符的优先级高；
 - .、[]、() 等运算符的优先级最高；
 - 算术运算符比关系运算符和二元逻辑运算符的优先级高；
 - 在表达式中，可以用()显示标明运算次序，括号中的表达式优先被计算。



<br>

## 写在最后
<br>


至此「趣谈Java之——基础语法篇」就已结束，接下来给自己三分钟的时间回想一下，今天这篇都学习到了什么。



如果你按我说的去做，你会发现你只能回忆起一些内容，很难把全部的知识都记住。这是很正常的情况，所以需要温故而知新。最后，我把这篇文章的知识点整理成思维导图送给大家。


![在这里插入图片描述](https://github.com/bigrotor187/awesome-java-notes/blob/master/imgs/%E5%9F%BA%E7%A1%80%E8%AF%AD%E6%B3%95%E5%AF%BC%E5%9B%BE.png)


**如果觉得文章还不错，请大家点赞分享给你的朋友，TA 可能正需要，你的肯定是对我最大的支持和鼓励。**




> <font size='1'>参考来源：马士兵教学视频、《Java 编程思想》
> 
>  <font size='1'>特别感谢：文中部分图片来源于马士兵老师的教学视频，在此特别感谢




---

**推荐阅读：**


[全网最全的编程学习资源，PDF 电子书大合集](https://blog.csdn.net/Big_Rotor/article/details/91352247)

