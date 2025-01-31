import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // 최대한 멀리있는 것을 배달하면서, 수거해야함 - 인덱스 관리
        
        int dIdx = n-1; // 배달 시작해야하는 인덱스
        int pIdx = n-1; // 수거 시작해야하는 인덱스
        
        int box;
        int pick;
        
        boolean isChange = false;
        
        while(true){
            if(dIdx < 0 && pIdx <0){
                break;
            }
            // 최대한 뒷자리에 배달을 하고, 수거 남은 곳 수거 (수거 *2)
            answer += (Math.max(dIdx +1, pIdx+1))*2;
            // System.out.println("거리 :" + answer);
            box = cap;
            pick = cap;
            
            // 택배 끝까지 놓고 오기
            while(dIdx >=0 && box > 0){
                if(deliveries[dIdx] == 0){
                    dIdx--;
                    continue;
                }
                deliveries[dIdx]--;
                box--;
                isChange = true;
                
                if(deliveries[dIdx] == 0){
                    dIdx--;
                }
            }
            
            while(dIdx >=0 && deliveries[dIdx] == 0){
                dIdx--;
            }
            
            // 수거 시작
            while(pIdx >=0 && pick > 0){
                if(pickups[pIdx] == 0){
                    pIdx--;
                    continue;
                }
                
                pickups[pIdx]--;
                pick--;
                isChange = true;
                
                if(pickups[pIdx] == 0){
                    pIdx--;
                }
            }
            
            while(pIdx >=0 && pickups[pIdx] == 0){
                pIdx--;
            }
            
            if(!isChange){
                return 0;
            }
        }
        
        
        return answer;
    }
}