import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int max = 0;
        int min = 1;
        
        // 데이터 저장
        List<Puzzle> ps = new ArrayList();
        for(int i=0; i<diffs.length; i++){
            ps.add(new Puzzle(diffs[i], times[i]));
            
            max = Math.max(max, diffs[i]);
        }

        
        int left = min;
        int right = max;
        
        while(left < right){
            int mid = (left+right)/2;
            // 현재 난이도로 돌려보기
            long sum = 0;
            
            int i;
            int pre = 0;
            for(i=0; i<diffs.length; i++){
                if(sum > limit){
                    break;
                }
                
                Puzzle cur = ps.get(i);
                if(cur.diff <= mid){
                    sum += cur.time;
                }
                else{
                    sum += ((cur.diff - mid)*(cur.time + pre) + cur.time);
                }
                pre = cur.time;
            }
                   
            if(sum > limit){
                left = mid +1;
            }
            else{
                right = mid;
            }
            
        }
        return right;
    }
}

class Puzzle implements Comparable<Puzzle>{
    int diff;
    int time;
    
    public Puzzle(int diff, int time){
        this.diff = diff;
        this.time = time;
    }
    
    @Override
    public int compareTo(Puzzle p){
        if(p.diff == this.diff){
            return this.time - p.time;
        }
        
        return this.diff - p.diff;
    }
}