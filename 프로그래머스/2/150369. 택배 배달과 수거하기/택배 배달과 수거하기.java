import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del = 0;
        int pick = 0;
        
        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int cnt = 0;
                while (del < deliveries[i] || pick < pickups[i]) {
                    cnt++;
                    del += cap;
                    pick += cap;
                }
                del -= deliveries[i];
                pick -= pickups[i];
                // 이동거리 계산
                answer += (i+1) * cnt * 2;
            }
        }
        return answer;
    }
}