class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;
        Integer[][] dp = new Integer[n][k+1];

        return dfs(events, 0, k, dp);
    }

    private int dfs(int[][] events, int index, int k, Integer[][] dp) {
        if (k == 0 || index == events.length) return 0;

        if (dp[index][k] != null) return dp[index][k];

        // Option 1: Skip the current event
        int skip = dfs(events, index + 1, k, dp);

        // Option 2: Take the current event
        int nextIndex = findNext(events, events[index][1]);
        int take = events[index][2] + dfs(events, nextIndex, k - 1, dp);

        return dp[index][k] = Math.max(skip, take);
    }

    // Find the first index where startTime > current endTime
    private int findNext(int[][] events, int endTime) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] > endTime) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
