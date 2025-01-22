import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()) {
            for (int i = 0; i < s1.size(); i++) {
                s2.push(s1.pop());
            }
        }
        s2.pop();
        if(s1.empty() && s2.empty()) return -1;
    }
    
    public int peek() {
        if(s2.empty()) {
            for (int i = 0; i < s1.size(); i++) {
                s2.push(s1.pop());
            }
        }
        s2.pop();
        if(s1.empty() && s2.empty()) return -1;
        return s2.peek();

    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}