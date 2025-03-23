import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder find = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int size = 0;
        
        for(int i=0; i< t * m; i++){
            String str = Integer.toString(i, n);
            size += str.length();
            find.append(str);
            
            if(size > t * m){
                break;
            }
        }
        
        //System.out.println(find.toString());
        for(int i= 0; i<t; i++){
            ans.append(find.charAt(i*m + p-1));
        }
        
        return ans.toString().toUpperCase();
    }
}