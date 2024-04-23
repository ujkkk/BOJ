import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static boolean [][] isVisited;
    public static int [][] map;
    public static int w, h;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;
            // 변수 초기화
            map = new int[h][w];
            isVisited = new boolean[h][w];

            // map 입력받기
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            // BFS 탐색 총 몇번 하는지
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1 && !isVisited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            bw.write(count +"\n");
        }
        bw.flush();
    }

    public static void BFS(int r, int c){
        int [] dr = {0, 1, 0, -1, -1, 1, 1, -1};
        int [] dc = {1, 0, -1, 0, 1, 1, -1, -1};


        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r,c));
        isVisited[r][c] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();

            for(int i=0; i<8; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >=0 && nextR < h && nextC >=0 && nextC < w){
                    if(map[nextR][nextC] == 1 && !isVisited[nextR][nextC]){
                        que.add(new Point(nextR, nextC));
                        isVisited[nextR][nextC] = true;
                    }
                }
            }
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