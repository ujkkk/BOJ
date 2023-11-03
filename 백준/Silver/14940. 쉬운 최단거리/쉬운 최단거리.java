import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static Queue<Data> que;
    static boolean [][] isGround;
    static boolean [][] isVisited;
    static int [][] distances;
    static Point start;

    static int [] dx = new int[]{0,1,0,-1};
    static int [] dy = new int[]{1,0,-1,0};

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        isGround = new boolean[row][col];
        distances = new int[row][col];
        isVisited = new boolean[row][col];
        que = new LinkedList<>();

        // Input
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int state = Integer.parseInt(st.nextToken());
                distances[i][j] = 0;
                switch (state) {
                    case 0:
                        isGround[i][j] = false;
                        break;
                    case 1:
                        isGround[i][j] = true;
                        break;
                    case 2:
                        start = new Point(i, j);
                }
            }
        }

        // start 부터
        distances[start.x][start.y] = 0;
        isVisited[start.x][start.y] = true;
        que.add(new Data(start, 0));

        while (!que.isEmpty()) {
            Data curData = que.poll();
            for (int i = 0; i < 4; i++) {
                int r = curData.pos.x + dx[i];
                int c = curData.pos.y + dy[i];
                if(r>=0 && r<row && c>=0 && c<col){
                    if (isGround[r][c] && !isVisited[r][c]) {
                        que.add(new Data(new Point(r, c), curData.distance + 1));
                        isVisited[r][c] = true;
                        distances[r][c] = curData.distance + 1;
                    }
                }

            }
        }



        // output
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 갈 수 있는 땅인 부분 중 도달할 수 없음
                if(isGround[i][j] && distances[i][j] == 0){
                    bw.write(-1 + " ");
                    continue;
                }
                bw.write(distances[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}

class Data{
    Point pos;
    int distance;

    public Data(Point pos, int distance){
        this.pos = pos;
        this.distance = distance;
    }
}