class Solution {

    /*
    Key properties of XOR:

a ^ a = 0 (a number XORed with itself cancels out)
a ^ 0 = a (XOR with 0 keeps the number unchanged)
XOR is commutative and associative, so order does not matter
    */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i =1; i < nums.length; i++){
            res = res ^ nums[i];
        }

        return res;
    }
}
