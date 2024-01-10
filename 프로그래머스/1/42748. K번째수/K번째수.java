import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> reusltList = new ArrayList();
        
        
        for(int t= 0; t< commands.length; t++){
            // 배열 자르기
            int [] sliceArray = Arrays.copyOfRange(array, commands[t][0]-1, commands[t][1]);
            // 오름차순 정렬
            Arrays.sort(sliceArray);
            reusltList.add(sliceArray[commands[t][2]-1]);
        }
        
        int[] answer = new int[reusltList.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = reusltList.get(i);
        }
        
        return answer;
    }
}