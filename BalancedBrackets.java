import java.util.Stack;

public class BalancedBrackets {

    
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        
        for (char c : s.toCharArray()) {
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "{{[()]}}";
        String s2 = "{[(])}";
        String s3 = "{{{[(())]}}}";

        System.out.println("String 1 is balanced: " + isBalanced(s1)); 
        System.out.println("String 2 is balanced: " + isBalanced(s2)); 
        System.out.println("String 3 is balanced: " + isBalanced(s3)); 
    }
}
