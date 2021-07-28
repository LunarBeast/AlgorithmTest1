package Test.daytwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmProblem2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println("暴力法： " + Arrays.toString(findSum(nums,10)));
        System.out.println("Map标记：" + Arrays.toString(findSum1(nums,10)));
        System.out.println("二分法： " + Arrays.toString(findSum2(nums,10)));
        System.out.println("双指针： " + Arrays.toString(findSum3(nums,10)));

    }
//  1、
    public static int[] findSum(int[] nums,int target){
        for (int i = 1;i<nums.length;i++){
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0, 0};
    }

    //   2、
    public static int[] findSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    //    3、
    public static int[] findSum2(int[] nums, int target) {
        for (int i =0;i<nums.length;i++){
            int low = i,high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]){
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else if (nums[mid] < target - nums[i]) {
                    low = mid + 1;
                }
            }
        }
        return new int[]{0};
    }
    /*
    * while条件少写等号，结果不正确；
    *
    * */
//    4、
    public static int[] findSum3(int[] nums,int target){
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
            if (nums[left] + nums[right] == target){
                return new int[]{left, right};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }
        }
        return new int[]{0};
    }
    /*
     * 直接while循环就可以，外面不需要在加for循环；
    */
}
