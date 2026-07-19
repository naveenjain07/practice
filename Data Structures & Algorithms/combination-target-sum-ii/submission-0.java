class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, temp , candidates, target , 0 ,0);
        return res;
    }


    private void dfs(List<List<Integer>> res, List<Integer> temp,int[] nums, int target, int index, int sum ){

        if(target == sum) {

            res.add(new ArrayList<>(temp));
            return;
        }

        if(sum > target || index >= nums.length) return;
        
        temp.add(nums[index]);

        dfs(res, temp,nums, target , index+1,sum+nums[index]);
        temp.remove(temp.size()-1);
       
       // 2. We must skip ALL duplicates of the number we just chose not to use
        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
            nextIndex++; // Keep sliding forward until we find a different number
        }
        dfs(res, temp ,nums, target , nextIndex, sum);
        return;
    }
}
