import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int[] maxValue = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            maxValue[i] = Math.max(maxValue[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            int next = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (events[mid][0] > events[i][1]) {
                    next = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int total = events[i][2] + maxValue[next];
            ans = Math.max(ans, total);
        }

        return ans;
    }
}