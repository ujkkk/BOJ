import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;
        
        HashMap<String, Integer> map = new HashMap();
        int ans = 0;
        
        for(int time =0; time< cities.length; time++){
            String city = cities[time].toLowerCase();
            // hit
            if(map.containsKey(city)){
                ans += 1;
                map.put(city, time);
            }
            
            // miss
            else{   
                ans += 5;
                
                if(map.size() == cacheSize) {
                    // 지우기 - 가장 늦게 참조된 것
                    String leastKey = " ";
                    int least = time;

                    for(String key : map.keySet()){
                        if(map.get(key) < least){
                            leastKey = key;
                            least = map.get(key);
                        }
                    }
                    map.remove(leastKey);
                }
                
                map.put(city, time);
            }
        }
        
        return ans;
    }
}

