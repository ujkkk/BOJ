import java.io.*;
import java.util.*;

public class Main {


    static int [][][] tomato;
    static boolean isVisited [][][];
    static int results [][][];
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

        tomato = new int[H+2][N+2][M+2];
        results = new int[H+2][N+2][M+2];
        for(int z =0; z<=H+1; z++){
            for(int r=0; r<=N+1; r++){
                for(int c=0; c<=M+1; c++){
                    tomato[z][r][c] = 999;
                    results[z][r][c] = Integer.MAX_VALUE;
                }
            }
        }
        isVisited = new boolean [H+2][N+2][M+2];

        // 토마토 입력
        boolean isFull = true;
        tomatos = new LinkedList<>();

        for(int z =1; z<=H; z++){
            for(int r=1; r<=N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=1; c<=M; c++){
                    tomato[z][r][c] = Integer.parseInt(st.nextToken());
                    if(isFull && tomato[z][r][c] == 0)
                        isFull= false;

                    if(tomato[z][r][c] == -1){
                        isVisited[z][r][c] = true;
                    }

                    // 익은 토마토 넣기
                    if(tomato[z][r][c] == 1){
                        tomatos.add(new Position(r,c,z, 0));
                        isVisited[z][r][c] = true;
                        results[z][r][c] = 0;
                    }
                }
            }
        }
        if(isFull){
            bw.write("0");
        }
        else{
            int dx [] = {0,1,0,-1,0,0};
            int dy [] = {1,0,-1,0,0,0};
            int dz [] = {0,0,0,0,1, -1};

            while(!tomatos.isEmpty()){
                Position curPosition = tomatos.poll();

                for(int i=0; i<dx.length; i++){
                    int nextX = curPosition.x + dx[i];
                    int nextY = curPosition.y + dy[i];
                    int nextZ = curPosition.z + dz[i];
                    int nextCount = curPosition.count +1;

                    if(isRange(nextX,nextY,nextZ) && results[nextZ][nextX][nextY] > nextCount && tomato[nextZ][nextX][nextY] != -1) {
                        tomatos.add(new Position(nextX, nextY, nextZ, nextCount));
                        isVisited[nextZ][nextX][nextY] = true;
                        results[nextZ][nextX][nextY] = nextCount;
                    }
                }
            }

            // 모두 익었는지 확인
            // 결과 확인
            int result = 0;
            boolean isOk = true;
            for(int z =1; z<=H; z++){
                for(int r=1; r<=N; r++){
                    for(int c=1; c<=M; c++){
                        if(!isVisited[z][r][c]){
                            isOk = false;
                            break;
                        }
                        if(results[z][r][c] != Integer.MAX_VALUE)
                            result = Math.max(results[z][r][c], result);
                    }
                }
            }
            if(isOk){
                bw.write(Integer.toString(result));
            } else{
                bw.write(Integer.toString(-1));
            }
        }
        bw.flush();

        bw.close();
        br.close();
    }


    public static boolean isRange(int x, int y, int z){
        if(x>=1 && x<=N && y>=1 && y<=M && z>=1 && z<=H)
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
