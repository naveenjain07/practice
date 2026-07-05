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
/**
/Remember that i >> 1 shifts the bits of i to the right by one position. This effectively chops off the rightmost bit (the Least Significant Bit).

Take i = 6 (in binary: 110).

Shift it right by one: 6 >> 1 becomes 3 (in binary: 011).

Notice that the first two bits of 6 (11) are identical to the bits of 3 (011 — ignoring the leading zero). Therefore, the number of set bits in 6 is the exact same as the number of set bits in 3, plus whatever we chopped off.
/
*/
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        // Base case: 0 in binary is 0, so it has 0 set bits
        res[0] = 0; 
        
        for (int i = 1; i <= n; i++) {
            // HOW THIS WORKS (Dynamic Programming):
            // 1. (i >> 1) chops off the last bit (same as i / 2). We look up this prefix in our array.
            // 2. (i & 1) isolates the chopped-off bit (1 if odd, 0 if even). We add it back.
            // 
            // EXAMPLES: 
            // i = 6 (110): res[6] = res[3 (011)] + 0 = 2 bits
            // i = 7 (111): res[7] = res[3 (011)] + 1 = 3 bits
            res[i] = res[i >> 1] + (i & 1); 
        }
        
        return res;
    }
}
