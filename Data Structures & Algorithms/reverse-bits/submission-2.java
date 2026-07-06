class Solution {

    // 001000100

    /**
    VariableBinary Value
    sum     10100000000000000000000000000000
    mask.   00010000000000000000000000000000
    Result. 10110000000000000000000000000000
    */
    public int reverseBits(int n) {
        int sum = 0;
        for(int i = 0; i <= 31; i++){
            if((n & (1 << i)) != 0){
                // Shift 1 to the left by (31 - i) positions.
                // We use bitwise OR (|) instead of addition (+).
                sum = sum | (1 << (31 - i));
            }
        }
        return sum;
    }
    // public int reverseBits(int n) {
    //     int sum =0;
    //     for(int i=0;i <=31; i++){
    //         if((n & (1<<i))!=0){
    //                 sum  = sum + (int) Math.pow(2,31-i);

    //                 if(i==0) sum = sum+1;
    //         }
    //     }

    //     return sum;
    // }
}


