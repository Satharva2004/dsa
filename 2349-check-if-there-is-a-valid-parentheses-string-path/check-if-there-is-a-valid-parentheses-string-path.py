class Solution:
    def hasValidPath(self, grid: list[list[str]]) -> bool:
        n, m = len(grid), len(grid[0])
        @cache
        def dp(i, j, balance):
            if i == n-1 and j == m-1: return balance==0
            if balance < 0: return False
            if(
                i + 1 < n and
                dp(i+1, j, balance + 1 if grid[i+1][j] == '(' else balance - 1)
            ): return True
            if(
                j + 1 < m and
                dp(i, j+1, balance + 1 if grid[i][j+1] == '(' else balance - 1)
            ): return True

            return False
        return dp(0,0, 1 if grid[0][0] == '(' else -1)