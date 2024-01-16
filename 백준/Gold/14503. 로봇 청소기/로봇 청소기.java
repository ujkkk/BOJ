import java.io.*;
import java.util.*;

public class Main{
    //
    //시계 방향
    public static int [] dr = {-1, 0, 1, 0};
    public static int [] dc = {0, 1, 0, -1};
    public static boolean [][] isVisited;

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N;
    public static int M;
    public static int ans = 0;

    public static Point start;
    public static int initDir;
    public static boolean map[][];

    public static void main(String [] args) throws Exception{
         br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력 - 초기위치, 초기 방향
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        initDir = Integer.parseInt(st.nextToken());
        start = new Point(r,c, initDir);

        // 입력 - 맵
        map = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                if(Integer.parseInt(st.nextToken())==1)
                    map[i][j] = false;
                else
                    map[i][j] = true;
            }
        }
        boolean [][] isVisited = new boolean[N][M];
        dfs(start, isVisited);

        bw.close();
        br.close();
    }

    public static void dfs(Point pos, boolean[][] isVisited) throws IOException {
        if(!isVisited[pos.row][pos.col]){
            isVisited[pos.row][pos.col] = true;
            // 현재 칸 청소
            ans++;
        }

        int i;

        for(i=1; i<=4; i++){
            int newR = pos.row + dr[(pos.dir - i+4)%4];
            int newC = pos.col + dc[(pos.dir - i+4)%4];
            if(isRange(newR, newC) && !isVisited[newR][newC] && map[newR][newC]){
                dfs(new Point(newR, newC,(pos.dir - i+4)%4), isVisited);
                break;
            }
        }
        // 후진
        if(i == 5){
            int backR = pos.row - dr[pos.dir];
            int backC = pos.col - dc[pos.dir];
            // 후진 했을 때 범위를 벗어나거나 막혀있는 벽이면 종료
            if(!isRange(backR, backC) || !map[backR][backC]){
                bw.write(ans+"\n");
                bw.flush();

                return;
            }
            dfs(new Point(backR,backC, pos.dir), isVisited);
        }



    }

    public static boolean isRange(int r, int c){
        if(r>=0 && r<N && c>=0 && c<M)
            return true;
        return false;
    }


}

class Point{
    int row;
    int col;
    int dir;

    public Point(int row, int col, int dir){
        this.row = row;
        this.col =col;
        this.dir = dir;
    }
}