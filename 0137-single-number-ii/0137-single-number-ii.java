class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            // Update 'twos' if the bit is already in 'ones'
            twos |= (ones & num);
            
            // Update 'ones' using XOR
            ones ^= num;
            
            // Create a mask for bits that have appeared 3 times
            int threesMask = ~(ones & twos);
            
            // Clear the bits that appeared 3 times from both states
            ones &= threesMask;
            twos &= threesMask;
        }

        // At the end, 'ones' holds the unique number
        return ones;
    }
}
