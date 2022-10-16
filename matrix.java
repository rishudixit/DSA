public class matrix {

    public static int mcm(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int gap = 2; gap < n; gap++) {
            int si = 0, ei = gap;
            while (ei < n) {
                dp[si][ei] = Integer.MAX_VALUE;
                for (int i = si + 1; i < ei; i++) {
                    dp[si][ei] = Math.min(dp[si][ei], dp[si][i] + dp[i][ei] + (arr[si] * arr[i] * arr[ei]));
                }
                si++;
                ei++;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println("Min. multiplication -> " + mcm(arr));
    }

}
