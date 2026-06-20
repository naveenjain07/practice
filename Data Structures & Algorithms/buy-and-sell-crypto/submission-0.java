class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int b = prices[0];
        for(int i =1 ; i <prices.length; i++){
           if(prices[i]<b){
            b = prices[i];
            continue;
           }   

           max = Math.max(max, prices[i]-b);

        }

        return max;
    }
}
