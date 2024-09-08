class MinStack {
    Stack<Integer> stack;
    List<Integer> list;
    // int min;
    public MinStack() {
        stack = new Stack<>();
        // min = Integer.MAX_VALUE;
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        if(list.size() > 0){
            list.add( Math.min(list.get(list.size()-1),val));
        }
        else{
            list.add(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(list.size() > 0){
            list.remove(list.size()-1);
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        // if(list.size() > 0){
            return list.get(list.size()-1);
        // }
        // return null;
        // return;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */