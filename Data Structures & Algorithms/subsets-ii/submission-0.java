class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, temp, nums, 0);
        return res;
    }


    private void dfs(List<List<Integer>> res, List<Integer> temp 
    ,int[] nums, int index  ){
            if(index> nums.length-1) {

                res.add(new ArrayList<>(temp));
                return;
            }

            temp.add(nums[index]);
            dfs(res, temp ,nums, index+1);
            temp.remove(temp.size()-1);

            while (index + 1 < nums.length && nums[index] == nums[index + 1]){
                index++;
                
            }

            dfs(res, temp , nums , index+1);

    }
}
