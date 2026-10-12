class Solution:
    def maxSum(self, nums: List[int], k: int) -> int:
        bits = [0] * 30
        for n in nums:
            for i in range(30):
                bits[i] += (n >> i) & 1

        res = 0
        for _ in range(k):
            n = 0
            for i in range(30):
                if bits[i]:
                    n |= 1<< i
                    bits[i] -= 1
            res =(res + n**2) % (10 **9+7)

        return res