import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        // 각 수포자가 찍은 데이터 배열로 만듦
        int size = answers.length;
        int a [][] = new int[3][size];
        
        
        int a2Count = 0;
        int a3Temp [] = {3,3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i=0; i<size; i++){
            a[0][i] = (i)%5 + 1;
            
            if(i%2 == 0){
                a[1][i] = 2;
            }
            else{
                a2Count = a2Count%5 + 1;
                if(a2Count == 2) a2Count++;
                a[1][i] = a2Count;
            }
            
            a[2][i] = a3Temp[i%10];
        }
        
        // 값 비교
        int winCounts [] = new int[3];
        for(int i=0; i<3; i++){
            for(int j=0; j<size; j++){
                if(a[i][j] == answers[j]){
                    winCounts[i]++;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int max = 0;
        for(int i=0; i<3; i++){
            max= Math.max(max, winCounts[i]);
        }
        for(int i=0; i<3; i++){
            if(winCounts[i] == max){
                ans.add(i+1);
            }
        }
        
        return ans;
    }
}