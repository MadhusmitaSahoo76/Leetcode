class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Divide n by powers of 5 (5, 25, 125, etc.)
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }
}
