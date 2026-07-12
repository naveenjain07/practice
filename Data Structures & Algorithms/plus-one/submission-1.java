class Solution {
    public int[] plusOne(int[] digits) {
        
        // 1. Traverse from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            
            // 2. If it's less than 9, just add 1 and return immediately!
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // 3. If it IS a 9, it becomes 0. The loop continues to carry the 1.
            digits[i] = 0;
        }
        
        // 4. If we survive the loop, it means the number was all 9s (e.g. 999)
        int[] res = new int[digits.length + 1];
        res[0] = 1; // Sets the first digit to 1. The rest are naturally 0.
        
        return res;
    }
}