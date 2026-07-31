class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int sum = 0;
        

        // Calculating total sum of the array
        for(int num : nums){
            sum += num;
        }

        // Treat every index as a potential pivot index
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int right = sum - num - left;

            // Current element excluded from both left and right sums
            if(left == right){
                return i;
            }
            left += num;
        }
        return -1;
    }
}