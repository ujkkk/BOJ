import java.util.*;

class Solution {
    public int solution(String s) {
     
        char [] chars = s.toCharArray();
        int size = chars.length;
        int count =0;
        
        for(int i=0; i<size; i++){
            // 괄호회전
            char first = chars[0];
            for(int j=0; j<size -1; j++){
                chars[j] = chars[j+1];
            }
            chars[size-1] = first;
            
            // 검사
            if(isCorrect(chars)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isCorrect(char [] chars){
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '(' ||chars[i] == '[' || chars[i] == '{' ){
                stack.add(chars[i]);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                
                char cur = stack.pop();
                if(cur == '(' && chars[i] != ')') {
                     return false;
                }
                if(cur == '[' && chars[i] != ']') {
                     return false;
                }
                if(cur == '{' && chars[i] != '}' ) {
                     return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}