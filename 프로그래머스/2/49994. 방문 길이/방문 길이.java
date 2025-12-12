import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        int x = 5;
        int y = 5;
        
        HashSet<String> set = new HashSet();
        for(int i=0; i<dirs.length(); i++){
            int [] next = next(x, y, dirs.charAt(i));
            if(next[0] < 0 || next[0] > 10 || next[1] < 0 || next[1] > 10)
                continue;
            
            set.add(x+"" +y +"" + next[0] +"" + next[1]);
            set.add(next[0]+"" +next[1]+"" + x +"" + y);
            
            x = next[0];
            y = next[1];
        }
        
        return set.size()/2;
    }
    
    // 방향에 따른 좌표값 제공
    public int [] next(int x, int y, char dir){
        int [] dy = {1, 0, -1, 0};
        int [] dx = {0, 1, 0, -1};
        
        int d = 0;
        if(dir == 'U'){
            d = 0;
        }
        else if (dir == 'R'){
            d = 1;
        }
        else if(dir == 'D'){
            d = 2;
        }
        else if(dir == 'L'){
            d = 3;
        }
        return new int[]{x+dx[d], y+dy[d]};
    }
}