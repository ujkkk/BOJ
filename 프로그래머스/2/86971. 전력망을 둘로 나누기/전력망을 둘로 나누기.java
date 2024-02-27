import java.util.*;

class Solution {
    
    public static int ans = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for(int i=0; i< tree.length; i++){
            tree[i] = new ArrayList<Integer>();
        }
        // 간선 정보를 ArrayList로 저장
        for(int [] wire : wires){
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        
        // 간선 하나하나 끊어보기
        for(int [] wire : wires){
            tree[wire[0]].remove(0);
            tree[wire[1]].remove(0);
            
            int n1 = getGroupCount(wire[0], tree);
            int n2 = getGroupCount(wire[1], tree);
            ans = Math.min(Math.abs(n1-n2), ans);
            
            // 원상 복귀
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }
        return ans;
    }
    
    public static int getGroupCount(int n, ArrayList<Integer>[] tree){
        boolean isVisited [] = new boolean[tree.length+1];
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(n);
        isVisited[n] = true;
        int count = 0;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            isVisited[cur] = true;
            count++;
            
            for(int next : tree[cur]){
                if(!isVisited[next]){
                    que.add(next);
                }
            }
        }
        return count;
    }
}