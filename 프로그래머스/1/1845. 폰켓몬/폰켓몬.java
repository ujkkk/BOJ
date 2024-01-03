import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int selectSize = nums.length/2;
        int mapSize=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.get(n) == null)
                mapSize++;
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        int answer = 0;
        return (selectSize > mapSize? mapSize : selectSize);
    }
}