import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int O = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        // 배열 입력 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int o=0; o<O; o++){
            int oper = Integer.parseInt(st.nextToken());
            switch (oper){
                case 1:
                    map = f1(map);
                    break;
                case 2:
                    map = f2(map);
                    break;
                case 3:
                    map = f3(map);
                    break;
                case 4:
                    map = f4(map);
                    break;
                case 5:
                    map = f5(map);
                    break;
                case 6:
                    map = f6(map);
                    break;
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0;j<map[0].length; j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static int [][] deepCopy(int [][] origin){
        int [][] copy = new int[origin.length][origin[0].length];
        for(int i=0; i<origin.length; i++){
            for(int j=0; j<origin[0].length; j++){
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
    // 상하좌우 반전 연산
    public static int[][] f1(int [][] origin){
        int R = origin.length;
        int C = origin[0].length;

        int [][] newMap = new int [R][C];
        for(int r=0; r<R; r++){
            for(int c = 0; c<C; c++){
                newMap[R-r-1][c] = origin[r][c];
            }
        }
        return newMap;
    }
    // 좌우 반전
    public static int[][] f2(int [][] origin){
        int R = origin.length;
        int C = origin[0].length;

        int [][] newMap = new int [R][C];
        for(int r=0; r<R; r++){
            for(int c = 0; c<C; c++){
                newMap[r][C-c-1] = origin[r][c];
            }
        }
        return newMap;
    }
    // 오른쪽 90도 회전
    public static int[][] f3(int [][] origin){
        int R = origin.length;
        int C = origin[0].length;

        int [][] newMap = new int [C][R];
        for(int r=0; r<R; r++){
            for(int c = 0; c<C; c++){
                newMap[c][R-1-r] = origin[r][c];
            }
        }
        return newMap;
    }
    // 왼쪽으로 90도 회전
    public static int[][] f4(int [][] origin){
        int R = origin.length;
        int C = origin[0].length;
        int [][] newMap = new int [C][R];
        for(int r=0; r<R; r++){
            for(int c = 0; c<C; c++){
                newMap[C-1-c][r] = origin[r][c];
            }
        }
        return newMap;
    }
    // 4등분 후 오른쪽 회전
    public static int[][] f5(int [][] origin){
        int curR = origin.length;
        int curC = origin[0].length;
        int [][] newMap = new int [curR][curC];

        int newR = curR/2;
        int newC = curC/2;
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[i][j] = origin[newR+ i][j];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[i][newC+ j] =  origin[i][j];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[newR+i][j] = origin[newR + i][newC +j];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[newR+i][newC+ j] = origin[i][newC + j];
            }
        }
        return newMap;
    }
    public static int[][] f6(int [][] origin){
        int curR = origin.length;
        int curC = origin[0].length;
        int [][] newMap = new int [curR][curC];

        int newR = curR/2;
        int newC = curC/2;
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[i][j] = origin[i][j+newC];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[i][newC+ j] = origin[newR+ i][newC+ j];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[newR+i][j] = origin[i][j];
            }
        }
        for(int i=0; i<newR; i++){
            for(int j=0; j<newC; j++){
                newMap[newR+i][newC+ j] = origin[newR + i][j];
            }
        }
        return newMap;

    }

}

