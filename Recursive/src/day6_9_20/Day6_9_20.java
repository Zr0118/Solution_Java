package day6_9_20;

//Day6/9/20 动态规划
/* 题目描述：现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。 */
public class Day6_9_20 {
    public static void main(String[] args) {
        int index = 2;
        int res = Fibonacci(index);
        System.out.println(res);
    }
    // 时间复杂度 O(2^n)
    // 方法一
    static int Fibonacci(int n) {
        if (n==0 || n==1) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    // 动态规划 由下而上
    static int Fibonacci2(int n) {
        int ans[] = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    // 优化存储 -- 仅用到了两个变量
    static public int Fibonacci3(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int sum = 0;
        int two = 0;
        int one = 1;
        for(int i=2;i<=n;i++){
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}
