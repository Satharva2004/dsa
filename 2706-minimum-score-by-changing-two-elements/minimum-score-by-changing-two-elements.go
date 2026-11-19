func minimizeSum(nums []int) int {
    sort.Ints(nums)
    n := len(nums)
    case1 := nums[n-1] - nums[2]
    case2 := nums[n-2] - nums[1]
    case3 := nums[n-3] - nums[0]
    return min(case1, min(case2, case3))
}