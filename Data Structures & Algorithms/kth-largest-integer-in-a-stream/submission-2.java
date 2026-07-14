class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        
        // Just use your own add method to populate the initial heap!
        for (int i = 0; i < nums.length; i++) {
            this.add(nums[i]); 
        }
    }
    
    public int add(int val) {
        // 1. Always add the new value
        pq.add(val);
        
        // 2. If adding it made the heap too big, kick out the smallest element
        if (pq.size() > k) {
            pq.poll();
        }
        
        // 3. The root of the heap is guaranteed to be the Kth largest
        return pq.peek();
    }
}