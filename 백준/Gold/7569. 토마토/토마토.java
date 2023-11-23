import java.io.*;
import java.util.*;

public class Main {
    static int [][][] tomato;
    static Queue<Position> tomatos;
    static int N;
    static int M;
    static int H;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=  new StringTokenizer(br.readLine());
        // 가로 칸
         M = Integer.parseInt(st.nextToken());
        // 세로 칸
         N = Integer.parseInt(st.nextToken());
        // 높이
         H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        // 확인해야할 총 토마토 개수
        int goal = M*N*H;

        // 토마토 입력
        boolean isFull = true;
        tomatos = new LinkedList<>();

        for(int z =0; z<H; z++){
            for(int r=0; r<N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<M; c++){
                    tomato[z][r][c] = Integer.parseInt(st.nextToken());
                    if(tomato[z][r][c] == -1){
                        goal--;
                    }
                    // 익은 토마토 넣기
                    if(tomato[z][r][c] == 1){
                        tomatos.add(new Position(r,c,z, 0));
                    }
                }
            }
        }

        int now = 0;
        int time = 0;
        int dx [] = {0,1,0,-1,0,0};
        int dy [] = {1,0,-1,0,0,0};
        int dz [] = {0,0,0,0,1, -1};

        while(!tomatos.isEmpty()){
            Position curPosition = tomatos.poll();
            time = curPosition.count;
            now++;
            for(int i=0; i<dx.length; i++){
                int nextX = curPosition.x + dx[i];
                int nextY = curPosition.y + dy[i];
                int nextZ = curPosition.z + dz[i];

                if(isRange(nextX,nextY,nextZ)) {
                    // 안 익은 토마토라면 추가
                    if(tomato[nextZ][nextX][nextY] == 0){
                        tomato[nextZ][nextX][nextY] = 1;
                        tomatos.add(new Position(nextX, nextY, nextZ, time+1));
                    }
                }
            }
        }

        // 결과 확인
        if(now == goal){
            bw.write(Integer.toString(time));
        } else{
            bw.write(Integer.toString(-1));
        }

        bw.flush();

        bw.close();
        br.close();
    }


    public static boolean isRange(int x, int y, int z){
        if(x>=0 && x<N && y>=0 && y<M && z>=0 && z<H)
            return true;
        return false;
    }
}

class Position{
    int x;
    int y;
    int z;
    int count;

    public Position(int x, int y, int z, int count){
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }
}
