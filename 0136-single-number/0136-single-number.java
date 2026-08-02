class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Use an enhanced for-loop for cleaner syntax
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}
