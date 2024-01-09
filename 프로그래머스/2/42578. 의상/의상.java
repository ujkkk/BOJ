import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해쉬 맵으로 <종류, 카운트> 받기
        HashMap <String ,Integer> map = new HashMap();
        int result = 1;
        for(int i=0; i< clothes.length; i++)
        {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        Iterator<Integer> iterator = map.values().iterator();
        
        while(iterator.hasNext()){
             result *= (iterator.next()+1);
        }
        
        // 아무것도 안 입었을 때 제외
        return result-1;
    }
}