class Solution {
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        // 1 row and left col as tracker
        boolean zeroRow = false;
        boolean leftMostCol = false;

        // Check first row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                zeroRow = true;
            }
        }

        // Check first column (FIXED)
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                leftMostCol = true;
            }
        }

        // Mark zeroes on first row and column
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Apply markers to the inner matrix
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
                if(matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if(zeroRow){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        // Zero out the first column if needed
        if(leftMostCol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}