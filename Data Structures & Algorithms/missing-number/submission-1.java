class Solution {
   

    public int missingNumber(int[] nums) {
       int xor = 0;
        int i =0;
       for(i=0; i<nums.length;i++){
        xor = xor^i;
        xor = xor^nums[i];
       } 

       return xor^i;
    }


    /**
     public int missingNumber(int[] nums) {
        int xor = nums.length; // Pre-load the final 'n' value
        
        for (int i = 0; i < nums.length; i++) {
            // Combine the operations into a single statement
            xor ^= i ^ nums[i]; 
        } 
        
        return xor;
    }
    **/
}
