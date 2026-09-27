class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == ')'){
                Queue<Character> q = new LinkedList<>();
                while(stack.peek() != '('){
                    q.add(stack.pop());
                }
                stack.pop();
                while(!q.isEmpty()){
                    stack.push(q.remove());
                }
            }else{
                stack.push(c);
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans = stack.pop()+ans;
        }
        return ans;
    }
}