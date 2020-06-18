package day6_16_20;

public class Review2 {
    public static void main(String[] args) {

    }
    private static boolean checkSum(int threshold, int row, int col) {
        int sum = 0;
        while (row>0){
            sum+=row%10;
            row/=10;
        }
        while (col>0){
            sum+=col%10;
            col/=10;
        }
        return sum <= threshold;
    }
    public static int movingCount(int threshold, int rows, int cols) {
        // 1.声明标记位数组
        boolean[] visited = new boolean[rows*cols];
        // 2.参数都带进去
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols,int row,int col,boolean[] visited) {
        // 1.设置递归出口（下标不能越界）
        if(row<0 || row >= rows || col <0 || col >=cols) return 0;
        int i = row*cols+col;
        // 2.设置递归出口（不能重复访问）
        if(visited[i] || !checkSum(threshold,row,col)) return 0;
        // 3.标记位仅对已经被标识的位置做到约束作用
        visited[i] = true;
        return 1+movingCountCore(threshold,rows,cols,row+1,col,visited)
                +movingCountCore(threshold,rows,cols,row-1,col,visited)
                +movingCountCore(threshold,rows,cols,row,col+1,visited)
                +movingCountCore(threshold,rows,cols,row,col-1,visited);

    }
}
