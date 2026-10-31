class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7
        n, m = len(grid), len(grid[0])

        dp = [1] + [0] * (m - 1)

        for i in range(n):
            left = 0

            for j in range(m):
                if grid[i][j] == 1:
                    left, dp[j] = dp[j], left
                else:
                    left = dp[j] = (left + dp[j]) % MOD

        return left