import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boolean isChange = true;
        
        char [][] map = new char [m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            int removeCount = remove(m, n, map, checkRemoves(m, n, map));
            if(removeCount == 0)
                 break;
            gravity(m, n, map);
            
            answer += removeCount;
        }
        
        return answer;
    }
    
    public void gravity(int m, int n, char [][] board){
        for(int c= 0; c<n; c++){
            char [] temp = new char[m];
            int idx = m-1;
            
            Arrays.fill(temp, ' ');
            for(int r = m-1; r>=0; r--){
                if(board[r][c] == ' ') continue;
                temp[idx--] = board[r][c];
            }
            
            for(int i=0; i<m; i++){
                 board[i][c] = temp[i];
            }
        }
    }
    
    public int remove(int m, int n, char [][] board, boolean [][] isRemoves){
        int count = 0;
        
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!isRemoves[i][j])
                    continue;
                count++;
                board[i][j] = ' ';
            }
         }
        return count;
    }
    
    public boolean [][] checkRemoves(int m, int n, char [][] board){
        boolean [][] isRemoves = new boolean[m][n];
        int [] dr = {0, 1, 1};
        int [] dc = {1, 0, 1};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == ' ') continue;
                if(checkRemove(i, j, m, n, board)){
                    isRemoves[i][j] = true;
                    isRemoves[i][j+1] = true;
                    isRemoves[i+1][j] = true;
                    isRemoves[i+1][j+1] = true;
                }
            }
        }
        return isRemoves;
    }
    
    public boolean checkRemove(int r, int c, int m, int n, char [][] board){
        int [] dr = {0, 1, 1};
        int [] dc = {1, 0, 1};
        
        for(int d=0; d<dr.length; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
                    
            if(nr < 0 || nr >= m || nc < 0 || nc >= n) 
                return false;
            
            if(board[r][c] != (board[nr][nc]))
                return false;
                        
        }
        return true;
    }
}