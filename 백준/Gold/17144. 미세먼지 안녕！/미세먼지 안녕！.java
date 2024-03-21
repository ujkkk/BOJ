import java.io.*;
import java.util.*;

public class Main {
    public static int R;
    public static int C;
    public static int T;
    public static int map[][];

    public static int robotBottom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 미세먼지 정보 입력 받기
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    robotBottom = i;
                }
            }
        }

        for(int t=0; t<T; t++){
            // 1. 미세먼지 확산
            diffuseDusts();
            // 2. 로봇청소기 공기 흡입
            robotRun();
        }
        
        // 남아있는 미세먼지의 양
        int sum = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum+2);
    }
    public static void robotRun(){
        int top = robotBottom -1;
        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }
        map[top][1] = 0;

        // top은 반시계 방향으로 회전
        for (int x = robotBottom +1; x < R-1; x++) {
            map[x][0] = map[x+1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R-1][y] = map[R-1][y + 1];
        }

        for (int x = R-1; x > robotBottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[robotBottom][y] = map[robotBottom][y - 1];
        }
        map[robotBottom][1] = 0;

    }

    public static void diffuseDusts(){
        // 확산된 먼지를 저장할 배열
        int newDust [][] = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] > 0){
                    // 현재 칸에 미세먼지가 있다면 확산 시작
                    diffuseDust(i, j ,newDust);
                }
            }
        }
        // 확산된 먼지의 양을 map에 반영
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += newDust[i][j];
            }
        }
    }

    public static void diffuseDust(int r, int c, int [][] newDust){
        int [] dr ={-1,0, 1, 0};
        int [] dc = {0, 1, 0, -1};
        int count = 0;
        // 상하좌우 확인
        for(int i=0; i<dr.length; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            if(isRange(newR, newC) && map[newR][newC] != -1){
                count++;
                newDust[newR][newC] += map[r][c]/5;
            }
        }
        // 확산된 양만큼 미세먼지 양 줄이기
        map[r][c] = map[r][c] - ((map[r][c]/5)*count);
    }

    public static boolean isRange(int r, int c){
        if(r>=0 && r<R && c>=0 && c<C)
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

