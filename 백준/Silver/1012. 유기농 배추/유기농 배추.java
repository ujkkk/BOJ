
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean [][] map = new boolean[R][C];

            // 맵 구성
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = true;
            }

            boolean [][] isVisited = new boolean[R][C];
            int ans = 0;

            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(isVisited[r][c] || !map[r][c]) continue;
                    isVisited[r][c]= true;
                    bfs(map, new int[]{r,c}, isVisited);
                    ans++;
                }
            }
            result.append(ans).append("\n");

        }
        System.out.println(result);
    }

    public static void bfs(boolean [][] map, int [] start, boolean [][] isVisited){
        Queue<int[]> que = new ArrayDeque();
        que.add(start);

        int [] dr = {-1, 0 ,1 ,0};
        int [] dc = {0, 1, 0, -1};
        int R = map.length;
        int C = map[0].length;

        while(!que.isEmpty()){
            int [] cur = que.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nr >=R || nc < 0 || nc >=C)
                    continue;
                if(isVisited[nr][nc] || !map[nr][nc])
                    continue;

                isVisited[nr][nc] = true;
                que.add(new int[]{nr, nc});
            }
        }
    }

}