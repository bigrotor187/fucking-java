package frequency.array.easy;

import java.util.Arrays;

/**
 * <p>
 *
 * 题目描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1：
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例2：
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * </p>
 *
 * @author Rotor
 * @since 2019/7/31 23:04
 */
public class _66_PlusOne {

    /**
     * 思路：1. 当数组中元素的值小于 9 时，不涉及到进位，直接加 1 即可，比如数组 {4, 3, 2, 1}中的元素 4，3，2，1 都小于 9，
     * 则只需遍历到第一个元素为 1 时，加 1 变为 2 退出即可；
     * 2. 当数组中的元素大于等于 9（由题意可知这里最大为 9）时，涉及到进位，比如 {1， 9， 9}，加 1 之后补 0 进 1，直到数组中
     * 某个元素值小于 9 时，直接加 1 退出即可，如 {1，9， 9}加 1 后变为 {2， 0， 0}，而 {9， 9 ， 9}中由于每个元素均 >=9，加
     * 1 进位后最终数组长度会变长一位，加 1 后低位补 0，所以直接新建一个长度为 n+1 的新数组，第 1 位置 1 即可。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param digits 数组
     * @return 加 1 之后的新数组
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArr = new int[n + 1];
        newArr[0] = 1;
        return newArr;
    }

    public static void main(String[] args) {
        int[] digits1 = {4, 3, 2, 1};
        int[] digits2 = {9, 9, 9, 9};
        System.out.println("digits1 : " + Arrays.toString(plusOne(digits1)));
        System.out.println("digits1 : " + Arrays.toString(plusOne(digits2)));
    }
}

/*
output:
        digits1 : [4, 3, 2, 2]
        digits1 : [1, 0, 0, 0, 0]
*/
