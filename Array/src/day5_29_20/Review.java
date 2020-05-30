package day5_29_20;


/*
 题目描述: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
          数组中某些数字是重复的，但不知道有几个数字是重复的，
          也不知道每个数字重复几次。请找出数组中任意一个重复的数字。

          Input: {2, 3, 1, 0, 2, 5}
          Output: 2
*/

import java.util.Arrays;

// 这道题因为说了 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
// 所以这里将 数组中的值 与 index 之间的关系进行处理
public class Review {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 0, 2, 5};
        int len = input.length;
        int res[] = new int[1];
        solution(input,len,res);
        System.out.println(Arrays.toString(input));
        System.out.println(res[0]);
    }
    // 三个参数第一个第二个不多说了，第三个存放正确结果（也就是输出）
    private static boolean solution(int[] input, int len, int[] res) {
        if(len <= 0 || input == null){
            return false;
        }
        for (int i = 0; i <len ; i++) {
            while(i != input[i]){
                if(input[i] == input[input[i]]){
                    res[0] = input[i];
                    return true;
                }
                swap(input,i,input[i]); // 后两个参数写下标，不写下标对应的值，下标对应的值在swap中进行处理
            }
        }
        return false;
    }

    private static void swap(int[] input, int i, int i1) {
        int x = input[i];
        input[i] = input[i1];
        input[i1] = x;
    }
}
