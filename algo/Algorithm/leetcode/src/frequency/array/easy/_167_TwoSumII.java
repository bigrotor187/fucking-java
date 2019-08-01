package frequency.array.easy;

import java.util.Arrays;

/**
 * <p>
 *
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明：
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例：
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2】
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/1 16:52
 */
public class _167_TwoSumII {
    /**
     * 暴力解法
     *
     * @param nums 数组
     * @param target 给定值
     * @return 和等于给定值的两个整数的数组下标
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * 双指针解法
     *
     * @param nums 数组
     * @param target 给定值
     * @return 和等于给定值的两个整数的数组下标
     */
    public static int[] twoSum2(int[] nums, int target) {
        // 定义 left 和 right 两个双指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println("twoSum1 : " + Arrays.toString(twoSum1(nums, 9)));
        System.out.println("twoSum2 : " + Arrays.toString(twoSum2(nums, 9)));
    }
}

/**
 * output:
 *      twoSum1 : [1, 2]  // 2 + 4 = 6，正常应为[0,1]，但根据题目要求下标从 1 开始，所以返回的下摆哦相应要加 1
 *      twoSum2 : [1, 2] // 2 + 4 = 6
 */
