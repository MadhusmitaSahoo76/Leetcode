class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.offer(
            new int[]{
                entrance[0],
                entrance[1],
                0
            }
        );

        // mark entrance visited
        maze[entrance[0]][entrance[1]] = '+';


        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty()) {

            int[] node = q.poll();

            int r = node[0];
            int c = node[1];
            int step = node[2];

            for(int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                // outside boundary means exit
                if(nr < 0 ||
                   nc < 0 ||
                   nr >= m ||
                   nc >= n) {

                    if(step == 0) {
                        continue;
                    }

                    return step;
                }

                if(maze[nr][nc] == '+') {
                    continue;
                }

                maze[nr][nc] = '+';

                q.offer(
                    new int[]{
                        nr,
                        nc,
                        step + 1
                    }
                );
            }
        }

        return -1;
    }
}