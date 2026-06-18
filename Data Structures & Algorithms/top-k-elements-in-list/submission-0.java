

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int l = nums.length;

        // 1. Count frequencies using a HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Create buckets. Size is l + 1 to handle maximum frequency safely
        List<Integer>[] bucket = new ArrayList[l + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // 3. Map frequencies to buckets
        for (var entry : map.entrySet()) {
            int frequency = entry.getValue();
            bucket[frequency].add(entry.getKey());
        }

        // 4. Gather the top k elements from highest to lowest frequency
        int[] res = new int[k];
        int index = 0;
        
        for (int j = bucket.length - 1; j >= 0 && index < k; j--) {
            // If the bucket is not empty, pull all elements from it
            for (int num : bucket[j]) {
                res[index++] = num;
                if (index == k) {
                    return res; // Stop early once we have K elements
                }
            }
        }
    
        return res;
    }
}