class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        
        // 1. Find the largest pile. 
        // This is the absolute maximum speed Koko would ever need, 
        // because eating faster than the biggest pile doesn't save any extra time.
        int maxPileSize = 0;
        for (int pile : piles) {
            maxPileSize = Math.max(maxPileSize, pile);
        }
        
        // 2. Set up our Binary Search boundaries for eating speed
        int l = 1;  //minSpeed      // She must eat at least 1 banana per hour
        int r = maxPileSize;   // maxSpeed // She never needs to eat faster than the biggest pile
        
        int optimalSpeed = r; // Default to the worst-case valid speed
        
        // 3. Binary Search to find the lowest valid speed
        while (l <= r) {
            
            // Pick a speed right in the middle to test
            int mid = l + ((r - l) / 2);
            
            // 4. Test the current speed: How many hours will it take?
            long hoursNeeded = 0; 
            for (int pile : piles) {
                // Math.ceil handles the rule: "If the pile has less bananas than her speed, 
                // she eats them and stays until the hour is up."
                hoursNeeded += (long) Math.ceil((double) pile / mid);
            }
            
            // 5. Evaluate the results of our test
            if (hoursNeeded <= h) {
                // Success! She finished in time. 
                optimalSpeed = mid; // Save this working speed
                r = mid - 1; // Now, let's see if she can go even SLOWER
            } else {
                // Fail! It took too long.
                l = mid + 1; // She needs to eat FASTER
            }
        }

        // 6. Return the absolute lowest speed that worked
        return optimalSpeed;
    }

    
    
    /**
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
    **/
}
