package frequency.array.easy;

/**
 * <p>
 *
 * 题目描述：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1：
 *
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/7/29 23:14
 */
public class _26_RemoveDuplicatesfromSortedArray {

    /**
     * 思路：由题可知数组是排序过的，所以可以设置快、慢两个指针 i 和 j，只要 nums[i] = nums[j]，则递增 j 跳过重复项。
     * 如果 nums[i] ！= nums[j]，说明跳过当前的重复项的运行已经结束，需要将nums[j]的值复制到nums[i+1]，然后递增 i，
     * 继续重复上述过程，直到遍历到数组末尾跳出为止。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @return 新数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                // 将nums[j]的值复制到nums[i+1]，然后递增 i
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        _26_RemoveDuplicatesfromSortedArray no26 = new _26_RemoveDuplicatesfromSortedArray();
        int length = no26.removeDuplicates(nums);
        System.out.println("新数组的长度为：" + length);
    }
}
