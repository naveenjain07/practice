class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

         
        /**. its One way as we know 
            Idea is that if we sort the car as closet to fartheset and calc time taken for each car 

            if car is taking more time than its front car than it will never create fleet  so it will be indepent car (its own unique fllet)

            but if car is taking less time or equal time than front car than it will have to stick with front car == so it will be part of same fleet


         pos     10 8 5 3 0 
        speed    2  4 1 3 1

        time  1  1  7  3  12 
        */
        int pair[][] = new int[position.length][2];
        for (int i = 0; i < pair.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];

        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        double blockingTime = (double)(target - pair[0][0]) / pair[0][1];
        int totalFleets = 1;
        for (int i = 1; i < pair.length; i++) {
            
            double time = (double)(target - pair[i][0]) / pair[i][1];
            System.out.println("blokingTime- "+blockingTime+" time= "+time);
            if (time > blockingTime) {
                totalFleets++;
                blockingTime = time;
            }
        }
        return totalFleets;
    }
}