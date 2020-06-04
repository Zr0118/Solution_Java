package day6_3_20;
/* 题目描述：给你一颗二叉树的一个结点，返回中序遍历顺序中这个结点的下一结点。
            二叉树不仅有左右孩子指针，还有指向父亲结点的指针。*/

import TreeUtil.TreeNode;

public class Review {
    public TreeNode solution(TreeNode node){
        if(node == null) return null; // 判断是否为空树

        // 1.判断是否存在右子树，如果存在右子树
        // 那么中序遍历的下一个节点必定是右子树中的最左侧节点
        if(node.right!=null){
            node = node.right; //进入右子树
            while(node.left!=null){ // 如果当前节点存在左子树，当不存在左子树时直接返回当前节点
                node = node.left; // 进入左子树
            }
            return node;
        }

        // 2.不存在右子树的情况
        // 那么中序遍历的下一个节点必定就在父辈节点中
        // 向上找第一个左链接指向的树包含该节点的祖先节点
        while (node.next!=null){ // 如果判断到根节点就结束
            if(node.next.left == node){
                return node.next;
            }
            node = node.next;
        }
        return null;

    }

}
