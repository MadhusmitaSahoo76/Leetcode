class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // Fast boolean array initialized to false by default
        // false means prime, true means composite (not prime)
        boolean[] isNotPrime = new boolean[n];
        int count = 0;

        // Loop up to the square root of n
        for (int i = 2; i * i < n; i++) {
            if (!isNotPrime[i]) {
                // Mark all multiples of i starting from i * i
                for (int j = i * i; j < n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // Count remaining primes starting from 2
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
