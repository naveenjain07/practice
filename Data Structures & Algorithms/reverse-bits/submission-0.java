class Solution {

    // 001000100
    
    public int reverseBits(int n) {
        int sum =0;
        for(int i=0;i <=31; i++){
            if((n & (1<<i))!=0){
                    sum  = sum + (int) Math.pow(2,31-i);

                    if(i==0) sum = sum+1;
            }
        }

        return sum;
    }
}


