import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int  K, R, C;
    public static int [][] map;
    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = BFS();
        System.out.println(result +"");

    }

    public static int BFS(){
        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};

        int [] nightDr = {-1 ,-2, -2, -1, 1, 2, 2, 1};
        int [] nightDc = {-2, -1, 1, 2, -2, -1, 1, 2};

        Queue<Point> que = new LinkedList<>();
        boolean [][][] isVisited = new boolean[R][C][K+1];

        que.add(new Point(0, 0, 0, 0));
        isVisited[0][0][0] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            //System.out.println(String.format("[%d, %d] k = %d", cur.r, cur.c, cur.k));
            if(cur.r == R-1 && cur.c == C-1){
                return cur.count;
            }

            // 말처럼 이동
            if(cur.k < K){
                for(int i=0; i<nightDr.length; i++){
                    int nextR = cur.r + nightDr[i];
                    int nextC = cur.c + nightDc[i];

                    if(nextR >=0 && nextR < R && nextC >=0 && nextC < C && !isVisited[nextR][nextC][cur.k+1]){
                        if(map[nextR][nextC] == 1)
                            continue;

                        que.add(new Point(nextR, nextC, cur.k +1, cur.count +1));
                        isVisited[nextR][nextC][cur.k +1] = true;
                    }
                }
            }

            // 상하좌우 넣기
            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >=0 && nextR < R && nextC >=0 && nextC < C && !isVisited[nextR][nextC][cur.k]){
                    if(map[nextR][nextC] == 1)
                        continue;

                    que.add(new Point(nextR, nextC, cur.k, cur.count +1));
                    isVisited[nextR][nextC][cur.k] = true;
                }
            }


        }
        return -1;
    }

}

class Point{
    int r;
    int c;
    int k;
    int count;

    public Point(int r, int c, int k, int count) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.count = count;
    }
}
