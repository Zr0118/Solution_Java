package day6_1_20;

import ListNodeUtil.ListNode;

import java.util.ArrayList;

// day6/15/20
/* 题目描述:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
/*
* public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){} // 初始头节点
    public ListNode(int x) { val = x; }
}
* */
public class Review3 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        // 递归
        ArrayList list = solution1(l1);
        System.out.println(list);
        // 头插法
        ArrayList list2 = printListFromTailToHead2(l1);
        System.out.println(list2);
    }
    // 头插法
    private static ArrayList printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode();
        while (listNode != null){
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    private static ArrayList solution1(ListNode node) {// 递归
        ArrayList<Integer> list = new ArrayList<>();
        if(node!=null) {
            list.addAll(solution1(node.next));
            list.add(node.val);
        }
        return list;
    }
}
