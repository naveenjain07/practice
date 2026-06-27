class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minRateRequired = 1;
        int maxRateRequired = 0;
        int totalBananas = 0;

        for (int i = 0; i < piles.length; i++) {
            maxRateRequired = Math.max(maxRateRequired, piles[i]);
            totalBananas = totalBananas + piles[i];
        }
        int l = minRateRequired;
        int r = maxRateRequired;
        int mid =0;
        int minRate = Integer.MAX_VALUE;
         while (l <= r) {
            mid = l+((r-l)/2);
            int totalTime =0;
            for(int i =0; i< piles.length; i++){
                totalTime = totalTime + (int)(Math.ceil((double)piles[i]/mid));
            }
            
            if(totalTime <= h){
                r = mid-1;
                minRate = Math.min(mid,minRate);
            }else{
                l = mid+1;
            }
        }

        return minRate;
    }
}
