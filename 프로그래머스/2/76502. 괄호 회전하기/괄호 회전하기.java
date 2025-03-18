import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for(int start=0; start<s.length(); start++){
            if(isCorrect(start, s)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isCorrect(int start, String s){
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            int idx = (start + i) % s.length();
            
            char cur = s.charAt(idx);
            if(cur == '[' || cur == '(' || cur == '{'){
                stack.add(cur);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char pre = stack.pop();
                if(cur == ']' && pre == '[') 
                    continue;
                else if(cur == ')' && pre == '(') 
                    continue;
                else if(cur == '}' && pre == '{') 
                    continue;
                
                return false;
            }
        }
        
        return stack.isEmpty()? true : false;
    }
}