class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
      
      List<List<Integer>> res = new ArrayList<>();


      List<Integer> temp = new ArrayList<>();

      dfs(res, temp , 0 , nums); 
return res;
    }



    private void dfs(List<List<Integer>> res, List<Integer> temp, int index, int[] nums){
        
        if(index>= nums.length){
            res.add( new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        
        dfs(res,temp,index+1,nums );
        temp.remove(temp.size()-1);
        dfs(res,temp,index+1,nums);

    }
}
