class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        for (int i = 0; i < nums.length; i++) {
            
            int max = nums[0];
            int min = nums[i];
            
            // Find maximum from 0 to i
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            
            // Find minimum from i to end
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }
            
            // Check stability
            if (max - min <= k) {
                return i;
            }
        }
        
        return -1;
    }
}