class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        // Find all rotten oranges and count fresh ones
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges at the beginning
        if (fresh == 0) {
            return 0;
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Multi-source BFS
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            // One BFS level represents one minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Explore four directions
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    // Skip out-of-bounds cells
                    if (newRow < 0 || newRow >= grid.length ||
                        newCol < 0 || newCol >= grid[0].length) {
                        continue;
                    }

                    // Only fresh oranges can become rotten
                    if (grid[newRow][newCol] != 1) {
                        continue;
                    }

                    // Rot the orange and add it to the queue
                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.offer(new int[]{newRow, newCol});
                }
            }

            // One minute has passed
            minutes++;
        }

        // Impossible to rot all oranges
        return fresh > 0 ? -1 : minutes;
    }
}