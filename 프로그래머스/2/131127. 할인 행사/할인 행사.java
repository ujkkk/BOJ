import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap();
        int start = -1;
        int end = 0;
        
        for(int i=0; i<=9; i++){
            start++;
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(match(map, want, number)){
            answer++;
        }
        
        while(start < discount.length-1){
            //System.out.println(end + " 제거");
            map.put(discount[end], map.get(discount[end]) - 1);
            end++;
            
            start++;
            //System.out.println(start + " 추가");
            map.put(discount[start], map.getOrDefault(discount[start], 0) + 1);
            
            if(match(map, want, number)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean match(HashMap<String, Integer> map, String[] want, int[] number){
        for(int i=0; i<want.length; i++){
            String product = want[i];
            int count = number[i];
            
            if(map.getOrDefault(product, 0) != count){
                return false;
            }
        }
        return true;
    }
}