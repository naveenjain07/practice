class Solution {
    public void setZeroes(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        boolean[] c  = new boolean[col];
        boolean[] r  = new boolean[row];


        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                if(matrix[i][j] == 0)
                    {
                        c[j] = true;
                        r[i] = true;
                    }
            }
        }


          for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                if(r[i] || c[j]){
                    matrix[i][j] =0;
                }
            }}
    }
}
