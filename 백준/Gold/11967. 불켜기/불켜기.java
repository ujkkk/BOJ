import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;

    static List<Point>[][] switchs;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        switchs = new ArrayList[N + 1][N + 1];

        for (int i = 0; i < N * N; i++) {
            switchs[i / N + 1][i % N + 1] = new ArrayList<Point>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            switchs[x1][y1].add(new Point(x2, y2));
        }

        // BFS
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(1, 1));
        boolean [][] isVisited = new boolean[N+1][N+1];
        boolean [][] isLight = new boolean[N+1][N+1];
        Queue<Point> candidatePos = new LinkedList<>();

        isVisited[1][1] = true;
        isLight[1][1] = true;
        int max = 1;
        while(!que.isEmpty()){
            Point cur = que.poll();
            //System.out.println(String.format("방문 %d, %d", cur.r, cur.c));

            // 방문 가능 후보지 넣기
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr <=0 || nr > N || nc <=0 || nc >N){
                    continue;
                }
                if(isVisited[nr][nc]){
                    continue;
                }

                candidatePos.add(new Point(nr, nc));
            }

            // 불 켜기
            for(Point light: switchs[cur.r][cur.c]){
                if(isLight[light.r][light.c])
                    continue;

                max++;
                isLight[light.r][light.c] = true;

                //System.out.println(String.format("불켜기 %d, %d", light.r, light.c));
            }

            // 방문 가능한 좌표 확인
            int size = candidatePos.size();

            for(int i=0; i<size; i++){
                Point candidate = candidatePos.poll();

                if(isLight[candidate.r][candidate.c] && !isVisited[candidate.r][candidate.c]){
                    que.add(new Point(candidate.r, candidate.c));
                    isVisited[candidate.r][candidate.c] = true;
                   // System.out.println(String.format("큐삽입 %d, %d", candidate.r, candidate.c));
                }
                else{
                    candidatePos.add(candidate);
                }
            }

        }
        System.out.println(max);
    }



}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}