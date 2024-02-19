import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        
        // 같은 방향으로 눕히면 됨
        for(int i=0; i<sizes.length; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            if(height > width){
                wMax = Math.max(wMax, height);
                hMax = Math.max(hMax, width);
            } else{
                wMax = Math.max(wMax, width);
                hMax = Math.max(hMax, height);
            }
        }
        return wMax*hMax;
    }
}