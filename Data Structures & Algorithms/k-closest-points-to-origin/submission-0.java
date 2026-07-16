class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]>  pq = 
        
        new PriorityQueue<>((a,b)->((a[0]*a[0] + a[1]*a[1])  - ( b[0]*b[0] +b[1]*b[1])));


        int l = points.length;
        for(int[] each:  points){
            pq.add(each);
        }

        int[][] res = new int[k][2];
        int i=0;
        while(k>0){
           
            res[i] = pq.poll();
            k--;
             i++;
        }

        return res;
    }
}
