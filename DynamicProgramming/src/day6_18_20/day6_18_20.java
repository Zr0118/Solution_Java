package day6_18_20;
/*
* 题目描述
把一根绳子剪成多段，并且使得每段的长度乘积最大。
    n = 2   return 1 (2 = 1 + 1)
    n = 10  return 36 (10 = 3 + 3 + 4)
* */
public class day6_18_20 {
    public static void main(String[] args) {
        int res = integerBreak(10);
        System.out.println(res);
        int res2 = integerBreak2(10);
        System.out.println(res2);
    }

    static public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));// 看md 自己写写不出来估计
        return dp[n];
    }
}
