> ## ARTS是什么？
> - **Algorithm**：每周至少做一个leetcode的算法题；
> - **Review**：阅读并点评至少一篇英文技术文章；
> - **Tip/Techni**：学习至少一个技术技巧；
> - **Share**：分享一篇有观点和思考的技术文章。

<br>


## Algorithm


**题目描述** &nbsp;&nbsp;二分查找变体二：查找最后一个值等于给定值的元素

**解答**

因为要查找最后一个值等于给定值的元素，说明这个数组中是有重复元素的，比如 1 2 3 5 5 5 5 8 10 15，要找到最后一个 value = 5 的元素，那就不能是直接找到 mid = 4 的元素就直接返回，虽然 a[4] = 5，但是并不是最后一个值等于 5 的元素，很显然 a[5] 、a[6] 的值也等于 5，所以就不能像正常的二分查找那样直接找到 a[mid] = 5 就直接返回了，要稍微做一下变形。

 - 终止条件：low <= high
 - a[mid] > value 时，high = mid - 1
 - a[mid] < value 时，low = mid + 1
 - a[mid] = value 时有两种情况，即
	 - [ ] mid = a.length - 1 时，说明 a[mid] 已经是数组最后一个元素，即为所求；或者 a[mid + 1] != value 时，说明 a[mid] 是最后一个值为 value 的元素，则 a[mid] 即为所求
	 - [ ] mid != a.length - 1 并且 a[mid + 1] == value 时，则重新赋值 low = mid + 1;  继续循环
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
			if ((mid == a.length -1) || (a[mid + 1] != value)) {
				return mid;
			} else {
				low = mid + 1;
			}
		}
	}
	return -1;
}
```

## Review

Review 一篇 Medium 上的文章《[Coding Tip: Try to Code Without Loops](https://edgecoders.com/coding-tip-try-to-code-without-loops-18694cf06428)》，标题很直白：`尝试不通过循环方式编码的技巧`，其中副标题是`You might uncover better solutions`<font size=2>（你也许会发现更好的解决方案）。</font>很多时候发现好像真的是不写循环、不写 if ... else 就不会写代码了一样，真的是脑阔疼。

尝试不写循环，而是通过其他方式来编码，文中主要给出了两种方法并举了几个例子，文中的例子有兴趣可见看下原文，虽然是 JavaScript 写的，但不妨碍阅读。

 - 不可变性（Immutability）

避免循环不仅仅是声明性的，它还允许我们以不可变的方式处理我们的数据。话句话说就是可以将我们的数据封装起来处理，什么意思呢？就是可以通过函数的方式来处理，循环的地方可以抽象成一个方法，然后通过方法调用的方式来解决。

 - 递归（Recursion）

递归是一种代替循环的方式，很多时候一直循环来循环去的代码完全可以考虑使用递归的方式来代替，从而使代码更加简洁。递归是比较简单的，就是通过一个函数不断调用本身（它创建一个循环）并设计一个退出条件。
<br>

## Tip/Techni

在项目开发中，有时候需要用到缓存，而使用缓存的方式很多，这里暂且简单说下自己在项目中使用缓存的经历吧。

首先在 xx-xx-cache.properties （<font size=2>注：xx 可以自己命名</font>）配置文件中配置缓存相关的参数，包括 redis.servers、redis.get.uri、redis.set.uri 等，然后在 controller(控制层) 或 service(业务逻辑层)中使用缓存。其中要用到 redis 工具类 RedisTool.java（<font size=2>可以自己写，有需要的话这里提供缓存添加、获取、移除等几个方法上传到资源里了，也可以上网找，仅供参考</font>）。由于篇幅有限，这里暂且放一个缓存添加 hset 和缓存获取 hget 方法吧。

**xx-xx-cache.properties**

```swift
#Redis配置
#多个servers用逗号(",")隔开,不要配置redis从机的IP,只需要redis主机IP
redis.servers=http://xxx.xxx.xxx.xxx:xx //前面表示缓存服务器IP，后面表示端口
redis.get.uri=/redis/get //key-value 形式，可自行命名，下同
redis.set.uri=/redis/set
redis.hget.uri=/redis/hget
redis.hset.uri=/redis/hset
redis.rpop.uri=/redis/rpop
redis.lpush.uri=/redis/lpush
redis.rm.uri=/redis/rm
redis.hdel.uri=/redis/hdel
redis.hexists.uri=/redis/hexists
redis.hkeys.uri=/redis/hkeys
#redis密码,所有redis服务密码必须一样
redis.password=XXX
#最大连接线程数
redis.pool.maxActive=XXX //自行设置，比如 10000
#连接超时时间(单位:秒)
redis.pool.timeout=XXX //自行设置，比如 3000
#缓存时间(单位:秒)
redis.pool.expires=XXX //自行设置，比如 86400
#在获取一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
redis.pool.testOnBorrow=true
#在return给pool时，是否提前进行validate操作；
redis.pool.testOnReturn=true

#session time out (单位:秒)
session.timeout=XXX //自行设置，比如 1000

#zookeeper
zookeeper.address=xxx.xxx.xxx.xxx:xx //前面表示 zookeeper 的服务器IP，后面表示端口
zookeeper.session.timeout=XXX //自行设置，比如 180000
zookeeper.connect.timeout=XXX //自行设置，比如 30000

