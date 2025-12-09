import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        
        // 하나씩 증가 시키고 트리셋에 넣기
        TreeSet<Integer> set = new TreeSet();
        int size = numbers.length;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = set.pollFirst();
        }
        return answer;
    }
}