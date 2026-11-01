func minMoves(nums []int) int {
    n := len(nums)
    minVal := math.MaxInt
    sum:= 0
    for i := 0; i < n; i++{
        sum += nums[i]
        minVal = min(minVal, nums[i])
    }
    return sum - (n*minVal)
}