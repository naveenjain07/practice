class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create a Min-Heap. 
        // The comparator sorts by the frequencies stored in the map.
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2)
        );

        // 3. Keep only the top k elements in the heap
        for (int num : map.keySet()) {
            heap.add(num);
            
            // If we have more than k elements, kick out the one with the lowest frequency
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 4. Gather the results from the heap
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}