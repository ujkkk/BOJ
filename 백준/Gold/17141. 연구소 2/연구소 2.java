import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int [][] map;
    static  ArrayList<Point> viruses;
    static  int wallCount = 0;

    static int MAX_VALUE = 100000;
    static int min = MAX_VALUE;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        viruses = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    viruses.add(new Point(i,j));
                }
                else if(map[i][j] == 1){
                    wallCount++;
                }
            }
        }
        // 입력 끝

        // 1. 바이러스 M개 선택
        selectVirus(0, 0, new boolean[viruses.size()], new Point[M]);
        System.out.println(min == MAX_VALUE? -1 : min -1);
    }

    public static int simulation(Point [] select){
        Queue<Point> que = new LinkedList<>();
        boolean [][] isVisited = new boolean[N][N];
        int time = 0;
        int pollutionCount = 0;

        int [] dr = {1, 0, -1, 0};
        int [] dc = {0, 1, 0, -1};

        // 바이러스 위치 삽입
        for(Point virus : select){
            que.add(new Point(virus.r, virus.c));
            isVisited[virus.r][virus.c] = true;
            
            pollutionCount++;
        }

        while(!que.isEmpty()){
            if(time > N*N){
                break;
            }

            int size = que.size();
            for(int i=0; i<size; i++){
                Point cur = que.poll();

                for(int j=0; j<4; j++){
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];

                    if(nr < 0|| nr >= N || nc <0 || nc >= N){
                        continue;
                    }
                    if(isVisited[nr][nc] || map[nr][nc] == 1){
                        continue;
                    }
                    que.add(new Point(nr, nc));
                    pollutionCount++;
                    isVisited[nr][nc] = true;
                }
            }
            time++;
        }

        return (pollutionCount == (N*N-wallCount))? time : MAX_VALUE;
    }

    public static void selectVirus(int depth, int next, boolean [] isSelected, Point [] select){
        if(depth == M){
            min = Math.min(min, simulation(select));
            return;
        }

        for(int i=next; i<viruses.size(); i++){
            if(isSelected[i]){
                continue;
            }

            select[depth] = viruses.get(i);
            isSelected[i] = true;

            selectVirus(depth+1, i+1, isSelected, select);

            isSelected[i] = false;
        }
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