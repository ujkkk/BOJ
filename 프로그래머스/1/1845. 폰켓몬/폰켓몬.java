import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int selectSize = nums.length/2;
      
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        return (selectSize > set.size()? set.size() : selectSize);
    }
}