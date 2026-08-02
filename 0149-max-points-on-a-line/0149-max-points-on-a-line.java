import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int maxPointsOnLine = 1;

        // Iterate through each point as an anchor point
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Reduce the fraction dy/dx using GCD to handle precision
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Standardize negative signs to ensure consistency
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    // Vertical line handling: unify representations to 0/1
                    dy = 1; 
                }

                String slopeKey = dy + "/" + dx;
                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slopeKey));
            }

            // Total points on this line = 1 (anchor point itself) + max matching slopes
            maxPointsOnLine = Math.max(maxPointsOnLine, localMax + 1);
        }

        return maxPointsOnLine;
    }

    // Euclidean algorithm to find the greatest common divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
