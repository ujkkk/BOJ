import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean [][] map;

    public static void main(String[] args) throws IOException {

        // 입력 시작
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for(int i=0; i<N; i++){
            String [] str = br.readLine().split("");
            for(int j=0; j<M; j++){
                if(str[j].equals("1")){
                    map[i][j] = true;
                }
                else {
                    map[i][j] = false;
                }
            }
        } // 입력 끝

        // 최소거리 -> bfs 이용
        Queue<Point> que = new LinkedList<>();
        boolean [][] isVisited = new boolean[N][M];
        int [][] count = new int[N][M];

        int [] dr = {-1, 0, 1, 0};
        int [] dc = {0, 1, 0, -1};

        que.add(new Point(0, 0));
        isVisited[0][0] = true;
        count[0][0] = 1;

        while(!que.isEmpty()){
            Point cur = que.poll();
            if(cur.r == N-1 && cur.c == M-1){
                break;
            }

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 미로 범위 확인
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(!isVisited[nr][nc] && map[nr][nc]){
                    que.add(new Point(nr, nc));
                    isVisited[nr][nc] = true;
                    // (nr,nc) 위치를 지나는 최소 칸 수
                    count[nr][nc] = count[cur.r][cur.c] + 1;
                }
            }
        }
        System.out.println(count[N-1][M-1]+"");

    }


}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
