import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 스택(열)에 넣기
        Stack<Integer> [] stacks = new Stack[board[0].length];
        for(int i=0; i<board[0].length; i++){
            stacks[i] = new Stack();
        }
        
        for(int i=board.length-1; i>=0; i--){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 0 )
                    continue;
                stacks[j].add(board[i][j]);
            }
        }
        
        Stack<Integer> box = new Stack();
        for(int i=0; i<moves.length; i++){
            int cur = moves[i] - 1;
            
            if(stacks[cur].isEmpty()){
                continue;
            }
            int item = stacks[cur].pop();
            if(!box.isEmpty() && box.peek() == item){
                box.pop();
                answer += 2;
            }
            else{
                box.add(item);
            }
        }
        return answer;
    }
}