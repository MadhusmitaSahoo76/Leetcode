class Solution {
    public int getSum(int a, int b) {
        // Loop runs until there are no more carries left to add
        while (b != 0) {
            int carry = a & b; // Find matching set bits
            a = a ^ b;         // Add two numbers without carry
            b = carry << 1;    // Shift carry to the left
        }
        return a;
    }
}
