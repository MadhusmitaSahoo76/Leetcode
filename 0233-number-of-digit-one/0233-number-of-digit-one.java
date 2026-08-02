class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        
        long count = 0;
        
        // Loop through each digit place (ones, tens, hundreds, etc.)
        for (long divider = 1; divider <= n; divider *= 10) {
            long high = n / (divider * 10);
            long current = (n / divider) % 10;
            long low = n % divider;
            
            if (current == 0) {
                count += high * divider;
            } else if (current == 1) {
                count += high * divider + low + 1;
            } else {
                count += (high + 1) * divider;
            }
        }
        
        return (int) count;
    }
}
