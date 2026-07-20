class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp  = new ArrayList<>();

        dfs(res, temp , nums);
        return res;


    }



    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums ) {
        if(nums.length == temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i< nums.length;i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs(res, temp ,nums);
            temp.remove(temp.size()-1);

        }

    }
}