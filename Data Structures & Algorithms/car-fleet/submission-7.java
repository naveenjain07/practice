class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
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