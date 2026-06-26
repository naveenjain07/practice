class Solution {

    /***
 Think of the stack as holding bars whose rectangles are still "open" because we haven't yet found a shorter bar on the right.

A taller (or equal) next bar → keep extending, just push it.
A shorter next bar → rectangles for taller bars must end here, so pop them and calculate their maximum possible areas.
The remaining top of the stack after a pop is the previous smaller bar, and the current index is the next smaller bar, giving the widest possible rectangle for the popped height.

    ***/
     public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                 (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
