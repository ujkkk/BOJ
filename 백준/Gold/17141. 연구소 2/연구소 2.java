import java.io.*;
import java.util.*;

public class Main{
    //시계 방향
    public static int [] dr = {-1, 0, 1, 0};
    public static int [] dc = {0, 1, 0, -1};
    public static boolean [][] isVisited;

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N;
    public static int M;
    public static int exceptionCount= 0;

    public static List<Point> virusPosList;
    public static boolean map[][];
    public static int result = Integer.MAX_VALUE-1;

    public static void main(String [] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        virusPosList = new ArrayList<>();
        initMap();

        //int virusSize = Math.min(M, virusPosList.size());
        boolean [] isSelected = new boolean [virusPosList.size()];
        Point[] selectedVirus  = new Point[M];
        selectVirusPosition(0, isSelected,selectedVirus, 0);

        if(result == Integer.MAX_VALUE -1)
            bw.write("-1\n");
        else
            bw.write(result-1 +"\n");
        bw.flush();

    }

    public static void selectVirusPosition(int depth, boolean [] isSelected, Point[] selectedVirus, int start){
        if(depth == M){
            // 퍼지는 최소 일 구하기
            boolean [][] isVisited = new boolean[N][N];
            getMinDay(selectedVirus, isVisited);
            return;
        }

        for(int i=start; i< isSelected.length; i++){
            if(!isSelected[i]){
                selectedVirus[depth] = virusPosList.get(i);
                isSelected[i] = true;

                selectVirusPosition(depth +1, isSelected,selectedVirus, i+1);

                isSelected[i] = false;
                selectedVirus[depth] = null;
            }
        }
    }

    public static void getMinDay(Point[] selectedVirus,  boolean [][] isVisited){
        Queue<Point> que = new LinkedList<>();
        int day = 0;
        int count = 0;
        int [] dr = {1, 0, -1, 0};
        int [] dc = {0, 1, 0, -1};
        for(Point virus : selectedVirus){
            que.add(virus);
            isVisited[virus.row][virus.col] = true;
        }

        while(!que.isEmpty()){
            day++;
            int size = que.size();
            for(int i=0; i<size; i++){
                Point cur = que.poll();
                count++;

                for(int j=0; j<dr.length ;j++){
                    int nextRow = cur.row + dr[j];
                    int nextCol = cur.col + dc[j];

                    // && !isVisited[nextRow][nextCol]
                    if(isRange(nextRow, nextCol) && map[nextRow][nextCol]&& !isVisited[nextRow][nextCol]){
                        que.add(new Point(nextRow, nextCol));
                        isVisited[nextRow][nextCol] = true;

                    }
                }
            }
        }

        if(count < N*N-exceptionCount)
            return;
        result = Math.min(result, day);
    }

    public static void initMap() throws IOException {
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());
                switch (value){
                    case 0: // 빈 칸
                        map[i][j] = true;
                        break;
                    case 1: // 벽
                        map[i][j] = false;
                        exceptionCount++;
                        break;
                    case 2: // 바이러스가 놓아질 수 있는 위치
                        map[i][j] = true;
                        virusPosList.add(new Point(i,j));
                }
            }
        }
    }

    public static boolean isRange(int r, int c){
        if(r >= 0 && r < N  && c >=0 && c< N)
            return true;
        return false;
    }

}

class Point{
    int row;
    int col;

    public Point(int row, int col){
        this.row = row;
        this.col =col;
    }
}