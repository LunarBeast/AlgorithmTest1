package Test.daythree;

public class AlgorithmProblem3 {
    public static void main(String[] args) {
        System.out.println(functions(10));
        int[] arr = new int[11];
        System.out.println(function2(arr,10));
        System.out.println(function3(0));
    }

    /*
     * 1、
     * 时间复杂度 O(n^2) 空间复杂的O(1)
     * */
    public static int functions(int num) {
        if (num == 0){
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return functions(num - 1) + functions(num - 2);
    }

    /*
     *  去重递归，初步
     * 时间复杂度O(n)，空间复杂度O(n)
     * */
    public static int function2(int[] arr,int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        return function2(arr, num - 1) + function2(arr, num - 2);
//      使用数组保存每次递归的值，去除重复计算的步骤
    }

    /*
     * 去重递归，进阶 ---> 双指针迭代
     * */
    public static int function3(int num) {
        int low = 0, high = 1;
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        for (int i = 2;i<=num;i++){
            int tmp = low + high;
            low = high;
            high = tmp;
        }
        return high;
    }
}
