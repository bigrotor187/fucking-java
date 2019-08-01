package frequency.array.easy;

import java.util.Arrays;

/**
 * <p>
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1：
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2：
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/1 18:25
 */
public class _189_RotateArray {

    /**
     * 思路：
     * 1. 先对整个数组进行翻转，比如 {1,2,3,4,5,6,7}，整个数组反转之后变成：{7，6，5，4，3，2，1}；
     * 2. 对下标为 0~k-1 之间的元素进行翻转，即翻转 7,6,5 三个元素，反转后数组变成：{5,6,7,4,3,2,1};
     * 3. 最后对 k~(nums.length-1) 之间的元素进行翻转，翻转之后数组变成：{5,6,7,1,2,3,4}。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1) 只需要一个临时的额外空间存储临时变量 nums[start]
     *
     * @param nums 数组
     * @param k 向右移动 k 个位置
     */
    public static void rotate(int[] nums, int k) {
        // 对 k 进行取模，当 k 大于或等于数组的长度时，则相当于取余。比如数组{1，2，3}，k=7时，相当于k=1的情况。
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); // 翻转整个数组
        reverse(nums, 0, k - 1); // 翻转 0~k-1 之间的元素
        reverse(nums, k, nums.length - 1); // 翻转 k~nums.length-1 之间的元素
    }

    private static void reverse(int[] nums, int start, int end) {
        int tmp = 0; // 定义在循环外，避免每循环一次就创建一次
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("翻转前的数组为：" + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("翻转后的数组为：" + Arrays.toString(nums));
    }
}

/*
output:
    翻转前的数组为：[1, 2, 3, 4, 5, 6, 7]
    翻转后的数组为：[5, 6, 7, 1, 2, 3, 4]
*/
