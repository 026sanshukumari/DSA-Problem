class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(min.isEmpty()){
            min.push(value);
        }else{
            min.push(Math.min(value, min.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */