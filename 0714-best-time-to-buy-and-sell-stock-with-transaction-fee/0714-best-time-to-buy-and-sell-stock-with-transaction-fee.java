class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] maxp = new int[prices.length][2];

        for(int[] temp: maxp){
            Arrays.fill(temp,-1);
        }

        return buysellworker(prices,fee,0,1,maxp);
    }

    public int buysellworker(int[] prices, int fee, int index, int buystock, int[][] maxp){

        if(index == prices.length){
            return 0;
        }

        if(maxp[index][buystock] == -1){
        
            int ans = buysellworker(prices,fee,index+1,buystock,maxp);

            if(buystock == 1){
                maxp[index][buystock] = Math.max(ans, buysellworker(prices,fee,index+1,0,maxp) - prices[index]);
            }

            else{

                maxp[index][buystock] = Math.max(buysellworker(prices,fee,index+1,1,maxp)+ prices[index]-fee,ans);
            }
        }

        return maxp[index][buystock];
    }
}