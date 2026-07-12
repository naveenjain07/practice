class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        boolean isBreak = true;
        while (isBreak) {
            sum = sumOfSquare(n);

            if (sum == 1) {
                return true;
            }

            if(set.contains(sum)) return false;
            set.add(sum);
            n =sum;
        }
        return false;
    }

    private int sumOfSquare(int n) {
        int sum = 0;

        while(n >0) {
            int rem = n%10;
            sum = sum+ (rem * rem);
            n = n/10;
        }

        return sum;
    }
}
