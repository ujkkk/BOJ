import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N, M, K;
    static int map [][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for(int i=r1; i<r2; i++){
                for(int j=c1; j<c2; j++){
                    map[i][j] = 1;
                }
            }
        }

        // bfs 탐색
        int count = 0;
        ArrayList<Integer> size = new ArrayList<>();
        boolean [][] isVisited = new boolean[N+1][M+1];
        for(int i=0;i<N; i++){
            for(int j=0; j<M; j++){
                if(isVisited[i][j] || map[i][j] == 1)
                    continue;
                size.add(bfs(i, j, isVisited));
                count++;
            }
        }

        Collections.sort(size);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for(int s : size){
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int r, int c, boolean [][] isVisited){
        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        Queue<int []>que = new ArrayDeque<>();
        que.add(new int[]{r,c});
        isVisited[r][c] = true;

        int size = 0;
        while(!que.isEmpty()){
            int [] cur = que.poll();
            size++;

            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr <0 || nr >= N || nc <0 || nc >= M)
                    continue;
                if(map[nr][nc] == 1 || isVisited[nr][nc])
                    continue;

                que.add(new int[]{nr, nc});
                isVisited[nr][nc] = true;
            }
        }
        return size;
    }


}

