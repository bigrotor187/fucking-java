package frequency.array.meduim;

/**
 * <p>
 *
 * 题目描述：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 
 * 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 具体图片请查看原文链接。
 *
 * 示例：
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * </p>
 *
 * @author Rotor
 * @since  2019/7/29 21:27
 */
public class _11_ContainerWithMostWater {

    /**
     * 暴力解法
     *
     * 思路：矩形的面积 = 两条矩形的边（高度）中最小的值 * 两条边的下标差，所以循环遍历数组依次比较，
     * 即可找到这些面积中的最大者。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O()
     *
     * @param height 矩形高度
     * @return 矩形的最大面积
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        int n = height.length; // 数组的长度
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 矩形的面积 = 两条矩形的边（高度）中最小的值 * 两条边的下标差
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /**
     * 双指针解法
     *
     * 思路：矩形面积主要取决于两条线段之间的距离（坐标差）和两条线段中长度最短的那条的乘积。所以，想要矩形面积最大化，
     * 当然距离越远越好，两条线段中最短那条也越长越好。所以，可以设置头、尾两个指针，通过不断缩短两个指针之间的距离，
     * 不停越过较短那条线段来移动指针，不断更新矩形的最大面积 maxArea。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height 矩形高度
     * @return 矩形的最大面积
     */
    public int maxArea2(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        _11_ContainerWithMostWater containerWithMostWater = new _11_ContainerWithMostWater();

        System.out.println("maxArea1()执行结果：" + containerWithMostWater.maxArea1(height));

        System.out.println("maxArea2()执行结果：" + containerWithMostWater.maxArea1(height));
    }
}
