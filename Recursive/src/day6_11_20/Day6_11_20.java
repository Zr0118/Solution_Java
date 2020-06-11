package day6_11_20;
/*题目描述: 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
           求该青蛙跳上一个 n 级的台阶总共有多少种跳法。*/
public class Day6_11_20 {
    public static void main(String[] args) {
        int input = 0;
        int res = JumpFloor(input);
        System.out.println(res);
    }
    // 法一: 动态规划
    /*
    * n=1 1
    * n=2 2 11 | 2
    * n=3 3 111 | 21 | 12
    * n=4 5 1111 | 211 | 121 | 112 | 22
    * 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。
    * 而 n-1 和 n-2 阶台阶的跳法可以看成子问题
    * */
    public static int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int a=1;
        int b=2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = a+b;
            a = b;
            b=res;
        }
        return res;
    }
}
