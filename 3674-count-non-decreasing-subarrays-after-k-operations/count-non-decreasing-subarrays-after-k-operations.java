class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length, j = n - 1;
        long ans = 0, cost = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 1;
            while (!dq.isEmpty() && dq.peekLast()[0] < nums[i]) {
                int[] p = dq.pollLast();
                cnt += p[1];
                cost += (long) (nums[i] - p[0]) * p[1];
            }

            dq.addLast(new int[]{nums[i], cnt});

            while (cost > k) {
                int[] p = dq.pollFirst();
                cost -= p[0] - nums[j--];

                if (--p[1] > 0)
                    dq.addFirst(p);
            }
            ans += j - i + 1;
        }return ans;
    }
}