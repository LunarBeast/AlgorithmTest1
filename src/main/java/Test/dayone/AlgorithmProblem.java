package Test.dayone;

import java.util.Arrays;

public class AlgorithmProblem {
    public static void main(String[] args) {
//        测试数组
        int[] nums = new int[]{1, 3, 4, 5, 6};
        int[] nums1 = new int[]{-5, -4, 0, 2, 6};
        System.out.println("排序法: " + sortMethod(nums));
        System.out.println("排序法: " + sortMethod(nums1));
        System.out.println("***********************");
        System.out.println("线性查找： " + linearSearch(nums));
        System.out.println("线性查找： " + linearSearch(nums1));
    }

    /*
     *  题1:三个数最大乘积
     *  解法一：排序法
     */
    public static int sortMethod(int[] nums){
//      先判断数组长度
        if (nums.length < 3) {
            return 0;
        }
//      先排序
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
    }
    /*
     *  解法二：线性查找法
     *  只要拿到5个数即可，最大值 - 第三大值 ，最小值 第二小值
     */
    public static int linearSearch(int[] nums){
//      先判断数组长度
        if (nums.length < 3){
            return 0;
        }
        int max = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE,min1 = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x > max){
                max2 = max1;
                max1 = max;
                max = x;
            } else if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
            if (x < min){
                min1 = min;
                min = x;
            } else if (x < min1) {
                min1 = x;
            }
        }
        return Math.max(min * min1 * max, max * max1 * max2);
    }
}
/*
* 错误：linearseacher在定义最大值和最小值时注意，起始的最大值赋值Integer的最小值，最小值赋值Integer最大值，否则会
*       导致后面的判断永不成立；
* */
