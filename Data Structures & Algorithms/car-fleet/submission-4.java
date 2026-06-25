class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int l = position.length;
        if (l == 0) return 0;
        
        int[][] pair = new int[l][2];

        for(int i = 0; i < l; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        } 

        // Sort cars by starting position descending (closest to the destination first)
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
     
        Stack<Double> st = new Stack<>();

        /* * VISUALIZATION OF THE MONOTONIC STACK LOGIC:
         * * Imagine processing cars from right to left (closest to target first):
         * Target: 12
         *
         * Fleet Bottleneck (st.peek())  <--- Will the behind car catch up?
         * [ Position: 10, Time: 2.0h ] 
         * ^
         * | (Behind car takes 1.5h. Since 1.5 <= 2.0, it catches up!)
         * [ Position: 8,  Time: 1.5h ] -> Merges into the 2.0h fleet. Stack size unchanged.
         *
         * ---------------------------------------------------------------------------------
         * * Fleet Bottleneck (st.peek())
         * [ Position: 10, Time: 2.0h ] 
         * ^
         * | (Behind car takes 5.0h. Since 5.0 > 2.0, it can NEVER catch up!)
         * [ Position: 4,  Time: 5.0h ] -> Forms a NEW fleet. Pushed onto stack.
         */
        for(int i = 0; i < l; i++){
            // Calculate time to destination with fractional accuracy
            double t = ((double)target - pair[i][0]) / pair[i][1];
            
            // If a car takes STRICTLY MORE time than the slowest fleet ahead of it, 
            // it can never catch up to them. It becomes the leader/bottleneck of a brand new fleet.
            if (st.isEmpty() || t > st.peek()) {
                st.push(t);
            }
            // Else (t <= st.peek()): The car is faster/equal to the fleet ahead. 
            // It will catch up, be forced to slow down, and merge into that existing fleet.
        }

        // Each remaining element in the stack represents a unique, distinct fleet leader
        return st.size();
    }
}



/*

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1;
        double prevTime = (double)(target - pair[0][0]) / pair[0][1];
        for (int i = 1; i < n; i++) {
            double currTime = (double)(target - pair[i][0]) / pair[i][1];
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }
        return fleets;
    }
}
*/