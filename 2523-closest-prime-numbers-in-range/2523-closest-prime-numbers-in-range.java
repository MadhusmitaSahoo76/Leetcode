import java.util.Arrays;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Find all primes up to 'right' using the Sieve of Eratosthenes
        boolean[] isNotPrime = new boolean[right + 1];
        if (right >= 0) isNotPrime[0] = true;
        if (right >= 1) isNotPrime[1] = true;

        for (int i = 2; i * i <= right; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // Step 2: Scan the range [left, right] to find adjacent primes
        int prevPrime = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};

        for (int i = left; i <= right; i++) {
            if (!isNotPrime[i]) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    // If we find a smaller difference, update our answer
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans[0] = prevPrime;
                        ans[1] = i;
                    }
                    // Optimization: A difference of 1 (for 2,3) or 2 (twin primes) 
                    // is the smallest possible gap, so we can return early.
                    if (diff <= 2) {
                        return ans;
                    }
                }
                prevPrime = i;
            }
        }

        return ans;
    }
}
