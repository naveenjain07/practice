class Solution {
    double val =1;
    int num =1;
    public double myPow(double x, int n) {
        int count = Math.abs(n);
       while(count>0){
        if(n>=0)
        val = val * x;
        else
        val = val/x;
        count--;
       }
       return val;
    }

    
}
