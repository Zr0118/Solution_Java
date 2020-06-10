package day5_29_20;
// day 5/29/30
// TODO: 5/30/2020  题目描述: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
//          数组中某些数字是重复的，但不知道有几个数字是重复的，
//          也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
//          Input: {2, 3, 1, 0, 2, 5}
//          Output: 2

// 这道题利用的是特性解题，还可以利用哈希表以及排序方式求解

// TODO: 5/30/2020 时间复杂度 / 空间复杂度
// 自己的思路：第一天开始写，自己根据题意写出来了，在写内外循环的时候一定要在纸上构建模型，脑子想想不出来
// 这道题如果都不存在if 与 for中的条件 则返回0
public class Day5_29_20 {
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

    // 这种方法构造了一种数组下标与值之间的练习（前提是数组的值都小于len并且大于0） -- 这代码写的太棒了
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) // 判断为空两种都写上
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) { //如果下标与值不相等就进去判断，，如果相等直接进入下一次循环
                if (nums[i] == nums[nums[i]]) { // 这里比较绕，将数组的下标与数组的值进行了比较
                    duplication[0] = nums[i]; // 这里开了个口子，最后就输出数组下标为0的值就可以了
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
