class Solution {
    public static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visit(k, dungeons, 0, new boolean[k]);
        return ans;
    }
    
    public static void visit(int curStamina, int[][] dungeons, int depth, boolean []isVisited){
        ans = Math.max(ans, depth);
        
        for(int i=0; i< dungeons.length; i++){
            if(isVisited[i])
                continue;
            
            if(curStamina >= dungeons[i][0] && curStamina - dungeons[i][1] >= 0){
                isVisited[i] = true;
                visit(curStamina - dungeons[i][1], dungeons, depth+1, isVisited);
                isVisited[i] = false;
            }
            
        }
    }
}