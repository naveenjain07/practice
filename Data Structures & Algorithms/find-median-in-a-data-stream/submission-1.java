

class MedianFinder {

    // Stores the smaller half of numbers (Max-Heap)
    private Queue<Integer> maxHeap; 
    // Stores the larger half of numbers (Min-Heap)
    private Queue<Integer> minHeap; 

    public MedianFinder() {
        // Collections.reverseOrder() is the standard, cleaner way to write a Max-Heap in Java
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Always add to the maxHeap first
        maxHeap.add(num);
        
        // Step 2: Immediately move the largest element from maxHeap to minHeap.
        // This completely removes the need for your complex "if (smallHeap.peek() > largeHeap.peek())" logic,
        // because it guarantees the maxHeap only ever holds the truly smaller half of numbers.
        minHeap.add(maxHeap.poll());
        
        // Step 3: Balance the sizes. 
        // We will enforce a rule: maxHeap will ALWAYS hold the extra element if the total count is odd.
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // If sizes are equal, the total count is even. Average the two tops.
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // Dividing by 2.0 automatically casts to double
        } 
        
        // Because of our strict balancing rule in Step 3, if the total count is odd, 
        // maxHeap is guaranteed to have the extra element. We don't even need an else-if!
        return maxHeap.peek();
    }
}