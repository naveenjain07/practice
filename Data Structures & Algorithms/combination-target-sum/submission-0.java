

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, 0, res, temp, 0, target);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> temp, int sum, int target) {
        // Base case 1: We found a valid combination
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        // Base case 2: Sum exceeded the target OR we ran out of numbers
        if (sum > target || index >= nums.length) {
            return;
        }

        // Decision 1: INCLUDE the current number (nums[index])
        temp.add(nums[index]);
        // Note: 'index' stays the same because we can reuse the same element
        dfs(nums, index, res, temp, sum + nums[index], target);
        
        // Decision 2: SKIP the current number
        // We backtrack by removing the number we just added
        temp.remove(temp.size() - 1);
        // Note: 'index' advances by 1 because we are done exploring this number
        dfs(nums, index + 1, res, temp, sum, target);
    }
}