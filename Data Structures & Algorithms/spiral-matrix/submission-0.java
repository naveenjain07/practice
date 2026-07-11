class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        // Keep spiraling as long as the walls haven't crossed each other
        while (top <= bottom && left <= right) {
            
            // 1. Move Left to Right (along the top wall)
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++; // Shrink the top wall down
            
            // 2. Move Top to Bottom (along the right wall)
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--; // Shrink the right wall left
            
            // 3. Move Right to Left (along the bottom wall)
            // MUST check if top <= bottom to avoid the "Double Back" bug!
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--; // Shrink the bottom wall up
            }
            
            // 4. Move Bottom to Top (along the left wall)
            // MUST check if left <= right to avoid the "Double Back" bug!
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++; // Shrink the left wall right
            }
        }
        
        return res;
    }
}