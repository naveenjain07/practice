public class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);

        while(slow != fast){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
        }

        return slow ==1;
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }
}