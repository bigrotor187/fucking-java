package frequency.array.meduim;

import java.util.*;

/**
 * <p>
 *
 *  给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *  找出所有满足条件且不重复的三元组。
 *
 *  注意：答案中不可以包含重复的三元组。
 *
 *  示例：
 *
 *  例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *  满足要求的三元组集合为：
 *  [
 *    [-1, 0, 1],
 *    [-1, -1, 2]
 *  ]
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/2 21:15
 */
public class _15_ThreeSum {

    /**
     * 暴力解法
     *
     * 思路：三层循环，依次遍历所有可能的情况，但需要注意的是重复的情况，如{-1，0，1}与{0，-1，1}是同种情况，需要去重。但是
     * 暴力解法除了三层 for 循环之外，内部还嵌套了好几层，时间复杂度直接爆炸，在 leetcode 提交一般超过 O(n^3) 都不会被 ac。
     *
     * 时间复杂度：O(n^5）
     *
     * @param nums 数组
     * @return 满足条件的三元组集合
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<>(); // 不能放在循环之外，否则答案会出错
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        // 判断结果中是否已经存在相同的三元组
                        if (isExist(result, tmp)) {
                            continue;
                        }
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isExist(List<List<Integer>> result, List<Integer> tmp) {

        for (int i = 0; i < result.size(); i++) {
            // 判断两个 list 是否相同
            if (isEqual(result.get(i), tmp)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEqual(List<Integer> x, List<Integer> y) {

        Collections.sort(x); // 排序集合 x
        Collections.sort(y); // 排序集合 y
        for (int i = 0; i < x.size(); i++) {
            // 判断排序后的 list 中的每个元素是否相同
            if (x.get(i) != y.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针法
     *
     * 思路：遍历数组，通过 0 - nums[i] 表示 sum，即 sum = 0 - nums[i]，其中 nums[i] 表示当前的数，然后再遍历找出另外两个
     * 和为 sum 的数即为所求。但是，遍历找到当前数需要 O(n)，再遍历找到另外两个数需要 O(n^2)，总共需要 O(n^3)的时间复杂度。
     * 可以优化一下，通过双指针的方法，一个指向头，一个指向尾，这样寻找另外两个数只需 O(n)的时间复杂度，总共需要 O(n^2),
     * 时间复杂度一下降了一个数量级。
     *
     * 不过这里需要注意一下去重，为了保证不添加重复的 list，可以这么做：
     * 1. 遍历数组时，如果当前元素与上一个元素相等，则继续往后移；
     * 2. 找到一个满足条件的 list 后，当前指针要移到和当前元素不相等的位置。
     * 注：之所以可以这么做，是因为已经对数组进行了排序，数组已经是有序的。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：
     *
     * @param nums 数组
     * @return 满足条件的三元组集合
     */
    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        // 数组为空或元素个数小于 3，直接返回
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums); // 排序数组
        int i, lo, hi, sum;
        for (i = 0; i < nums.length - 2; i++) {
            // 如果升序排序后的数组第一个元素大于 0，说明肯定不存在符合条件的三元组集合，因为此时数组的最小元素为 nums[i]
            if (nums[i] > 0) {
                break;
            }
            // 由于数组有序，为了保证不加入重复的 list，所以如果当前元素与前一个元素相等，则往后移即可
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                lo = i + 1;
                hi = nums.length - 1;
                sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // 去重，元素相同往后移
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("threeSum1 : " + threeSum1(nums));
        System.out.println("threeSum2 : " + threeSum2(nums));
    }
}

/*output:
        threeSum1 : [[-1, -1, 2], [-1, 0, 1]]
        threeSum2 : [[-1, -1, 2], [-1, 0, 1]]
*/
