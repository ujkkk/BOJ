import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int [][] map;

    public static int robotBottom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 맵 입력 받기
        for(int i=0; i<N; i++){
            String [] str = br.readLine().split("");
            for(int j= 0; j<M; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        if(BFS()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static boolean BFS(){
        int dr [] = {-1, 0, 1, 0};
        int dc [] = {0, 1, 0, -1};

        Queue<Point> que = new LinkedList<Point>();
        boolean [][] isVisited = new boolean[N][M];

        // 첫 행에 있는 흰 블록 넣어 주기
        for(int i=0; i<M; i++){
            if(map[0][i] == 0)
                que.add(new Point(0, i));
        }

        while(!que.isEmpty()){
            Point cur = que.poll();
            if(cur.r == N-1)
                return true;
            if(isVisited[cur.r][cur.c])
                continue;
            isVisited[cur.r][cur.c] = true;

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];
                if(isRange(nextR, nextC) && map[nextR][nextC] == 0){
                    if(!isVisited[nextR][nextC])
                        que.add(new Point(nextR, nextC));
                }
            }
        }
        return false;
    }

    public static boolean isRange(int r, int c){
        if(r >=0 && r<N && c>=0 && c<M)
            return true;
        return false;
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


