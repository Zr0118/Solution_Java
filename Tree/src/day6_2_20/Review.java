package day6_2_20;

import TreeUtil.PrintTree;
import TreeUtil.TreeNode;
import java.util.Arrays;
// day6/3/20
// 这个递归反复看
/*题目描述
        输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
        假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如输入前序遍历序列{1,2,4,7,3,5,6,8}
        和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
public class Review {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode res = Solution(pre,in);
        PrintTree.print(res);
    }

    private static TreeNode Solution(int[] pre, int[] in) {
        if(pre.length==0 || in.length==0){
            return null;
        }
        // 首先根据先序确定树的根节点
        TreeNode root = new TreeNode(pre[0]);
        // 遍历中序 在中序中找到根节点
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                root.left = Solution(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = Solution(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}
