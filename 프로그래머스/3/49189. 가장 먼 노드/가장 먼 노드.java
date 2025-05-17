import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList();
        }
        
        for(int [] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        //bfs
        answer = bfs(graph, n);
        
        return answer;
    }
    
    public int bfs(ArrayList<Integer>[] graph, int n){
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(1);
        boolean isVisited [] = new boolean[n+1];
        isVisited[1] = true;
        int size = 0;
        
        while(!que.isEmpty()){
            size = que.size();
            
            for(int i=0; i<size; i++){
                int cur = que.poll();
                for(int next : graph[cur]){
                    if(isVisited[next]) continue;
                    
                    que.add(next);
                    isVisited[next] = true;
                }
            }
        }
        return size;
        
    }
}