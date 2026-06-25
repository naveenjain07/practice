
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int l = position.length;
        if (l == 0) return 0; // Edge case: no cars

        int[][] pair = new int[l][2];

        for(int i = 0; i < l; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        } 

        // Sort cars by position in descending order (closest to target first)
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for(int i = 0; i < l; i++){
            // Fix 1: Cast to double to avoid integer truncation
            double t = ((double)target - pair[i][0]) / pair[i][1];
            
            // Fix 2: If the stack is not empty and this car's time is LESS than or EQUAL 
            // to the fleet ahead, it catches up. Do nothing (it merges into the existing fleet).
            // Only push if it takes MORE time (meaning it becomes the bottleneck of a new fleet).
            if (st.isEmpty() || t > st.peek()) {
                st.push(t);
            }
        }

        // Fix 3: The size of the stack represents the exact number of distinct fleets
        return st.size();
    }
}