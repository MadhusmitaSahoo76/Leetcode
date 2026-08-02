import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        // A sequence for n bits contains 2^n elements
        int totalElements = 1 << n;
        List<Integer> result = new ArrayList<>(totalElements);
        
        // Generate each Gray code sequence value directly
        for (int i = 0; i < totalElements; i++) {
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
