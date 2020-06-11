package day6_5_20;

import java.util.Stack;

/* 题目描述: 用两个栈来实现一个队列，完成队列的Push和Pop操作。
    队列中的元素为int类型。
 */
public class Review {
    static Stack<Integer> in = new Stack<>();
    static Stack<Integer> out = new Stack<>();


    public static void main(String[] args) throws Exception {

        Review test = new Review();
        test.push(1);
        test.push(2);
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
}

    private void push(int i) {
        in.push(i);
    }

    private int pop() throws Exception {
        while(!in.empty()){
            out.push(in.pop());
        }

        if (out.isEmpty()) throw new Exception("queue is empty"); // 这里也可以进行try catch
        // 不过这种写法之前不怎么老写

        return out.pop();
    }
}
