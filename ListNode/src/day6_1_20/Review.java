package day6_1_20;

import ListNodeUtil.ListNode;

import java.util.ArrayList;

// Day6/2/20 祝自己六一儿童节快乐~
/* 题目描述:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
public class Review {
    public static void main(String[] args) {
        ListNode fristnode = new ListNode(1);
        ListNode secondnode = new ListNode(2);
        ListNode thirdnode = new ListNode(3);
        fristnode.next = secondnode;
        secondnode.next = thirdnode;

        // solution1(fristnode); // 递归
         // 链表 -- 头插法
        System.out.println(solution1(fristnode));
        System.out.println(solution2(fristnode));
    }

    private static ArrayList solution2(ListNode listnode) {
        // 设置辅助节点 -- 头节点
        ListNode head = new ListNode(); // 头节点中不用存放值，只是辅助作用
        while(listnode!=null){
            ListNode memo = listnode.next; // 之后的步骤要对当前节点.next进行操作，所以这里先备份
            listnode.next = head.next; // 头插法精髓就在这两句
            head.next = listnode;  // 头插法精髓
            listnode = memo;
        }

        // 将listnode数据读取到 Arraylist中
        ArrayList<Integer> list = new ArrayList<>();
        head = head.next; // 头节点不进行遍历
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return list;
    }

    // 还是对递归没有概念 本题的if条件我在写的时候用了while 而不是if
    private static ArrayList solution1(ListNode listnode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listnode != null){
            list.addAll(solution1(listnode.next));
            list.add(listnode.val);
        }
        return list;
    }


}



