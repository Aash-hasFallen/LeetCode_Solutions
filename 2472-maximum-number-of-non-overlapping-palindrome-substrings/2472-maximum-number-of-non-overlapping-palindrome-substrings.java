
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // palindrome[i][j] tells us whether s[i...j] is a palindrome.
        boolean[][] palindrome = new boolean[n][n];

        // Build the palindrome table by increasing substring length.
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    palindrome[i][j] = true;
                } else if (len == 2) {
                    palindrome[i][j] =
                        s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] =
                        s.charAt(i) == s.charAt(j)
                        && palindrome[i + 1][j - 1];
                }
            }
        }

        // dp[i] = maximum number of valid palindromes
        // using the first i characters.
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Option 1: Do not end a selected palindrome at i - 1.
            dp[i] = dp[i - 1];

            // Option 2: Select a palindrome ending at i - 1.
            for (int j = 0; j < i; j++) {
                int len = i - j;

                if (len >= k && palindrome[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}