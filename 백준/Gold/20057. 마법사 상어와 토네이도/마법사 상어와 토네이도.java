import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int [][] map;
    static int out = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sum = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        moveTornado();
        int remain = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                remain+= map[i][j];
            }
        }
        System.out.println(out);
    }

    private static void moveTornado() {
        // 1. 토네이도 이동
        int [][] temp = new int[N][N];
        Point cur = new Point(N/2, N/2);
        int [] dr = {0, 1, 0, -1};
        int [] dc = {-1, 0, 1, 0};
        int idx = 0;
        int length = 0;

        while(true){
            if(cur.r == 0 && cur.c == 0) break;
            // 짝수마다 길이 증가
            length++;

            // 2번마다 length 증가
            for(int i=0; i<2; i++){
                for(int j=0; j<length; j++){
                    int dir = idx%4;
                    cur.r +=  dr[dir];
                    cur.c += dc[dir];

                    spreadSend(new Point(cur.r, cur.c), dir);
                    if(cur.r == 0 && cur.c == 0)
                        return;
                }
                idx++;
            }

        }

    }


    static private void spreadSend(Point cur, int dir){
        if(dir == 0 || dir == 2){
            spreadLeftOrRight(cur, dir);
        }
        else{
            spreadTopOrBottom(cur, dir);
        }
    }


    /**
     *
     * @param cur : y 좌표
     * @param dir : bottom or top(1 or 3)
     */
    static private void spreadTopOrBottom(Point cur, int dir){
        int [] dr = {-1, -1, 0, 0, 0, 0, 1,  1, 2};
        int [] dc = {-1, 1, -2, -1, 1, 2, -1,  1, 0};
        double [] ratio = {0.01, 0.01, 0.02, 0.07, 0.07, 0.02, 0.1,  0.1, 0.05};
        int [] pos = {0, 1, 0, -1}; // top인 경우에 r좌표에 -1

        int send  = map[cur.r][cur.c];

        for(int i=0; i<dr.length; i++){
            int nextR = cur.r + dr[i]*pos[dir];
            int nextC = cur.c + dc[i];

            int moveSend = (int)(send*ratio[i]);
            // 흩날리는 모래양
            map[cur.r][cur.c] -= moveSend;

            // 범위를 벗어나지 않음
            if(nextR >=0 && nextR <N && nextC >=0 && nextC <N){
                // 비율 칸에 모래 추가
                map[nextR][nextC] += moveSend;
            }
            else{
                out += moveSend;
            }
        }

        if(cur.r + pos[dir] >=0 && cur.r + pos[dir]<N){
            map[cur.r + pos[dir]][cur.c] += map[cur.r][cur.c];
        }
        else{
            out +=  map[cur.r][cur.c];
        }
        map[cur.r][cur.c] = 0;

    }

    /**
     *
     * @param cur : y 좌표
     * @param dir : left or right(0 or 2)
     */
    static private void spreadLeftOrRight(Point cur, int dir){
        int [] dr = {-2, -1, -1, -1, 0, 1, 1, 1, 2};
        int [] dc = {0, -1, 0, 1, -2, -1, 0, 1, 0};
        double [] ratio = {0.02, 0.1, 0.07, 0.01, 0.05,  0.1, 0.07, 0.01, 0.02};
        int [] pos = {1,0,-1}; // 오른쪽인 경우에 c좌표에 -1 곱함

        int send = map[cur.r][cur.c];

        for(int i=0; i<dr.length; i++){
            int nextR = cur.r + dr[i];
            int nextC = cur.c + dc[i]*pos[dir];

            int moveSend = (int)(send*ratio[i]);
            map[cur.r][cur.c] -= moveSend;
            // 범위를 벗어나지 않음
            if(nextR >=0 && nextR <N && nextC >=0 && nextC <N){
                map[nextR][nextC] += moveSend;
            }
            else{
                out+= moveSend;
            }
        }

        if(cur.c -pos[dir] >=0 && cur.c -pos[dir]<N){
            // 남아있는 양 a 칸으로 이동
            map[cur.r][cur.c -pos[dir]] += map[cur.r][cur.c];
        }else{
            out+= map[cur.r][cur.c];
        }
        map[cur.r][cur.c] = 0;
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
