> ## ARTS是什么？
> - **Algorithm**：每周至少做一个leetcode的算法题；
> - **Review**：阅读并点评至少一篇英文技术文章；
> - **Tip/Techni**：学习至少一个技术技巧；
> - **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm


**题目描述** &nbsp;&nbsp;二分查找变体一：查找第一个值等于给定值的元素

**解答**

因为查找第一个值等于给定值的元素，说明这个数组中是有重复元素的，比如 1 2 3 5 5 5 6 8 10 15，要找到第一个 value = 5 的元素，那就不能是直接找到 mid = 4 的元素就直接返回，虽然 a[4] = 5，但是并不是第一个等于 5 的元素，很显然 a[3] 也等于 5，所以就不能像正常的二分查找那样直接找到 a[mid] = 5 就直接返回了，要稍微做一下变形。

 - 终止条件：low <= high
 - a[mid] > value 时，high = mid - 1
 - a[mid] < value 时，low = mid + 1
 - a[mid] = value 时有两种情况，即
	 - [ ] mid = 0 时，说明 a[mid] 已经是数组第一个元素，即为所求；或者 a[mid - 1] != value 时，说明 a[mid] 前一个元素肯定不为 value，即 a[mid] 肯定是第一个值为 value 的元素，那么 a[mid] 即为所求
	 - [ ] mid != 0 并且 a[mid - 1] == value 时，则说明 a[mid] 不是第一个值为 value 的元素，则重新赋值 high = a[mid] - 1; 继续循环



```swift
public int bsearch(int[] a, int value) {
	int low = 0;
	int high = a.length - 1;
	while (low <= high) {
		int mid = low + ((high - low) >> 1);
		if (a[mid] > value) {
			high = mid - 1;
		} else if (a[mid] < value) {
			low = mid + 1;
		} else {
			if ((mid == 0) || (a[mid - 1] != value)) {
				return mid;
			} else {
				high = mid - 1;
			}
		}
	}
	return -1;
}
```

## Review

