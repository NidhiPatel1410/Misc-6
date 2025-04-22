// In this problem, first sorting the array and then assuming that the threshold is desiredSum/n. Then iterating over the list and 
// checking if any element value is less than decided threshold, then computing the new threshold by computing the remn amount and
// dividing the remn in the remn elements.

// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class ArrayThreshold {
    public static float getThreshold(int[] nums, int desiredSum) {
        // Base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Sort
        Arrays.sort(nums);
        float n = nums.length;
        // Assume the threshold is the desiredSum/n
        float threshold = desiredSum / n;
        // Loop
        for (int i = 0; i < n; i++) {
            // Check if any value is smaller than threshold
            if (threshold > nums[i]) {
                // Then change the threshold
                threshold = threshold + ((threshold - nums[i]) / (n - i - 1));
            } else {
                // Else we know that array is sorted so values will keep on increasing so
                // threshold will never be greater
                break;
            }
        }
        // Return threshold
        return threshold;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 1, 5 };
        System.out.println(getThreshold(nums, 4));
    }

}