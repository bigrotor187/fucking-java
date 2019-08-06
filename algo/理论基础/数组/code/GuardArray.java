package com.java.yxsi.algonrithm.array;

/**
 * @author Rotor
 * @date 2019/7/15 23:10
 *
 * 利用哨兵简化代码
 */
public class GuardArray {

    // 在数组 a 中，查找 key,返回 key 所在的位置
    // 其中，n 表示数组 a 的长度
    int find(char[] a, int n, char key) {
        // 边界条件处理，如果 a 为空，或者 n<= 0,说明数组中没有数据，就不用 while 循环比较了
        if (a == null || n <= 0) {
            return -1;
        }
        int i = 0;
        // 这里有两个比较操作：i<n 和 a[i]==key
        while (i < n) {
            if (a[i] == key) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    /**
     * 设置哨兵的方式
     *
     * 在数组 a 中，查找 key，返回 key 所在的位置,其中，n 表示数组的长度
     *
     * 两个例子：
     *
     * a = {4, 2, 3, 5, 9, 6} n=6 key=7
     * a = {4, 2, 3, 5, 9, 6} n=6 key=6
     *
     * @param a 数组名称
     * @param n 数组长度
     * @param key 指定要查找的值
     * @return
     */
    int findInGuard(char[] a, int n, char key) {
        if (a == null || n <= 0) {
            return -1;
        }

        // 这里因为要将 a[n-1] 的值替换成 key，所以要特殊处理这个值
        if (a[n - 1] == key) {
            return n - 1 ;
        }

        // 把 a[n-1]的值临时保存在变量 tmp 中，以便之后恢复。tmp=6
        // 之所以这样做，是希望 findInGuard()不要改变 a 数组中的内容
        char tmp = a[n - 1];
        // 把 key 的值放到 a[n - 1] 中,此时 a = {4, 2, 3, 5, 9, 7}
        a[n - 1] = key;

        int i = 0;
        // while 循环比起代码 find() 中的代码，少了 i < n 这个比较操作
        while (a[i] != key) {
            ++i;
        }

        // 恢复 a[n - 1] 原来的值，此时 a = {4, 2, 3, 5, 9, 6}
        a[n - 1] = tmp;

        if (i == n - 1) {
            // 如果 i == n-1, 说明在 0...n-2 之间没有值等于 key,所以返回 -1
            return -1;
        } else {
            // 否则，返回 i，就是元素值等于 key 的元素的下标
            return i;
        }
    }

    public static void main(String[] args) {
        GuardArray arr = new GuardArray();
        char[] a = {'1', '2', '3', '4'};
        int n = a.length;
        char key = 'a';
        int index = arr.findInGuard(a, n, key);
        System.out.println("----------" + index);
    }

}
