package frequency.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例：
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/1 15:34
 */
public class _1_TwoSum {
    /**
     * 暴力解法
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @param target 给定值
     * @return 和等于给定值的两个整数的数组下标
     */
    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 双指针解法
     *
     * 时间复杂度：O(n)  只需要遍历一遍元素
     * 空间复杂度：O(n)  取决于哈希表存储元素个数
     *
     * @param nums 数组
     * @param target 给定值
     * @return 和等于给定值的两个整数的数组下标
     */
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println("twoSum1 : " + Arrays.toString(twoSum_1(nums, 6)));
        System.out.println("twoSum2 : " + Arrays.toString(twoSum_2(nums, 6)));
    }
}

/**
 * output:
 *      twoSum1 : [1, 2]  // 2 + 4 = 6
 *      twoSum2 : [1, 2] // 2 + 4 = 6
 */
