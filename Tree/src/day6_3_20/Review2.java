package day6_3_20;

import TreeUtil.TreeNode;

/*
* 题目描述：给你一颗二叉树的一个结点，返回中序遍历顺序中这个结点的下一结点。
            二叉树不仅有左右孩子指针，还有指向父亲结点的指针。
* */
public class Review2 {
    public TreeNode GetNext(TreeNode pNode)
    {
        if(pNode == null) return null;
        // 1.首先判断是否存在右节点，若存在，则返回右节点的最左侧节点
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        // 2.首先判断是否存在右节点，若不存在，则返回一定返回父节点，具体返回哪个父节点
        while (pNode.next != null){ // 停止到root节点为止
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next; // 这里少写了，忘了往上跳了
        }
        return null;
    }


}
