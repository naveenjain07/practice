class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        /**
        
        The Bug: The Missing if StatementsLook at what happens midway through your while loop if we pass in a flat $1 \times 3$ matrix: [[1, 2, 3]].top = 0, bottom = 0, left = 0, right = 2.Loop 1 (Left to Right): Reads 1, 2, 3.top increments. Now top = 1.Loop 2 (Top to Bottom): top (1) is greater than bottom (0), so this loop safely skips.right decrements. Now right = 1.Loop 3 (Right to Left): right (1) is greater than left (0). Your code blindly enters this loop and adds matrix[bottom][i].Because you didn't check if the top and bottom walls had crossed each other, your code sweeps backwards over the exact same row it just read!*/
        List<Integer> res = new ArrayList<>();

        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}