class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l = 0; 
        int r = matrix.length - 1;
        int c = matrix[0].length - 1;
        int finalk = -1;
        
        // --- 1st Binary Search: Find the correct row ---
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            
            // Is the target inside this row's range?
            if (target >= matrix[mid][0] && target <= matrix[mid][c]) {
                finalk = mid; 
                break; // We found the row, stop searching rows!
            }
            // Target is smaller than the entire row -> search upper half
            else if (target < matrix[mid][0]) {
                r = mid - 1;
            }
            // Target is larger than the entire row -> search lower half
            else {
                l = mid + 1;
            }
        }

        // If we never found a valid row, the target can't be in the matrix
        if (finalk == -1) {
            return false;
        }
         
        // --- 2nd Binary Search: Find target in the locked row (finalk) ---
        l = 0; 
        r = c;
        
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            
            if (matrix[finalk][mid] == target) {
                return true;
            }
            
            if (matrix[finalk][mid] < target) {
                l = mid + 1; // Your logic here was perfectly correct!
            } else {
                r = mid - 1;
            }
        }
        
        return false;
    }
}