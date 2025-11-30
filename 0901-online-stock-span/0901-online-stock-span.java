class StockSpanner {
    Stack<int[]> decreasingStack;

    public StockSpanner() {
        decreasingStack = new Stack<>();
    }
    
    public int next(int price) {
        int nextSpan = 1;

        while(!decreasingStack.isEmpty() && decreasingStack.peek()[0] <= price){
            nextSpan += decreasingStack.peek()[1];
            decreasingStack.pop();
        }

        decreasingStack.push(new int[]{price,nextSpan});
        return nextSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */