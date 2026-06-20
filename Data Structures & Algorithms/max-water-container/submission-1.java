class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int area = Math.min(heights[j], heights[i]) * (j - i);
            max = Math.max(area, max);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
