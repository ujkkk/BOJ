import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        
        List<Integer> [] graph = new List[n+1];
        
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        // 그래프 완성
        for(int i=0; i<lighthouse.length; i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        boolean [] check = new boolean[n+1];
        int dp[][] = new int[n+1][2];
        
        // for(int i=0; i<dp.length; i++){
        //     dp[i][0] = 200000;
        //     dp[i][1] = 200000;
        // }
        
        dfs(1, graph, check, dp);
        
        //print(dp);
        return Math.min(dp[1][0], dp[1][1]);
        
    }
    
    public void print(int [][] dp){
        for(int i=0; i<dp.length; i++){
            System.out.println(i +" - [x]:" +dp[i][0] + " [o]: " + dp[i][1]);
        }
    }
    
    public void dfs(int n,  List<Integer> [] graph, boolean [] check, int [][] dp){
        
        check[n] = true;
        boolean isLast = true;
        
        int min = 20000;
        for(int next : graph[n]){
            if(check[next]){
                continue;
            }
            
            isLast = false;
            dfs(next, graph, check, dp);
            // n번째 등대를 선택하지 않았을 때
            dp[n][0] += dp[next][1];
            
            // n번째 등대를 선택 했을 때
            dp[n][1] += Math.min(dp[next][0], dp[next][1]);
            //dp[n][1] = Math.max(dp[next][1] + 1, dp[next][0] +1);
        }
        dp[n][1]++;
        
        if(isLast){
            dp[n][1] = 1; 
        }
        
        // System.out.println(n + "방문");
        
    }
}
