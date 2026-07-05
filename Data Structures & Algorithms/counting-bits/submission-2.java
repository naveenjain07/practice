class Solution {

// first solve. number of single bits neetcode question 
    // public int[] countBits(int n) {
        
    //     int [] res = new int[n+1];
    //     for(int i =0 ; i <=n ; i++){

    //         int count = 0;
    //         for(int j =0 ; j <32 ; j++){

    //                 if((i & (1 << j))>0){
    //                    count++;
    //                 }
    //         }
    //         res[i] = count;
    //     }

    //     return res;
    // }


// DP solution
     public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            // bits in (i / 2) + last bit of i
            res[i] = res[i >> 1] + (i & 1); 
        }
        
        return res;
    }
}
