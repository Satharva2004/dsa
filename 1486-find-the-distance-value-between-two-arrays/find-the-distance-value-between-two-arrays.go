func findTheDistanceValue(arr1 []int, arr2 []int, d int) int {
	mainc := 0
	for i := 0; i < len(arr1); i++ {
		count := 0
		for j := 0; j < len(arr2); j++ {
			if math.Abs(float64(arr1[i]-arr2[j])) <= float64(d) {
				break
			} else {
				count++
			}
		}
		if count == len(arr2) {
            mainc++
        }
	}

	return mainc
}