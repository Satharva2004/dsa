import java.util.*;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (IntStream.range(1, n).allMatch(i -> s.charAt(i - 1) <= s.charAt(i))) return 0; 
        if (n == 2) return -1;
        IntSummaryStatistics mid = s.chars().skip(1).limit(n - 2).summaryStatistics(); 
        int first = s.charAt(0), last = s.charAt(n - 1), lo = mid.getMin(), hi = mid.getMax();
        if (first <= Math.min(lo, last) || Math.max(first, hi) <= last) return 1;
        return last < lo && hi < first ? 3 : 2;
    }
}