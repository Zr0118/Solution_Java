package day5_29_30;
// day 5/29/30

/*
 题目描述: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
          数组中某些数字是重复的，但不知道有几个数字是重复的，
          也不知道每个数字重复几次。请找出数组中任意一个重复的数字。

          Input: {2, 3, 1, 0, 2, 5}
          Output: 2
*/

// 自己的思路：第一天开始写，自己根据题意写出来了，在写内外循环的时候一定要在纸上构建模型，脑子想想不出来
// 这道题如果都不存在if 与 for中的条件 则返回0
public class Day5_29_30 {
    public static void main(String[] args) {
        int[] a = {2,3,1,0,2,5};
        int res = solution(a);
        System.out.println(res);
    }

    private static int solution(int[] a) {
        if(a == null){return 0;} // 首先判断是否为空
        int len = a.length;
        for (int i = 0; i <= len-i-1; i++) { // 外循环判断比较轮数
            for (int j = i+1; j < len ; j++) { // 内循环判断具体与谁进行比较
                if(a[i] == a[j]){
                    return a[i];
                }
            }
        }
        return 0;
    }

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) // 判断为空两种都写上
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
