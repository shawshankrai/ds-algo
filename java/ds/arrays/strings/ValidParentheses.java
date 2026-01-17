package ds.arrays.strings;

import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if(stack.isEmpty()) return false;

                char popped = stack.pop();
                if(popped == '(' && curr != ')') return false;
                if(popped == '[' && curr != ']') return false;
                if(popped == '{' && curr != '}') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("{[]}"));      // true
        System.out.println(isValid(""));          // true
    }
}