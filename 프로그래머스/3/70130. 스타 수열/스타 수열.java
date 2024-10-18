class Solution {
    public int solution(int[] a) {
        if(a.length == 1){
            return 0;
        }
        if(a.length == 2){
            return 1;
        }
        
        int [] counts = new int[a.length];
        for(int i=0; i<a.length; i++){
            counts[a[i]]++;
        }
        
        
        int max = 0;
        for(int i=0; i<a.length; i++){
            if(counts[i] <= max){
                continue;
            }
            int cnt=0;
            
            for(int j=0; j<a.length-1; j++){
                // 두 개의 원소가 같으면 
                if(a[j] == a[j+1]){
                    continue;
                }
                
                // 두 원소 모두 교집합이 아니면
                if(a[j] != i && a[j+1] != i){
                    continue;
                }
                
                cnt++;
                j++;
                
            }
            max = Math.max(cnt, max);
        }
        
        return max*2;
    }
}