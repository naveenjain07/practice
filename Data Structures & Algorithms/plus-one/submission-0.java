class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int c = 0;
        for(int i = n-1; i>=0;i--){

            if(digits[i]+1 >9) { 
                c =1;
                digits[i] =0;
            }else{
                c=0;
                digits[i] = digits[i]+1;
                break;
            }
        }
        int res[] = new int[n+1];
        if(c==1){
            res[0] =1;
            for(int i=0; i<n;i++){
                res[i+1] = digits[i];
            }
        }

        return  c==1 ?res : digits;
    }
}
