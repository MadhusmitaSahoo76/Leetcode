class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] next = new int[2][k+1];

        for(int idx=n-1;idx>=0;idx--){
            int[][] curr = new int[2][k+1];
            for(int canBuy=0;canBuy<2;canBuy++){
                for(int cap=1;cap<=k;cap++){
                    
                    int profit = 0;

                    if(canBuy == 1){
                        profit = Math.max(-prices[idx] + next[0][cap], 0 + next[1][cap]);
                    }
                    else{
                        profit = Math.max(prices[idx] + next[1][cap-1], 0 + next[0][cap]);
                    }

                    curr[canBuy][cap] = profit;
                }
            }
            next = curr;
        }

        return next[1][k];
    }
}