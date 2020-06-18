package day6_15_20;

// Day6/16/20 这题方法参数真他妈的多
// 再有 DFS（回溯）加递归 更不太好理解
public class Review {
    public static void main(String[] args) {
        // 创建一维数组
        char[] array = {'a','b','t','y','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        //char[][] res = sw(array,3,4);
        //System.out.println(Arrays.toString(res[0]) +Arrays.toString(res[1])+Arrays.toString(res[2]));
        boolean res = hasPath(array,3,4,str);
        System.out.println(res);
    }
    /* 控制方向 */
    private final static int[][] direction = {{-1, 0},{1, 0},{0, 1},{0,- 1}};
    private static int cols;
    private static int rows;

    public static boolean hasPath(char[] matrix, int row, int col,char[] str) {
        if(matrix==null || row==0 || col==0)return false;
        rows = row;
        cols = col;

        // 1.对数组进行升阶处理 -- 数组 转 矩阵
        char[][] res = sw(matrix,rows,cols);

        // 2.新建标记位数组
        boolean[][] marked = new boolean[rows][cols]; // boolean默认值为0

        // 3.准备初始结构 -- 遍历二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(DFS(res,marked,i,j,0,str)){// DFS -- 回溯函数
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * DFS深度搜索 -- 回溯思想
    * @param char[][] res       -- 待测矩阵
    * @param boolean[][] marked -- 标记位矩阵
    * @param int i              -- 行索引
    * @param int j              -- 列索引
    * @param int marklen        -- 达到规定匹配长度就返回true -- 同时也是递归出口
    * @param char[] str         -- 搜索路径
    *  */
    private static boolean DFS(char[][] res, boolean[][] marked, int i, int j, int marklen,char[] str) {
        if(marklen == str.length) return true; // 递归的出口
        // >=没注意到
        if(i>=rows || i<0 || j<0 ||j>=cols || res[i][j]!= str[marklen] || marked[i][j]){
            return false;
        }
        // 如果矩阵当前位置的值 与 待测路径的第marklen个位置上的字符相等 把当前位置进行标记
        marked[i][j] = true;
        for (int[] a:direction) // 递归的进行移动 -- 通过direction
            if(DFS(res,marked,i+a[0],j+a[1],marklen+1,str))
                return true; // 递归的最终出口
        marked[i][j] = false; // 最后如果匹配失败的话要递归的把每一步的标记位还原
        return false;
    }

    /* 数组 转 矩阵 */
    private static char[][] sw(char[] matrix, int rows, int cols) {
        char[][] memo = new char[rows][cols];
        for (int i = 0,index=0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                memo[i][j] = matrix[index++];
        return memo;
    }

}
