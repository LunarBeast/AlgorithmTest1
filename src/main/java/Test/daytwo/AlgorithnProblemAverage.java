package Test.daytwo;

public class AlgorithnProblemAverage {
    public static void main(String[] args) {
        int[] nums = new int[]{5,9,1,5,-8,12};
        System.out.println(getAverage(nums, 3));

    }

    public static String getAverage(int[] nums,int k) {
        if (k > nums.length) {
            return "无解";
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            int sum = max - nums[i - k] + nums[i];
            Math.max(max, sum);
        }
        double result = 1.0 * max / k;
        return "结果： " + result;
    }
}
