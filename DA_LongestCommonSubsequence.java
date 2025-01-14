import java.util.Scanner;

public class DA_LongestCommonSubsequence {
    public static int lcs(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String X = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String Y = scanner.nextLine();
        
        int m = X.length();
        int n = Y.length();
        
        int lengthOfLCS = lcs(X, Y, m, n);
        System.out.println("Length of the Longest Common Subsequence: " + lengthOfLCS);
        
        scanner.close();
    }
}
