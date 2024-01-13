import java.io.*;
import java.util.*;

public class Main{
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static Point jihun;
    public static List<Point> startFires;
    public static boolean [][] map;
    public static int R;
    public static int C;
    public static int [][] fireTime;
    public static int [] dr = {0, 1, 0, -1};
    public static int [] dc = {1, 0, -1, 0};
    public static void main(String [] args) throws Exception{
         br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        startFires = new ArrayList<>();
        initMap(map);

        fireTime = new int[R][C];
        for(int i=0; i<R; i++)
            for(int j=0; j<C; j++)
                fireTime[i][j] = Integer.MAX_VALUE-1;
        boolean [][] isVisited;
        for(int i=0; i<startFires.size(); i++){
            isVisited = new boolean[R][C];
            getFireReachTime(startFires.get(i), isVisited);
        }


        isVisited = new boolean[R][C];
        int count = getEscapeTime(jihun, isVisited);

        if(count == -1)
            bw.write("IMPOSSIBLE\n");
        else
            bw.write(count+"\n");
        bw.flush();

        bw.close();
        br.close();
    }
    public static int getEscapeTime(Point start, boolean[][] isVisited){
        isVisited[start.row][start.col] = true;
        Queue<Point> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            Point curPoint = que.poll();
            fireTime[curPoint.row][curPoint.col] = curPoint.time;

            for(int i=0; i< dr.length; i++){
                int newR = curPoint.row + dr[i];
                int newC = curPoint.col + dc[i];
                int newTime = curPoint.time + 1;
                if(!isRange(newR, newC))
                    return newTime;

                if(!isVisited[newR][newC] && map[newR][newC]
                && newTime < fireTime[newR][newC]){
                    que.add(new Point(newR,newC, curPoint.time +1));
                    isVisited[newR][newC] = true;
                }
            }
        }
        return -1;
    }
    public static void getFireReachTime(Point start, boolean[][] isVisited){
        isVisited[start.row][start.col] = true;
        Queue<Point> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            Point curPoint = que.poll();
            fireTime[curPoint.row][curPoint.col] = curPoint.time;

            for(int i=0; i< dr.length; i++){
                int newR = curPoint.row + dr[i];
                int newC = curPoint.col + dc[i];
                int newTime = curPoint.time +1;

                if(isRange(newR, newC) && !isVisited[newR][newC] && map[newR][newC]){
                    if(newTime < fireTime[newR][newC]){
                        que.add(new Point(newR,newC, newTime));
                        isVisited[newR][newC] = true;
                    }

                }
            }
        }
    }
    public static void initMap(boolean[][] map) throws IOException {
        for(int i = 0; i<R; i++){
            String str = br.readLine();
            for(int j =0; j<C; j++){
                char cur = str.charAt(j);
                if(cur == '#')
                    continue;

                if(cur == 'J'){
                    jihun = new Point(i,j,0);
                }
                else if(cur == 'F')
                    startFires.add(new Point(i,j,0));

                map[i][j] = true;

            }
        }
    }

    public static boolean isRange(int r, int c){
        if(r >=0 && r< R && c >=0 && c < C)
            return true;
        return false;
    }
}

class Point {
    int row;
    int col;
    int time;
    public Point (int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
