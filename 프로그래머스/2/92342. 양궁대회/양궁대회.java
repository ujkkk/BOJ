// 14:38~
class Solution {
    static int max = 0;
    
    // max가 같을 때 
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        dfs(0, info, 0, 0, n, new int[info.length], answer);
        
        if(max == 0){
            return new int[]{-1};
        }
        
        return answer;
    }
    
    
    void dfs(int aSum, int [] info, int depth, int sum, int curN, int [] counts, int[] answer){
        if(depth == info.length){
//             if(curN == 0){
//                 for(int j=depth; j<info.length; j++){
//                     if(info[j] == 0 && counts[j] == 0){
//                         continue;
//                     }
//                     if(info[j] >= counts[j]){
//                         aSum += (10-j);
//                     }
//                     else{
//                         sum += (10-j);
//                     }
                    
//                 }
//             }
            // System.out.println(String.format("## %d에서 끝, 차 : %d, sum : %d, aSum : %d", depth , sum - aSum, sum, aSum));
           
            if(aSum > sum){
                return;
            }
            
            // 1. 가장 높은 점수로 갱신
            if(sum - aSum > max){
                
                max = sum- aSum;
                for(int i=0; i<counts.length; i++){
                    answer[i] = counts[i];
                }
            }
            
            // 2. 낮은 점수를 더 많이 맞힌 경우로 갱신
            else if(max == sum - aSum ){
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
        
         int end = sum;
         for(int j=depth; j<info.length; j++){
            end += (10-depth);
        }
        if(end < max){
            return;
        }
            
        // 갯수 정하기
        for(int i=info[depth]+1; i>=0; i--){
            if(curN - i < 0){
                continue;
            }
            
            if(info[depth] == 0 && i == 0){
                sum += 0;
            }
            else if(i > info[depth]){    //쏜 화살이 어피치의 화살 수 보다 클 때 (승리))
                sum += (10-depth);
            }
            else{
                aSum += (10-depth);
            }
          
            counts[depth] = i;
            dfs(aSum, info, depth+1, sum, curN - i, counts, answer);
            
            if(info[depth] == 0 && i == 0){
                sum += 0;
            }
            else if(i > info[depth]){
                sum -= (10-depth);
            }
            else{
                aSum -= (10-depth);
            }
        }
    }
}