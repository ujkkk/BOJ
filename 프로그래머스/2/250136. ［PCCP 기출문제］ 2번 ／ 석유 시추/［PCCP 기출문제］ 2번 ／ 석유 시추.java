import java.util.*;

class Solution {
    
    static int N, M;
    static int [][] groupMap;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        boolean [][] isVisited = new boolean[N][M];
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int groupNumber = 1;
        
        // 그룹화 및 석유량 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited[i][j] || land[i][j] == 0) {
                    continue;
                }
                int count = bfs(groupNumber, i, j, isVisited, land);
                countMap.put(groupNumber++, count);
            }
        }
    
        // 열을 탐색하면서 최대 석유량 계산
        int max = 0;
        for (int j = 0; j < M; j++) {
            Set<Integer> visitedGroups = new HashSet<>();
            int curMax = 0;
            
            for (int i = 0; i < N; i++) {
                if (land[i][j] == 0) continue;
                
                int curGroup = land[i][j];
                if (!visitedGroups.contains(curGroup)) {
                    visitedGroups.add(curGroup);
                    curMax += countMap.get(curGroup);
                }
            }
            
            max = Math.max(max, curMax);
        }
        
        return max;
    }
    
    int bfs(int groupNumber, int r, int c, boolean [][] isVisited, int[][] land) {
        Queue<Point> que = new LinkedList<>();
        int count = 0;
        
        que.add(new Point(r, c));
        isVisited[r][c] = true;
        
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        
        while (!que.isEmpty()) {
            Point cur = que.poll();
            land[cur.r][cur.c] = groupNumber;
            count++;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (isVisited[nr][nc] || land[nr][nc] == 0) {
                    continue;
                }
                
                que.add(new Point(nr, nc));
                isVisited[nr][nc] = true;
            }
        }
        return count;
    }
}

class Point {
    int r, c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
