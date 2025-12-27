import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
         // 리스트에 요소 넣기
        int [] up = new int[n+2];
        int [] down = new int[n+2];

        for(int i=0; i<n+2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        k++;

        // 삭제 원소 관리할 스택
        Stack<Integer> stack = new Stack();

        for(String c : cmd){
            String [] str = c.split(" ");
            char ch = str[0].charAt(0);

            if(ch == 'D'){
                int x = Integer.parseInt(str[1]);
                for(int i=0; i<x; i++){
                    k = down[k];
                }
            }
            else if(ch == 'U'){
                int x = Integer.parseInt(str[1]);
                for(int i=0; i<x; i++){
                    k = up[k];
                }
            }
            // 삭제
            else if(ch == 'C'){
                stack.add(k);

                // stack에 정보 넣음
                up[down[k]] = up[k];
                down[up[k]] = down[k];

                if(n < down[k]){
                    k = up[k];
                } else {
                    k = down[k];
                }
            }
            // 복구
            else if(ch == 'Z'){
                int cur = stack.pop();
                up[down[cur]] = cur;
                down[up[cur]] = cur;
            }
        }

        char [] answer = new char[n];
        Arrays.fill(answer, 'O');

        for(int i: stack) {
            answer[i-1] = 'X';
        }
        return new String(answer);
    }
}
