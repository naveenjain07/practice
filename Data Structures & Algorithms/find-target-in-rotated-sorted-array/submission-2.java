class Solution {
    public int search(int[] nums, int target) {
        int l = 0;

        int r = nums.length - 1;
        /**
        [3,4,5,6,1,2]. 1
        l = 0 r = 5 m = 2
        l = 3  r =5 m = 4

        *
      */

        while (l <= r) {
            int mid = l + ((r - l) / 2);
            System.out.println("mid " + mid);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > nums[r]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target <= nums[r] && target > nums[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
