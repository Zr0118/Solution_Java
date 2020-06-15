package day6_12_20;

import java.util.Arrays;

/* 题目描述:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
           求该青蛙跳上一个n级的台阶总共有多少种跳法。 */
public class Day6_12_20 {
    public static void main(String[] args) {
        int index = 3;
        int res = JumpFloorII(index);
        System.out.println(res);
    }

    static private int JumpFloorII(int target) {
        int dp[] = new int[target];
        dp[0] = 1;
        int len = dp.length;
        for (int i = 1; i < len ; i++) {
            dp[i] = sum(dp)+1;
        }
        return dp[target-1];
    }

    private static int sum(int[] dp) {
        int len = dp.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += dp[i];
        }
        return res;
    }
    //法二代码简化
    public int JumpFloorII2(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    // 法三
    public int JumpFloorII3(int target) {
        return (int) Math.pow(2, target - 1); // 这里记一下pow方法
    }
}
