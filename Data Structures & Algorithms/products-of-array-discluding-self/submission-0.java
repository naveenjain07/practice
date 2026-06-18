class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int pre[] = new int[l];
        int post[] = new int[l];

        pre[0] = 1;
        post[l - 1] = 1;
        int j = l - 2;
        for (int i = 1; i < l; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[j] = post[j + 1] * nums[j + 1];
            j--;
        }

        for(int i=0; i<l;i++){
            pre[i] = pre[i]*post[i];
        }

        return pre;
    }
}
