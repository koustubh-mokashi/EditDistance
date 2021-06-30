class Solution {
    public int ed (String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (dp[m][n] != 0)
            return dp[m][n];
        
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) 
            dp[m][n] = ed(s1, s2, m - 1, n - 1, dp);
        else {
            dp[m][n] = 1 + Math.min( Math.min(ed(s1, s2, m - 1, n, dp), 
                                          ed(s1, s2, m, n - 1, dp)), 
                                          ed(s1, s2, m - 1, n - 1, dp));
        }
        return dp[m][n];
        
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        return ed(word1, word2, m, n, dp);
    }
}
