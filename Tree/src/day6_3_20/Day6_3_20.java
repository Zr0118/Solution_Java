package day6_3_20;
//Day6/3/20

/* 题目描述：给你一颗二叉树的一个结点，返回中序遍历顺序中这个结点的下一结点。
            二叉树不仅有左右孩子指针，还有指向父亲结点的指针。

Q1：首先问你一个问题，如果这道题出现在笔试题中，你会用什么方法做？如果出现在面试题中呢？
A1：我想你肯定有点疑惑，同一道题为什么还分出现在笔试题中还是面试题中呢？
    很显然，笔试题中只要能过就好，设计的算法丑点，慢点也无所畏，不一定需要最优解法，
    当然前提是能够通过。而面试中就不一样了，显然面试官希望听到最优解法。*/

import TreeUtil.TreeNode;
import java.util.ArrayList;

public class Day6_3_20 {
    public static void main(String[] args) {

    }
    // 优化写法
    // 根据中序遍历的规则，当结点存在右子树的时候，中序遍历的下一个结点为右子树的最左节点。
    // 但是当节点不存在右子树的时候，中序遍历的下一个结点必定为该节点的父辈节点。但是究竟是哪一辈呢？
    // 根据中序遍历特性，左父结点一定已经被中序遍历访问过，所以下一个结点一定是在父节点路径上的第一个右父节点。
    // 代码如下：
    public TreeNode GetNext(TreeNode pNode){
        if(pNode == null) return null;
        if(pNode.right != null){  // 当结点存在右子树的时候
            pNode = pNode.right;  // 进入右子树
            while(pNode.left != null) // 中序遍历的下一个结点为右子树的最左节点
                pNode = pNode.left;
            return pNode; // 返回就行了
        }
        // 下面当然是节点不存在右子树的情况
        while(pNode.next != null){ // 中序遍历的下一个结点必定为该节点的父辈节点
            if(pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

    // 暴力解法
    static ArrayList<TreeNode> list = new ArrayList<>();  // 存储中序遍历结果
    public TreeNode GetNext2(TreeNode pNode){
        TreeNode par = pNode;
        while(par.next != null){ // 随意给出一个树节点，对于这个节点一直输出父节点，直到输出根节点
            par = par.next;
        }
        InOrder(par); // 对根节点进行中序遍历，把遍历顺序存入到list
        for(int i=0;i<list.size();i++){ // 求输入节点在中序遍历中的下一个节点
            if(pNode == list.get(i)){
                return i == list.size()-1?null:list.get(i+1); // 如果是最后一个节点返回null
            }
        }
        return null;
    }
    public void InOrder(TreeNode pNode){
        if(pNode!=null){
            InOrder(pNode.left);
            list.add(pNode);
            InOrder(pNode.right);
        }
    }
}
