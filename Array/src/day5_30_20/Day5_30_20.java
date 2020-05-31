package day5_30_20;
// day5/30/20
// TODO: 5/31/2020     题目描述:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
//    每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数
//    判断数组中是否含有该整数。

// 这是一道对二维数组进行二分查找的算法，考察对二分查找的灵活运用
// 总结 这里需要总结的就是二分查找的特点，用在数组中，必须是有序数组，并且在本题中扩展了二维的用法
public class Day5_30_20 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{2,3,4},{3,4,5}}; // 二维数组静态声明
        int x = 4;
        solution(arr,x);
        solution2(arr,x);

    }
    // 利用特性解题 -- 有序二维数组 并且还要查找 考点就是二维数组中的二分查找
    public static boolean solution2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    // 这题我做的话就是一个一个遍历  -- 暴力算法 但是这么做的话题目中的一句话就浪费了
    // 每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排序
    private static boolean solution(int[][] arr, int x) {
        if(arr.length<=0 || arr == null){return false;}
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j] == x){return true;}
            }
        }
        return false;
    }
}
