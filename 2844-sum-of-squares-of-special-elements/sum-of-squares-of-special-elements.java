
class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int in = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length % in == 0) {
                sum += nums[i] * nums[i];
            }
            in++;
        }
        return sum;
    }
}
