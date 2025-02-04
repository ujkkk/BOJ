// 14:38~ 16:02
class Solution {
    static int max = 0;
    
    // max가 같을 때 
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        dfs(info, 0, n, new int[info.length], answer);
        
        if(max == 0){
            return new int[]{-1};
        }
        
        return answer;
    }
    
    
    void dfs(int [] info, int depth, int curN, int [] counts, int[] answer){
        if(curN == 0 || depth == info.length){
            
            int diff = score(info, counts);
            if(diff < 0){
                return;
            }
            
            // 1. 가장 높은 점수로 갱신
            if(diff > max){
                
                max = diff;
                for(int i=0; i<info.length; i++){
                    answer[i] = counts[i];
                }
            }
            
            // 2. 낮은 점수를 더 많이 맞힌 경우로 갱신
            else if(max == diff){
                for(int j = info.length -1; j>=0; j--){
                    if(answer[j] == counts[j]){
                        continue;
                    }
                    
                    if(answer[j] < counts[j]){
                        for(int i=0; i<counts.length; i++){
                            answer[i] = counts[i];
                        }
                        break;
                    } 
                    break;
                }
            }
            return; 
        }
            
        // 갯수 정하기
        for(int i=info[depth]+1; i>=0; i--){
            if(curN - i < 0){
                continue;
            }
            
            counts[depth] = i;
            dfs(info, depth+1, curN - i, counts, answer);
            
            }
        }
    
    int score(int [] a1, int [] a2){
        int apeach = 0;
        int lion = 0;
        
        for(int i=0; i<a1.length; i++){
            if(a1[i] == 0 && a2[i] == 0){
                continue;
            }
            if(a1[i] >= a2[i]){
                apeach += (10-i);
            }else{
                lion += (10-i);
            }
        }
        
        return lion - apeach;
    }
}