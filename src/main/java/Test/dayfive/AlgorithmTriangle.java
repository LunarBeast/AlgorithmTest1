package Test.dayfive;

import org.omg.CORBA.INTERNAL;

public class AlgorithmTriangle {
    /*
     * 题目：给定一正整数数组，找出数组中能够组成三角形的最大周长。
     * 解析：1、满足构成三角形的条件 --- 两边之和大于第三边
     *       2、找到最大周长
     * 题解：贪心算法思想从数组尾找最后3个正数，判断是否符合三角形，符合的话组成的数组就是最大的perimeter；
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4};
//        System.out.println(findMaxPerimeter(nums));
        System.out.println(findMaxPerimeterFinal(nums));
    }

    public static int findMaxPerimeter(int[] nums){
        if (nums.length < 3) {
            return 0;
        }
        int max = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                sum = nums[i] + nums[i - 1] + nums[i - 2];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    //修改：
    public static int findMaxPerimeterFinal(int[] nums){
        if (nums.length < 3) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
/*
*  问题：
*   1、遍历时 i >= 0 优化为 i >= 2;
*       前面还需要判断循环到只剩2个数字的情况，后一种直接过滤掉这种情况了；
*   2、代码不够简洁，max，sum变量不需要定义，
*
* */
