package day5_30_20;

public class Review {
    public static void main(String[] args) {
        int x = 4;
        int[][] arr = {{1,2,3},{3,4,5},{4,5,6}};
        System.out.println(solution(arr,x));
    }

    // # 做题之前一定在纸上建立模型，把每一种情况都写下来
    private static boolean solution(int[][] arr, int tar) {
        if(arr == null || arr.length == 0 || arr[0].length==0){return false;}
        // 设置起始坐标 为 右上角的点
        int row = 0 ,col = arr[0].length-1;
        while(row<arr.length && col>=0){
            if(arr[row][col] == tar){
                System.out.printf("[%d][%d]\n",row,col); // Test
                return true;
            }else if(arr[row][col] > tar){
                col--;
            // 最后可以写else ，但是以后不要写else，把else if全写出来，提高程序可读性
            }else if(arr[row][col] < tar){
                row++;
            }
        }
        return false;
    }
}
