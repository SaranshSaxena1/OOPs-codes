import java.util.Stack;

public class MinimumStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    
    public MinimumStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    
    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        int removed = mainStack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    
    public int peek() {
        if (mainStack.isEmpty()) {
            return -1; 
        }
        return mainStack.peek();
    }

    
    public int top() {
        if (mainStack.isEmpty()) {
            return -1; 
        }
        return mainStack.pop();
    }

    
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1; 
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinimumStack stack = new MinimumStack();
        stack.push(5);
        stack.push(2);
        stack.push(10);
        stack.push(1);

        System.out.println("Minimum Element: " + stack.getMin()); 
        stack.pop();
        System.out.println("Minimum Element: " + stack.getMin()); 
        stack.pop();
        System.out.println("Top Element: " + stack.top());         
    }
}
