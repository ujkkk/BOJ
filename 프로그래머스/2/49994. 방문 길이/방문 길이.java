import java.util.*;

class Solution {
    public int solution(String dirs) {
        int [] curPos = new int[2];
        HashSet<String> set = new HashSet();
        
        int ans = 0;
        
        for(int i=0; i<dirs.length(); i++){
            int [] nextPos = nextPos(curPos[0], curPos[1], dirs.charAt(i));
            if(!isRange(nextPos)){
                continue;
            }
            
            String str = numsToString(curPos, nextPos);
            if(!set.contains(str)){
                ans++;
                set.add(str);
            }
            // 갱신
            curPos[0] = nextPos[0];
            curPos[1] = nextPos[1];
            
        }
        return ans;
    }
    
    public String numsToString(int [] curPos, int [] nextPos){
        StringBuilder sb = new StringBuilder();
        
        if(curPos[0] > nextPos[0]){
            sb.append(nextPos[0]);
            sb.append(curPos[0]);
        } 
        else{
            sb.append(curPos[0]);
            sb.append(nextPos[0]);
        }
            
        if(curPos[1] > nextPos[1]){
            sb.append(nextPos[1]);
            sb.append(curPos[1]);
        } 
        else{
            sb.append(curPos[1]);
            sb.append(nextPos[1]);
        }

        return sb.toString();
    }
    
    public boolean isRange(int [] pos){
        int r = pos[0];
        int c = pos[1];
        
        if(r > 5 || r < -5 || c >5 || c< -5){
            return false;
        }
        return true;
    }
    
    public int [] nextPos(int r, int c, char dir){
        if(dir == 'U'){
            return new int[]{r-1, c};
        }
        else if(dir == 'D'){
            return new int[]{r+1, c};
        }
        else if(dir == 'R'){
            return new int[]{r, c+1};
        }
        else{
            return new int[]{r, c-1};
        }
    }
}