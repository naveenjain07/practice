class Solution {
    public int search(int[] nums, int target) {
        int res = -1;

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + ((r - l) / 2);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

/*
    reason of mid-1 && mid+1
    Imagine your search space shrinks down to just two numbers: [0, 5] and you are looking for
    target = 5.

    l = 0, r = 1.

    mid = 0 + (1 - 0) / 2 which equals 0.

    nums[0] is 0. It is less than 5.

    Your code runs l = mid, so l becomes 0.

    The loop restarts. l = 0, r = 1, mid = 0. l = mid. (You are trapped forever!)
    **/
}
