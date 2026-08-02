class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            int colMax = 0;

            for (int j = 0; j < n; j++) {
                // Top view: Count every non-empty cell
                if (grid[i][j] > 0) {
                    totalArea++;
                }
                
                // Track max height for the front view (row-wise)
                if (grid[i][j] > rowMax) {
                    rowMax = grid[i][j];
                }
                
                // Track max height for the side view (column-wise)
                if (grid[j][i] > colMax) {
                    colMax = grid[j][i];
                }
            }
            
            // Add the largest peaks for this row and column
            totalArea += rowMax + colMax;
        }

        return totalArea;
    }
}
