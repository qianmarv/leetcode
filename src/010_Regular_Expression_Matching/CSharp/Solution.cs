public class Solution {
    public bool IsMatch(string s, string p)
    {
        bool[,] dp = new bool[s.Length + 1, p.Length + 1];
        dp[0, 0] = true;

        for (int j = 0; j < p.Length; j++)
        {
            if (j % 2 != 0 && p[j] == '*')
            {
                dp[0, j + 1] = dp[0, j - 1];
            }
        }


        for (int i = 0; i < s.Length; i++)
        {
            for (int j = 0; j < p.Length; j++)
            {
                if (p[j] == s[i] || p[j] == '.')
                {
                    dp[i + 1, j + 1] = dp[i, j];
                }
                else if (p[j] == '*' && j > 0)
                {
                    dp[i + 1, j + 1] =
                        ((p[j - 1] == s[i] || p[j - 1] == '.') && (dp[i + 1, j] || dp[i, j + 1]))
                        || dp[i + 1, j - 1];
                }
            }
        }

        return dp[s.Length, p.Length];
    }
}
