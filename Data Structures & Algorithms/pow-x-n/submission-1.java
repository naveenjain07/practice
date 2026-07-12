class Solution {
    double val = 1;
    int num = 1;
    public double myPow(double x, int n) {
        /**
         In math, 2^10 is completely identical to 4^5.
         Because 2^2 = 4,
          you can rewrite the equation
          (2^2)^5 = 4^5
         MEANS

         power divided by 2 &. base multiply by 2

         so that insted of n time iteration we can just solve it in logn time
        *
      */

        double ans = 1;

        if (n < 0) {
            // means we will have to divede here we can flip the x  and make power positive
            n = -n;
            x = 1 / x;
        }

        while (n > 0) {
            // 4^5 = 4 * 4^4
            if (n % 2 == 1) {
                ans = ans * x;
            }
            n = n / 2;
            x = x * x;
        }

        return ans;
    }
}
