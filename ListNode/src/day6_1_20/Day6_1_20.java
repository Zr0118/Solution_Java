package day6_1_20;

import ListNodeUtil.ListNode;
import java.util.ArrayList;

//总结 链表头插法这道题用到了,还给了一种递归的算法,明天再看看递归算法,今天没想明白,头插法明天也看看

// Day6/1/20 祝自己六一儿童节快乐~
/* 题目描述:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/
public class Day6_1_20 {
    public static void main(String[] args) {
//        ListNode head=new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
//        head.next=firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        System.out.println(printListFromTailToHead(firstNode));
        System.out.println(printListFromTailToHead1(firstNode));

//        System.out.println(head.next.next.val);
    }

    /*使用递归要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，
    最后再打印第一个节点 1。而链表 2->3 可以看成一个新的链表，要逆序打印该链表可以继续使用求解函数，
    也就是在求解函数中调用自己，这就是递归函数。*/
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            // addAll()向集合中加入集合,无index参数默认加到最后
            ret.addAll(printListFromTailToHead(listNode.next));
            // add()向集合中添加某个值,无index参数默认加入到最后
            ret.add(listNode.val);
        }
        return ret;
    }

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        // 头插法构建逆序链表
        // 1 - 2 - 3
        ListNode head = new ListNode(); // 新建头节点 val = null
        while (listNode != null) {
            ListNode memo = listNode.next; // memo = 2 - 3
            listNode.next = head.next; // listnode = 1 - null -- 头插法具体体现在这两句身上了41 ,42
            head.next = listNode;// head = head - 1 - null
            listNode = memo; // listnode = 2 - 3
        }
        // 头插法 最后变成 null - 3 -2 -1

        // 构建 ArrayList 并且从head.next开始打印
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }


}
