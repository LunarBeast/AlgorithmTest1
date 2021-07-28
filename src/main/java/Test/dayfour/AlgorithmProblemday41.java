package Test.dayfour;

public class AlgorithmProblemday41 {
    public static void main(String[] args) {
        int [] nums = new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5, 6,7};
        System.out.println(findlength(nums));
    }

    public static int findlength(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i ;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
