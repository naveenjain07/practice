class KthLargest {
    int k = 0;
    PriorityQueue<Integer> pq = null;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (this.pq.size() < k)
                this.pq.add(nums[i]);
            else {
                 if(pq.peek() < nums[i]){
                    pq.poll();
                     pq.add(nums[i]);
                 }
            }
        }
    }
        // 3 5 8 
    public int add(int val) {
        int res = 0;
        if (pq.size() == k) {
            if(pq.peek() < val){
                    pq.poll();
            pq.add(val);
            
            }
            
        } else {
            pq.add(val);

        }
        return pq.peek();
    }
}
