package day6_5_20;

import java.util.Stack; 
// Day6/5/20
/* 题目描述: 用两个栈来实现一个队列，完成队列的Push和Pop操作。
    队列中的元素为int类型。
 */
public class Day6_5_20 {
    static Stack<Integer> in = new Stack<>();
    static Stack<Integer> out = new Stack<>();

    public static void push(int node) {
        in.push(node);
    }

    static public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        Day6_5_20 test = new Day6_5_20();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
