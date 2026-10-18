class Solution {
    public int digitsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitsum(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {   // FIX
            map.put(nums[i], i);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {

                int j = map.get(sorted[i]);
                map.put(nums[i], j);
                map.put(sorted[i], i);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                count++;
            }
        }

        return count;
    }
}