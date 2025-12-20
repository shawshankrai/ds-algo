package ds.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int i) {
        stack.push(i);
        if(minStack.isEmpty()) {
            minStack.push(i);
        } else {
            minStack.push(Math.min(i, minStack.peek()));
        }
    }

    public void pop() {
        if(stack.empty()) return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return Integer.MIN_VALUE;
            return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) return Integer.MAX_VALUE;
            return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(2);
        ms.push(2);
        ms.push(7);
        System.out.println(ms.getMin()); // 2
        ms.pop(); // pop 7
        System.out.println(ms.getMin()); // 2
        ms.pop(); // pop 2
        System.out.println(ms.getMin()); // 2 (still 2 because another 2 exists)
        ms.pop(); // pop 2
        System.out.println(ms.getMin()); // 5
    }
}
