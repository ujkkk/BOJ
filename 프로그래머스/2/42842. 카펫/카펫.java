class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
  
        // 가로가 더 김
        for(int i=1; i<=2_000_000; i++){
            for(int j=1; j<=i; j++){
                if(((i-2)*(j-2) == yellow) && (2*i + 2*j - 4 == brown)){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}