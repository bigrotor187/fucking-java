package frequency.array.easy;

/**
 * <p>
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例：
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/1 17:15
 */
public class _88_MergeSortedArray {

    /**
     * 思路：通过双指针 lastIndex1 和 lastIndex2 从尾开始遍历 nums1 和 nums2 两个数组，并依次比较，将较大的元素放入合并数组中
     *
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1) 合并数组末尾为空，不需要额外的存储空间
     *
     * @param nums1 数组 nums1
     * @param m 数组 nums1 初始元素个数
     * @param nums2 数组 num2
     * @param n 数组 nums 初始元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int lastIndex1 = m - 1; // nums1 最后一个元素索引
        int lastIndex2 = n - 1; // nums2 最后一个元素索引
        int lastIndex = m + n - 1; // 合并数组的最后一个元素索引

        while (lastIndex1 >= 0 && lastIndex2 >= 0) {
            if (nums1[lastIndex1] > nums2[lastIndex2]) {
                // 如果 nums1[lastIndex1] 更大，那么将 nums1[lastIndex1] 插入到合并数组（nums1）的 lastIndex 位置
                nums1[lastIndex] = nums1[lastIndex1];
                lastIndex1--;
            } else {
                // 如果 nums2[lastIndex2] 更大，那么将 nums2[lastIndex2] 插入到合并数组nums1）的 lastIndex 位置
                nums1[lastIndex] = nums2[lastIndex2];
                lastIndex2--;
            }
            lastIndex--;
        }

        /**
         * 1. 如果 lastIndex1 >= 0，而 lastIndex2 < 0，那么不需要做任何处理，因为合并数组（nums1）是有序的；
         * 2. 如果 lastIndex1 < 0，而 lastIndex2 >=0，那么意味着还未添加到合并数组中的元素都是 nums2 中的元素。
         */
        while (lastIndex2 >= 0) {
            nums1[lastIndex] = nums2[lastIndex2];
            lastIndex2--;
            lastIndex--;
        }
    }
}
