# 前言

欢迎关注我的 Github 仓库 https://github.com/bigrotor187/awesome-java-notes ，如果觉得有帮助，请点个 `star` 哟，目前主要在更 `leetcode题解（Java版）`和 `剑指offer题解（Java版）`，可以点个`star`。

# [33. Search in Rotated Sorted Array][title]

## Description

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

**Example 1:**

```java
输入: nums = [4,5,6,7,0,1,2], 
target = 0
输出: 4

```

**Example 2:**

```java
输入: nums = [4,5,6,7,0,1,2], 
target = 3
输出: -1
```

**Example 3:**

```java
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```

**Tags:** Array, Binary Search


## 思路 0

参考[这里](https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14436/Revised-Binary-Search)

循环链表中存在这样一个性质（事实）：将数组从中间点劈开，会将数组分成两部分，分别是`循环有序数组`部分和`有序数组`部分。

为了找到目标元素 `target`，我们可以先找到数组的有序部分，然后再判断目标元素是否在有序数组部分中。

- 如果首元素小于中间元素`mid`，那么前半部分是有序的，后半部分是循环有序数组（如 4 5 6 7 8 1 2 3）；
- 如果首元素大于中间元素 `mid`，那么后半部分是有序的，前半部分是循环有序数组（如 5 6 1 2 3 4）；
- 如果 `target` 在有序数组部分中，则对有序部分使用二分查找；
- 如果目标元素在循环有序数组中，则重新设定数组边界后，重复上述步骤。

> **注** 上述中，将数组  4 5 6 7 8 1 2 3 从中间元素 7（mid = 3） 劈开后分成了 4 5 6 的有序数组部分以及 8 1 2 3 的循环有序数组部分。

**时间复杂度：** O(logn) 
<br> 
**空间复杂度：** O(1) 

```java
public int search(int[] nums, int target) {
        int start = 0;
        int end  = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            if (target == nums[mid]) {
                return mid;
            }
            // 前面部分有序
            // 千万要注意这里的条件是 `nums[start] <= nums[mid]`，而不是 `nums[start] < nums[mid]`
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                   end = mid - 1;
                } else {
                    start = mid + 1;
                }
            // 后半部分有序
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

```


## 结语

如果你同我一样想要征服数据结构与算法、想要刷 LeetCode，欢迎关注我 GitHub 上的 LeetCode 题解：[awesome-java-notes][ajl]



[title]: https://leetcode.com/problems/search-in-rotated-sorted-array/
[ajl]: https://github.com/bigrotor187/awesome-java-notes
