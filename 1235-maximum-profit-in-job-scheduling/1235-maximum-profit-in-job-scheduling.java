import java.util.Arrays;
class Solution{
    int[][] jobs;
    int [] dp;
    int n;
    public int jobScheduling(int[] startTime, int[] endTime,int[] profit){
        n = startTime.length;
        jobs = new int[n][3];
        for(int i =0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);

        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0);
    }
    int solve(int i) {
        if (i>= n){
            return 0;
        }
        if(dp[i]!= -1){
            return dp[i];
        }
        int skip = solve(i+1);
        int next = findNext(jobs[i][1]);
        int take = jobs[i][2]+ solve(next);
        dp[i] = Math.max(take , skip);
        return dp[i];
    }

    int findNext(int end){
        int left = 0;
        int right =n;
        while (left< right){
            int mid = left +(right-left)/2;
            if (jobs[mid][0] >= end){
                right =mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}