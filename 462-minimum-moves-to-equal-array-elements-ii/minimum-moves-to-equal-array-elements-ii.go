func minMoves2(nums []int) int {
    sum := 0
    slices.Sort(nums[:])
    n := len(nums)
    target := nums[n/2]
    for i := 0; i < n; i++{
        sum += int(math.Abs(float64(target - nums[i])))
    }
    return sum
}