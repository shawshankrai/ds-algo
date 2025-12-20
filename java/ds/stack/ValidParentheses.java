package ds.stack;

import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s) {
        if(s == null) return false;

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;

                Character top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[]}")); 
        System.out.println(isValid("{[]}((")); 
    }
}
