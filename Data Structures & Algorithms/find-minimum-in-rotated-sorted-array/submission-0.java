class Solution {
    public int findMin(int[] nums) {
        
        int l = 0; 
        int r = nums.length - 1;

        // Note: l < r, NOT l <= r. We want the loop to break 
        // exactly when l and r point to the same single element.
        while (l < r) {
            
            int mid = l + ((r - l) / 2);

            // Compare mid to the rightmost element
            if (nums[mid] > nums[r]) {
                // The rotation 'cliff' is on the right. 
                // The minimum MUST be to the right of mid.
                l = mid + 1;
            } else {
                // The right side is strictly increasing, so the minimum 
                // is either at mid, or somewhere to the left of mid.
                // We do NOT use mid - 1 here, because mid might be the minimum!
                r = mid;
            }
        }
        
        // When l and r converge, they are pointing at the smallest value.
        return nums[l]; 
    }
}