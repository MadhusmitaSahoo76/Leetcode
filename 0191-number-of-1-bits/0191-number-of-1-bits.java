class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        // Loop runs exactly once per set bit
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}
