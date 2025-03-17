import java.util.*;

class Solution
{
    public int solution(String s)
    {
       Stack<Character> stack = new Stack();
        
        for(int i=0; i<s.length(); i++){
            // 스택이 비어있을 때 - 현재 요소 추가
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }
            // 비어있지 않을 때 - 비교
            else{
                // 같음
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }
                // 같지 않음
                else{
                    stack.add(s.charAt(i));
                }
            }
            
        }
        
        return stack.isEmpty()? 1 : 0;
    }
}