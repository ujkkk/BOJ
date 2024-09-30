import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static int R;
    public static int C;
    public static int max;
    public static int [][] map ;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C;j ++){
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        // BFS
        dfs(new Point(0,0), new boolean[26], 1);
        bw.write(max + "\n");
        bw.flush();

    }

    public static void dfs(Point cur, boolean[] visited, int count){
        visited[map[cur.r][cur.c]] = true;
        max = Math.max(count, max);

        int [] dr = {0, -1, 0, 1, 0};
        // 상하좌우
        for(int i=0; i<4; i++){
            int nextR = cur.r + dr[i];
            int nextC = cur.c + dr[i+1];

            if(nextR <0 || nextR >= R || nextC <0 || nextC >=C){
                continue;
            }
            if(visited[map[nextR][nextC]]){
                continue;
            }

            dfs(new Point(nextR, nextC), visited, count +1);
            visited[map[nextR][nextC]] = false;
        }
    }
}

class Point{
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}


