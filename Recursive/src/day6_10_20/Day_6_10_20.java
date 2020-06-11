package day6_10_20;
/* 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
比如n=3时，2*3的矩形块有3种覆盖方法： */
/*
* n=1 1
* n=2 2
* n=3 3
* n=4 5
* */
public class Day_6_10_20 {
    public static void main(String[] args) {
        int a = 4;
        int res = RectCover(a);
        System.out.println(res);
    }
    // 法一: 利用递归 -- 由上至下
    private static int RectCover(int target) {
        if(target ==0 || target==1 || target== 2){
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }

    // 法二: 动态规划 -- 优化内存 ，由下而上
    private static int RectCover1(int target) {
        if(target<=2)return target;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= target; i++) { // 这里的i=3是因为前两个数字已经声明好了要计算只能从第三个开始
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
