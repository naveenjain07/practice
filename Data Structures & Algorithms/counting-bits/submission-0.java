class Solution {
    public int[] countBits(int n) {
        
        int [] res = new int[n+1];
        for(int i =0 ; i <=n ; i++){

            int count = 0;
            for(int j =1 ; j <=32 ; j++){

                    if((i & (1 << j))>0){
                       count++;
                    }
            }
            res[i] = count;
        }

        return res;
    }
}
