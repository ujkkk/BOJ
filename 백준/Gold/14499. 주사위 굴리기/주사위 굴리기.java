import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int [][] dice;
    public static int [][] map;
    public static Point cur;
    public static int N,M;

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[4][3];
        cur = new Point(x,y);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int dir = Integer.parseInt(st.nextToken());
            Point next = nextPos(dir, cur);

            // 범위 체크
            if(!isRange(next))
                continue;
            
            // 주사위 돌리기
            cur = next;
            turnDice(dir);

            // 현재 칸 체크
            // 0이면 주사위 바닥면 수가 맵에 복사됨
            if(map[cur.r][cur.c] == 0){
                map[cur.r][cur.c] = dice[3][1];
            }
            // 0이 아니면 칸에 쓰여있는 수가 주사위 바닥면에 복사됨
            else{
                dice[3][1] = map[cur.r][cur.c];
                // 칸은 0이 됨
                map[cur.r][cur.c] = 0;
            }

            // 주사위 윗 면 출력
            bw.write(dice[1][1]+"\n");

        }


        bw.flush();
    }

    public static boolean isRange(Point cur){
        if(cur.r>= 0 && cur.r<N &&cur.c>=0 && cur.c <M)
            return true;
        return false;
    }
    public static Point nextPos(int dir, Point cur){
        int [] dr = {0, 0, -1, 1};
        int [] dc = {1, -1, 0, 0};

        return new Point(cur.r + dr[dir-1], cur.c+dc[dir-1]);
    }

    public static void turnDice(int dir){
        int pre;
        switch (dir){
            case 1:
                pre = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = pre;
                break;
            case 2:
                pre = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = pre;
                break;
            case 3:
                pre = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = dice[0][1];
                dice[0][1] = pre;
                break;
            case 4:
                pre = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = pre;
        }

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
