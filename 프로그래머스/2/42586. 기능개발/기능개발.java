import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> ans = new ArrayList();
        
        double day = 0;
        int count = 0;
        for(int i=0; i<progresses.length; i++){
            int cur = progresses[i];
            
            // 배포될 수 있음
            if((100 - cur) <= day*speeds[i]){
                count++;
                continue;
            }
            
            // 배포될 수 없음 - 배포가능할 때까지 day 추가
            if(count != 0){
                ans.add(count);
                count = 0;
            }
            day +=  (int)(Math.ceil((((100-cur) - (day*speeds[i]))/speeds[i])));
            count++;
            
        }
        
        if(count > 0){
            ans.add(count);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}