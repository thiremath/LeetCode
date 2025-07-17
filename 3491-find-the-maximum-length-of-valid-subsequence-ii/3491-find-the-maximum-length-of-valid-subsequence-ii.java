class Solution {
    Integer[][] dp;

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int Max = 0;

        for (int i = 0; i < n; i++) {
            nums[i] %= k;
            Max = Math.max(Max, nums[i]);
        }

        dp = new Integer[n][k + 1]; // using k as index for prev == -1

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans >= n - i) break;
            ans = Math.max(ans, maximumLengthWorker(nums, i, -1, k));
        }

        return ans;
    }

    public int maximumLengthWorker(int[] nums, int index, int prev, int k) {
        int prevIndex = prev == -1 ? k : prev;

        if (dp[index][prevIndex] != null)
            return dp[index][prevIndex];

        int ans = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (prev == -1 || nums[i] == prev) {
                ans = Math.max(ans, 1 + maximumLengthWorker(nums, i, nums[index], k));
            }
        }

        dp[index][prevIndex] = ans;
        return ans;
    }
}
