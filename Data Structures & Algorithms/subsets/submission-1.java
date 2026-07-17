class Solution {
   
   /******
   subset.add(nums[i]); (The "Pick")
You choose to include the current number in your growing subset.

dfs(nums, i + 1, subset, res); (Explore with the number)
You move down the recursion tree to the next element (i + 1), carrying the subset that includes nums[i].

subset.remove(subset.size() - 1); (The Backtrack)
Once that recursive call finishes and you return to this stack frame, you are back at index i. You must undo your previous choice so you can explore the alternate reality where you didn't pick nums[i]. You remove the exact element you just added.

dfs(nums, i + 1, subset, res); (Explore without the number)
You move down the recursion tree to the next element (i + 1) again, but this time, your subset explicitly excludes nums[i].*******/
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        dfs(res, temp, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int index, int[] nums) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);

        dfs(res, temp, index + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(res, temp, index + 1, nums);
    }
}
