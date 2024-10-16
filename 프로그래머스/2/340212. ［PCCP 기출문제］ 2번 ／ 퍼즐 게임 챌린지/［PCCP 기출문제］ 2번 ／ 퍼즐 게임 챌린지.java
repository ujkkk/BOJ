class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100_000;
        
        int start = 1;
        int end = 100_002;
        
        while(start < end){
            int level = (start + end) / 2;
            //System.out.println("level: " + level);
            
            // 걸린 시간 구하기
            long sum = 0;
            for(int i=0; i<diffs.length; i++){
                // 풀 수 있음
                if(diffs[i] <= level){
                    sum += times[i];
                }
                // 틀림
                else{
                    int repeat = diffs[i] - level;
                    sum +=  (times[i] + times[i-1])*repeat + times[i];
                }
                
            }
            // 제한 시간 내에 풀 수 있음
            if(sum <= limit){
                answer = Math.min(answer, level);
                System.out.println("[O]" + level+"에서 풀 수 있음 : "+ sum);
                end = level;
            }
            // 풀 수 없음
            else{
                start = level+1;
                System.out.println("[X]" + level+"에서 풀 수 없음: " + sum);
            }
        }
        
        return answer;
    }
}