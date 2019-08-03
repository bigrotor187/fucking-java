package frequency.array.easy;

import java.util.Arrays;

/**
 * <p>
 *
 *  题目描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *  示例：
 *
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 *  说明：
 *
 *  1. 必须在原数组上操作，不能拷贝额外的数组。
 *  2. 尽量减少操作次数。
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/3 20:27
 */
public class _283_MoveZeroes {
    /**
     * 思路：遍历一遍数组，判断当前元素是否等于 0，如果不为 0，依次从数组第一个索引开始将非零元素从头依次赋值，
     * 然后后续元素依次补零即可。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     */
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0; // 非零元素从数组第一个位置开始插入（赋值）
        for (int num : nums) {
            if (num != 0) {
                // 将当前的非零元素依次从数组头开始插入
                nums[insertPos++] = num;
            }
        }
        // 遍历完数组之后，非零元素都已经插入到数组的前 0~insertPos 的位置中，需要将 insertPos 之后的元素补零
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    /**
     * 上面的方法中，可以狠命显得看出如果数组元素非零，就会触发依次插入（赋值）操作，可以优化一下。可以想象一下，如果一个数组
     * 全是非零元素，比如 {1，2，3，4，5}，我们完全可以不用每次的赋值，直接跳过就行。所以我们可以加一个判断，如果 insertPos==i，
     * 则可以判断出当前元素之前的元素肯定都是非零元素，继续往下遍历即可，无需赋值操作。反之，insertPos != i 时才赋值。
     * @param nums 数组
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前元素非零
            if (nums[i] != 0) {
                if (insertPos != i) { // 如果 insertPos != i,执行赋值操作
                    nums[insertPos] = nums[i];
                    nums[i] = 0;
                }
                insertPos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums2 = {0,1,0,3,12};
        moveZeroes1(nums);
        System.out.println("moveZeroes1 " + Arrays.toString(nums));
        moveZeroes2(nums2);
        System.out.println("moveZeroes2 " + Arrays.toString(nums2));
    }

}
