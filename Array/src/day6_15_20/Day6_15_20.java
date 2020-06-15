package day6_15_20;
/* 回溯搜索是深度优先搜索（DFS）的一种。对于某一个搜索树来说（搜索树是起记录路径和状态判断的作用），
回溯和DFS，其主要的区别是，回溯法在求解过程中不保留完整的树结构，而深度优先搜索则记下完整的搜索树。 */


public class Day6_15_20 {
    public static void main(String[] args) {
        char[] array = {'a','b','t','y','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        // System.out.println(array.length);

        /* 维度转换测试 */
        // char[][] array2 = buildMatrix(array);
        // System.out.printf("%s\n%s\n%s\n", Arrays.toString(array2[0]),Arrays.toString(array2[1]),Arrays.toString(array2[2]));

        boolean res = hasPath(array,3,4,str);
        System.out.println(res);
    }

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int rows = 3;
    private static int cols = 4;

    public static boolean hasPath(char[] array, int row, int col, char[] str) {
        if (rows == 0 || cols == 0) return false;
        /* 为了static this 不能联用 这里采用更改形参的方式去做 */
//        this.rows = rows; // 设置行数
//        this.cols = cols; // 设置列数
        rows = row; // 设置行数
        cols = col; // 设置列数
        boolean[][] marked = new boolean[rows][cols];  // 采用一个bool类型的和原数组等大的数组来保存节点的访问状态
        char[][] matrix = buildMatrix(array);  // 本题的输入是数组而不是矩阵（二维数组），因此需要先将数。组转换成矩阵
        // System.out.println(matrix);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j)) // 每一个i,j坐标都会去调用backtracking函数
                    return true;
        return false;
    }
    /* matrix矩阵  str待测字符串 marked标记位  str[pathLen] -- pathLen（target）数组下标*/
    /* 在一次 计算中 / 递归中 pathLen的长度不会被初始化为0 只有计算下一节点时才会被初始化为0 */
    private static boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length) return true; // 匹配的index值 达到了 target数组的长度就返回为true
        if (r < 0 || r >= rows || c < 0 || c >= cols // matrix[r][c] != str[pathLen] 矩阵 与 target数组进行校验
                || matrix[r][c] != str[pathLen] || marked[r][c]) { //marked[r][c] 存放的都是布尔值 boolean默认值为0
            return false;
        }
        /* 把矩阵写下来 与  marked[r][c] 匹配再往下走*/
        marked[r][c] = true; // 标记有什么用 -- 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 防止转圈
        for (int[] n : next) // next 控制上下左右
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true; // 都匹配到了会递归的return true
        marked[r][c] = false;
        return false;
    }

    static private char[][] buildMatrix(char[] array) { // 通过控制行数列数 实现一维数组 转 矩阵
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++) // idx控制一维数组index
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }
}
