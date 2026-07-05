class Solution {
    /**
     * BIT MASK
     *
     * The Truth Table:
     * 0 & 0 = 0
     * 0 & 1 = 0
     * 1 & 0 = 0
     * 1 & 1 = 1
     *
     * The most common use of & is checking if a specific bit is set (is it a 1?). 
     * If you want to know if the 2nd bit of a number n is set, you construct a 
     * "mask" where only the 2nd bit is 1 (which is the number 4, or 0100).
     *
     * If n & mask is greater than 0, that bit was a 1. 
     * If the result is 0, that bit was a 0.
     *
     * Most Important Concept:
     * Rule 1: To check if the i-th bit of n is set (1), you write: if (n & (1 << i))
     * Rule 2: n & (n - 1) always drops the rightmost set bit (turns the lowest 1 into a 0).
     *
     *    1100  (12)
     *  & 1011  (11)
     *  -------
     *    1000  (8)
     *
     * Important questions:
     * - Check if a number is a power of 2
     * - Count the number of set bits (Brian Kernighan’s Algorithm)
     */
    public int hammingWeight(int n) {
        int count = 0;
        //JAva 0 to 31 bits ... here i =1 we can also do as in java int cycle runs so shifting 31st bits does not produce negative number 
        for (int i = 0; i <= 31; i++) {
            if ((n & (1 << i)) > 0) {
                count++;
            }
        }

        return count;
    }


   
}