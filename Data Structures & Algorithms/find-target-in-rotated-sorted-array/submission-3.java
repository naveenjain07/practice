class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0; 
        int r = nums.length - 1;

        while(l <= r){
            int mid = l + ((r - l) / 2);
            
            if(nums[mid] == target) return mid;
            
            // Is the LEFT side the "normal" sorted side?
            if(nums[mid] > nums[r]) {
                // Yes! Now, does the target fall perfectly within this normal left side?
                if(target >= nums[l] && target < nums[mid]) {
                    r = mid - 1; // It does! Search the left.
                } else {
                    l = mid + 1; // It doesn't. It MUST be hiding on the right.
                }
            } 
            // The RIGHT side must be the "normal" sorted side
            else {
                // Does the target fall perfectly within this normal right side?
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1; // It does! Search the right.
                } else {
                    r = mid - 1; // It doesn't. It MUST be hiding on the left.
                }
            }
        }
        
        return -1;
    }
}