#默认为false，不写日志，true 写日志
#程序运行日志
RunLog = true
#服务调用日志
InvokingLog = true
#业务数据日志
BssLog = true
```
**RedisTool.java 中 hset 和 hget 方法**

```swift
/**
	 * Hget方法
	 * 
	 * @param name
	 *            hash值
	 * @param key
	 *            hash值下的key名称
	 * @return
	 */
	public static String hget(String name, String key) {
		String result = "";
		String param = "name=" + name + "&" + "key=" + key;
		String redisValue = "";
		try {
			result = HttpHelper.sendPost(redisHgetUrl, param);
			String errorCode = null;
			JSONObject jsonObject = null;
			String errormessage = "";
			try {
				jsonObject = JSONObject.fromObject(result);
				errorCode = jsonObject.getString("result");
				errormessage = jsonObject.getString("errormessage");
				if (errorCode.equals(Y_STATUS)) {
					redisValue = jsonObject.getString("data");
					return redisValue;
				} else {
					return RESULT_ERROR;
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("查询缓存，获取返回值异常，返回值为" + result);
				return RESULT_ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Redis服务，Hget接口异常" + e.toString());
			return RESULT_ERROR;
		}
	}

	/**
	 * hset方法
	 * 
	 * @param name
	 *            hash值
	 * @param key
	 *            hash值下的key名称
	 * @param value
	 *            key的值
	 * @return
	 */
	public static boolean hset(String name, String key, String value) {
		String result = "";
		try {
			value=URLEncoder.encode(value, "UTF-8");
			String param = "name=" + name + "&key=" + key + "&value=" + value;
			result = HttpHelper.sendPost(redisHsetUrl, param);
			String errorCode = null;
			JSONObject jsonObject = null;
			String errormessage = "";
			try {
				jsonObject = JSONObject.fromObject(result);
				errorCode = jsonObject.getString("result");
				errormessage = jsonObject.getString("errormessage");
				if (errorCode.equals(Y_STATUS)) {
					return true;
				}
				return false;
			} catch (Exception e) {
				logger.error("添加缓存，获取返回值异常，返回值为" + result);
				logger.error("异常信息为：", e);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Redis服务，Hget接口异常" + e.toString());
			return false;
		}
	}
```

<br>

## Share

分享一篇文章《[你思考问题的方式，决定了你的层次](https://mp.weixin.qq.com/s/Ik3lf9KIUvDnAyOaXd6mwg)》，这篇文章从从我们思考问题的思维方式和思维层次来解读 6 种层次不同的人才是如何思考、解决问题的。

1、第 5 流人才

 - 别名：怨妇
 - 所处理解层次：环境
 - 典型思考模式：都是你们的错！
<font size=2 color=grey>【注】处在这个理解层次的人，当问题发生时首先会将问题归结成「环境不好」所以才产生这样的问题，所以寻找解决办法的时候基本只会从环境的角度去思考。</font>

2、第 4 流人才

 - 别名：行动派
 - 所处理解层次：行为
 - 典型思考模式：我还不够努力！
<font size=2 color=grey>【注】处在这个理解层次的人，问题发生时首先会归结成「因为我的努力还不够」所以发生这样的问题。现在很多互联网公司中比较典型，很多产品经理很多时候业绩不好就会疯狂压榨技术人员的时间，要求疯狂加班，本质上是一个意思。但是，问题是真的是努力了所有问题就能够迎刃而解了吗？其实未必，努力只是成功的一个必要条件，但并不是充分条件。</font>

3、第 3 流人才

 - 别名：战术家
 - 所处理解层次：能力
 - 典型思考模式：方法总比问题多！
<font size=2 color=grey>【注】处在这个层次的人，问题发生时首先会归结成「因为我的能力不足」产生的。往往达到这个层次的人，既具备了「行为层」的勤奋努力，又具备了「能力层」的方法套路。</font>

4、第 2 流人才
- 别名：战略家
 - 所处理解层次：BVR（信念/价值观/规条）
 - 典型思考模式：什么才是最重要的？
<font size=2 color=grey>【注】处在这个层次的人，问题发生时首先会思考「哪个是最重要的问题？」、「除了我看到的这些问题，还有什么更重要的问题我没看到？」这个层次的人会思考选择的重要性，正如很多人所信奉的`选择比努力更重要`的信条一样，选错了方向在努力也只会是做无用功。</font>

5、第 1 流人才
- 别名：觉醒者
 - 所处理解层次：身份
 - 典型思考模式：因为我是XXX，所以我会XXX
<font size=2 color=grey>【注】处在这个层次的人往往能够比较清楚地认识自己，知道自己是谁和想成为什么样的人。</font>

6、顶级人才
- 别名：领袖/伟人
 - 所处理解层次：精神/使命
 - 典型思考模式：人活着就是为了改变世界
<font size=2 color=grey>【注】这个层次的人疯狂到以为自己能够改变世界，比如乔布斯们。我们绝大多数人都是普通人，但不妨碍我们「利他」，因为从长期来看利他一定是利己。</font>

看完觉得还是要好好规划自己的人生，好好定义下自己的人生，没有目标的努力奋斗久而久之无用功越做越多。这些思维方式和思维层次也许想清楚了一小部分，我们的进步就会发生质的飞跃。
<br>

