import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map = new HashMap();
        
        int size1 = str1.length();
        int count1 = 0;
        for(int i=0; i<size1-1; i++){
            String str = str1.substring(i, i+2).toLowerCase();
            
            if(str.charAt(0) < 'a' || str.charAt(0) >'z' || str.charAt(1) < 'a' || str.charAt(1) >'z' )
                continue;
            count1++;
            map.put(str, map.getOrDefault(str, 0) +1);
        }
        
        int size2 = str2.length();
        int interCount = 0;
        int count2 = 0;
        for(int i=0; i<size2-1; i++){
            String str = str2.substring(i, i+2).toLowerCase();
            if(str.charAt(0) < 'a' || str.charAt(0) >'z' || str.charAt(1) < 'a' || str.charAt(1) >'z' )
                continue;
            
            count2++;
            if(map.containsKey(str)){
                interCount++;
                System.out.println(str);
                
                int count = map.get(str);
                if(count == 1){
                    map.remove(str);
                }else{
                    map.put(str, count-1);
                }
            }
        }
        
        if(count1 == 0 && count2 == 0){
            return 65536;
        }
        int unionCount = count1 + count2 - interCount;
        System.out.println(String.format("%d/%d", interCount, unionCount));
        
        return interCount * 65536 / unionCount;
    }
}