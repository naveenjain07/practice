class Solution {
    
    //  Egde Case not handled Here  in for loop there is no while loop
   /** [4 ,3 ,1 ,2 ,2 ]
    public int findDuplicate(int[] nums) {
        // Get the length of the array to calculate target positions
        int n = nums.length;
        
        // Variable to hold the value during swaps and to return at the end
        int temp = 0;
        
        // Iterate through each index of the array
        for(int i = 0; i < nums.length; i++) {
            
            // Calculate the 0-based target index for the current number.
            // (Assumes values are related to the array length n)
            int correctPos = nums[i] % n - 1;
            
            // If the number is not already at its calculated target index
            if(correctPos != i) {
                
                // Read the value currently residing at the target index
                temp = nums[correctPos];
                
                // If the target index already has the same number, we found the duplicate
                if(temp == nums[i]) {
                    return temp;
                }
                
                // Swap the current number into its correct position
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }

        // Fallback return if no duplicate is caught inside the loop
        return temp;
    }*/

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // A while loop ensures the newly swapped number is also evaluated
            while (nums[i] - 1 != i) {
                int correctPos = nums[i] - 1;
                
                if (nums[correctPos] == nums[i]) return nums[i];
                
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }



}