分享 Medium 上的一篇文章<font size=1 color=grey>（需要网络）</font>《[Why I Recycle Programming Problems](https://medium.freecodecamp.org/why-i-recycle-programming-problems-7785e04e451d)》。这篇文章谈到了回收自己编程中遇到的问题的好处，换句话说也就是定期 review 自己的代码的重要性。

<font  color=grey>**回收编程问题有什么好处呢**</font>

 - 知道所不知道的，知道没有掌握的地方

编程的时候，我们往往会发现自己以前解决过的问题但现在发现又不会了，也就是说，你以前写代码的时候会解决的问题并不代表你一直都会。所以，定期 review 自己的代码，回收总结编程中遇到的问题很关键，它将会验证你掌握的知识并揭示你之前解决这个问题棘手的地方在哪儿。同时，定期回收编程问题还将会强化一些概念。

 - 老问题，新技巧

回收编程问题的时候，可以给自己添加自我约束，比如之前你是通过一个 `for` 循环来解决问题的，那第二次、第三次解决的时候你可以尝试使用新的方法而不再使用 `for` 循环的方式，比如你可以使用 `set` 的方式，慢慢的你会发现代码变得更加干净和更加可读了。

但是，有时添加自我约束强迫自己使用新的方法来解决问题会使你的代码变得更加复杂，比如原本使用迭代解决，现在强迫自己使用 `while` 循环来解决，使得代码变得更加冗长和复杂了。但是，通过这种方式，会帮助你更加理解何时使用何种方法是更高效的。

更重要的是，通过回收编程问题时不断给自己添加约束的方式，会促使你不断地去思考，跳出自己的舒适区，这是很棒的。

 - 学会写测试

回收编程中的问题的时候，要学会不断地写测试验证自己的代码，看看哪种方式更高效。

总之呢，定期回收编程问题既可以巩固概念，又能够让你接触新的概念、知识，关键还能简历更系统、更体系的知识结构。

<br>

## Tip/Techni

在项目中，有时候是会用到定时任务的，最近在项目中用到了定时任务，这里简单记录下。项目是 Gradle 的 Spring Boot 微服务项目，将要添加的定时任务统一写到一个单独的 xml 文件中，比如 `quartz.xml`，添加的定时任务如下(一些包名做了处理，用 xx 表示)，具体的说明见注释：

```swift
<?xml version="1.0" encoding="UTF-8"?> 
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" 
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
	http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee.xsd
	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
	http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd" 
	default-lazy-init="true">
	<!--添加相应的 bean-->
    <bean id="PopupBIZ" class="com.xx.popup.biz.PopupBIZ"/>
	<!-- 每天凌晨查询户信息保存进缓存 -->
	<bean id="automaticClose" class="org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean">
		<!-- 执行对象 -->
		<property name="targetObject" ref="PopupBIZ"></property>
		<!-- 执行对象中对应的执行方法 -->
		<property name="targetMethod" value="resetPopupTimes"></property>
		<!-- 是否可并发执行 -->
		<property name="concurrent" value="false"></property>
	</bean>
	<!-- 保存用户信息到缓存任务调度触发器 -->
	<bean id="automaticCloseCronTrigger" class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
		<!-- 任务详细信息 -->
		<!-- 触发器触发的 执行定时任务的bean -->
		<property name="jobDetail" ref="automaticClose"></property>
		<!-- 执行时机  每周星期天23点59分执行一次 -->
		<property name="cronExpression" value="0 59 23 ? * L"></property>
	</bean>
	<!-- 设置任务调度工厂 -->
	<bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
		<property name="triggers">
			<list>
				<ref bean="automaticCloseCronTrigger"/>
			</list>
		</property>
	</bean>
</beans>
```
<font size=1 color=gree>【注】代码中的 biz 代表的是业务逻辑层，也就是通常所说的 MVC 模式下的 service、action 层。</font>

除了在`quartz.xml`中添加了定时任务之外，还要在同级目录下`applicationContext.xml` 中的 `<beans></beans>` 中添加 `<import resource="classpath:quartz.xml"/>`将`quartz.xml`导入，这样在微服务项目启动加载 `applicationContext.xml`  的时候就会扫描到定时任务的 `quartz.xml` 文件。
<br>

## Share

分享一篇知乎上的文章《[最醍醐灌顶的一堂课，是六旬父母刚刚给我上的……](https://zhuanlan.zhihu.com/p/52773647)》，这篇文章虽然不是技术相关的文章，但我觉得套用到技术上也是一个道理，所以分享一下。这篇文章中，通过老父亲年轻时学习二胡和「蹦蹦琴」等乐器的亲身经历与孙女现在学习钢琴几年却没啥长进的经历铺开叙述，阐明了孙女学习钢琴没进步的原因并给出了建议。其中，有几句话我是特别认可的：`第一，乐器表演的原理都是相通的，而每首曲子包含的技巧具有很大共同性。要想进步速率最快，必须通过一首曲子打通其包含的所有技巧，就好像要先把一口井打通，才能喝到水一样。第二，学习乐器持续进行的关键就是获得成就感。`

结合自身经历，想想也的确如此。这不正是我们平常所说的`慢就是快，会越来越快`吗？现在想来，在学校的时候没好好夯实技术基础，计算机网络、计算机组成原理、数据结构与算法等等，这些都是技术的根基，没好好打牢基础，所以现在才会感觉进步如此缓慢。乐器学习如此，技术学习不也是一样的道理吗？很多技术的原理都是通的，就像编程语言也一样，先把一门语言学通，再上手其他语言就会很快，刚开始是慢，但学通了一门语言，基础打牢了再去学习其他语言，学习其他技术就会很快。想想之前，Java 都没学明白就想去学习 Python，确实很搞笑。其次，要有成就感，这样才能慢慢培养学习的兴趣，不然会越来越枯燥。

很多时候，许多同学包括我自己都会陷入想得太多做的太少的困境中，总觉得什么都不懂，什么都要学，越想越不知道如何开始，所以干脆想着想着一天又无所事事的就过去了。所以，还是那句话`慢即是快`，先找准一个点先学，慢慢的再铺开。比如框架不懂，可以先选定框架来学习，而不是一头雾水地又是学习一堆框架，又是学习数据结构与算法，又是学习计算机网络啥的，这样会越来越乱，越来越慌的。
<br>

