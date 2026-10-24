import java.util.Arrays;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int[] start = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = events[i][0];
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int count = 1; count <= k; count++) {
            for (int i = n - 1; i >= 0; i--) {
                int left = i + 1;
                int right = n - 1;
                int next = n;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (start[mid] > events[i][1]) {
                        next = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                int attend = events[i][2] + dp[count - 1][next];
                int skip = dp[count][i + 1];

                dp[count][i] = Math.max(attend, skip);
            }
        }

        return dp[k][0];
    }
}