import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        // 이진변환 몇번, 0의 개수 몇 개 제거
        int zeroCount = 0;
        int binTrans = 0;
        
        List<Integer> bin = new ArrayList();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                bin.add(1);
            }
            else{
                bin.add(0);
            }
        }
        int c = 0;
        while(true){
            if(bin.size() == 1 && bin.get(0) == 1){
                break;
            }
            binTrans++;
            
            // 0제거하면서 개수 세고, 1개수 몇개인지
            int oneCount = 0;
            for(int n : bin){
                if(n == 1){
                    oneCount++;
                }
                else{
                    zeroCount++;
                }
            }
            bin = new ArrayList();
            binary(oneCount, bin, 0);
        }
        
        return new int[]{binTrans, zeroCount};
    }
    
    void binary(int n, List<Integer> bin, int depth){
        if(n == 1){
            bin.add(1);
            return;
        }
        binary(n/2, bin, depth+1);
        bin.add(n%2);
    }
    
}