import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        // BFS로 최단거리 확보
        HashMap<String, Integer> map = new HashMap();
        int count = 0;
        
        for(int i=0; i<routes.length; i++){
            List<Integer> shotList = new ArrayList();
            
            for(int j=0; j<routes[i].length-1; j++){
                int s = routes[i][j] - 1;
                int e = routes[i][j+1] - 1;
            
                int start = points[s][0]*1000 + points[s][1];
                int end = points[e][0]*1000 + points[e][1];
            
                shortestRoute(start, end, shotList);
            }
            
            String str = "";
            for(int p=0; p<shotList.size(); p++){
                str = p + ":" + shotList.get(p);
                
                if(map.get(str) == null){
                    map.put(str, 1);
                    continue;
                }
                
                int value = map.get(str);
                if(value == 1){
                    count++;
                }
                map.put(str, value+1);
            }
        }
        
        return count;
    }
    
    private void shortestRoute(int start, int end, List<Integer> shotList){
        int r = start/1000;
        int c = start%1000;
        
        int er = end/1000;
        int ec = end%1000;
        
        // 맨 처음 경로에서 시작했을 때 
        if(shotList.size() == 0){
            shotList.add(start);
        }
        while(r != er){
            r = r>er ? r-1: r+1;
            shotList.add(r*1000 + c);
        }
        
        while(c != ec){
            c = c>ec? c-1: c+1;
            shotList.add(r*1000 + c);
        }
        
    }
}
