import java.util.*;

class Solution {
    
    static int N, M;
    static int [][] groupMap;
    static int [] counts;
    public int solution(int[][] land) {
        // 1. BFS로 그룹번호 map, <number, count> 얻기
        N = land.length;
        M = land[0].length;
        
        boolean [][] isVisited = new boolean[N][M];
        counts = new int[M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(isVisited[i][j] || land[i][j] == 0){
                    continue;
                }
                bfs(i, j, isVisited,land);
            }
        }
        
        // 2. 하나씩 열 탐색하면서 최대치 구하기
        int max = 0;
        for(int j=0; j<M; j++){
            //System.out.println(counts[j]);
            max = Math.max(max, counts[j]);
        }
        
        return max;
    }
    
    void bfs(int r, int c, boolean [][] isVisited, int[][] land){
        Queue<Point> que = new LinkedList();
        
        que.add(new Point(r,c));
        isVisited[r][c] = true;
        
        int [] dr = {0, -1, 0, 1};
        int [] dc = {1, 0, -1, 0};
        
        // 방문한 열을 저장할 set
        Set<Integer> set = new HashSet();
        int count = 0;
        
        while(!que.isEmpty()){
            Point cur = que.poll();
            count++;
            set.add(cur.c);
            
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr <0|| nr >=N || nc <0 || nc >=M){
                    continue;
                }
                if(isVisited[nr][nc] || land[nr][nc] == 0){
                    continue;
                }
                
                que.add(new Point(nr, nc));
                isVisited[nr][nc] = true;
            }
        }
        
        for(int idx : set){
            counts[idx] += count;
        }
        
    }
}

class Point{
    int r;
    int c;
    
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}