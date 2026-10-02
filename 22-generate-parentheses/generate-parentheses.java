class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtracking(output_arr, "",0,0, n);
        return output_arr;
    }
    public void backtracking(List<String> output_arr, String curr_arr, int open, int close, int n){
        if(curr_arr.length() == n*2){
            output_arr.add(curr_arr);
            return; 
        }
        if(open < n) backtracking(output_arr, curr_arr + "(", open+1, close, n);
        if(close < open) backtracking(output_arr, curr_arr + ")", open, close+1, n);


    }
}