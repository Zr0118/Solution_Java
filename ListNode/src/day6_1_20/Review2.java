package day6_1_20;

import ListNodeUtil.ListNode;

import java.util.ArrayList;

// Day6/3/20
/* 题目描述:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
public class Review2 {
    public static void main(String[] args) {
        // 构造ListNode 1 - 2 - 3
        ListNode fristnode = new ListNode(1);
        ListNode secondnode = new ListNode(2);
        ListNode thirdnode = new ListNode(3);
        fristnode.next=secondnode;
        secondnode.next=thirdnode;
        ArrayList arr = solution(fristnode);
        ArrayList arr2 = solution2(fristnode);
        System.out.println(arr);
        System.out.println(arr2);
    }

    private static ArrayList solution2(ListNode node) {
        ListNode head = new ListNode();
        while (node !=null){
            ListNode memo = node.next;
            node.next = head.next;
            head.next=node;
            node=memo;
        }
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }

        return list;
    }

    // Recursive
    private static ArrayList solution(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        if(node!=null){
            list.addAll(solution(node.next));
            list.add(node.val);
        }
        return list;
    }




}
