package TreeUtil;

// https://www.javazhiyin.com/46048.html
// 父节点在day6/3中用到了
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next ; // 该属性指向节点的父节点，
    public TreeNode(int x) { val = x; }
}
