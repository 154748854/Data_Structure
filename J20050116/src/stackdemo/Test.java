package stackdemo;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyStack mystack = new MyStack();
    }
    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Integer ret = stack.pop();
        System.out.println(ret);

        ret = stack.peek();
        System.out.println(ret);
    }
}
