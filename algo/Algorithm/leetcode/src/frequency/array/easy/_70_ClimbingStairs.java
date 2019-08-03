package frequency.array.easy;

/**
 * <p>
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *  注意：给定 n 是一个正整数。
 *
 *  示例 1：
 *
 *   输入： 2
 *   输出： 2
 *   解释： 有两种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶
 *   2.  2 阶
 *
 *   示例 2：
 *
 *   输入： 3
 *   输出： 3
 *   解释： 有三种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶 + 1 阶
 *   2.  1 阶 + 2 阶
 *   3.  2 阶 + 1 阶
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/8/3 21:15
 */
public class _70_ClimbingStairs {
    /**
     * 暴力解法（递归）
     *
     * 解题思路：这个一看有点斐波那契数列的意味，比如要求 3 两层楼的爬法，我们可以转换成求 2 层楼的爬法和 1 层楼的爬法，
     * 4 层楼的爬法可以转换成 3 层楼的爬法 + 2 层楼的爬法，依次递归遍历可以找到问题的解。其实就是斐波那契数列:
     * f(n)=f(n-1)+f(n-2)，但这种方法有局限性，当递归太深的时候因为重复计算容易导致栈溢出，时间复杂度高得吓人，直接原地爆炸。
     *
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     *
     * @param n 楼层数
     * @return 爬到楼顶的方法种数
     */
    public static int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 非递归解法
     *
     * 思路：借助两个变量 stepOne 和 stepTwo，每次将 stepOne 和 stepTwo 相加后赋值给 result，然后将 stepTwo 赋值给 stepOne，
     * 将 result 赋值给 stepTwo。由于只需要从遍历一遍，所以时间复杂度为 O(n)，另外不需要额外的存储空间，所以空间复杂度为 O(1)。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n 楼层数
     * @return 爬到楼顶的方法种数
     */
    public static int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int stepOne = 1;
        int stepTwo = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = stepOne + stepTwo;
            stepTwo = stepOne;
            stepOne = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("climbStairs1 " + climbStairs1(15));
        System.out.println("climbStairs2 " + climbStairs2(100));
    }
}
