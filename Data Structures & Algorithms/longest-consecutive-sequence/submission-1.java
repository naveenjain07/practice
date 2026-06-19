class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for(int i=0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int max =1;

        for(int i=0; i < nums.length ; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            int count = 1;
            int temp = nums[i]+1;
            while(set.contains(temp)){
                    count++;
                temp++;
            }
            max = Math.max(max,count);
        }
    return max;

    }
}
