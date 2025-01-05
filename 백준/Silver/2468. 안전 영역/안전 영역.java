import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int [][] map = new int[N][N];

        int min = 101;
        int max = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int ans = 0;
        for(int h=min; h<=max; h++){
            // 잠기게 하기
            boolean [][] rainMap = rain(map, h);

            // 잠긴 개수 구하기
            int count = 0;
            boolean [][] isVisited = new boolean[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    // 방문했거나 이미 침수되어 있다면
                    if(isVisited[i][j] || rainMap[i][j])
                        continue;

                    bfs(rainMap, isVisited, new Point(i,j));
                    count++;
                }
            }
//            System.out.println("count: " + count);
            ans = Math.max(ans, count);

        }

        if(ans == 0){
            System.out.println("1");
        }
        else{
            System.out.println(ans);

        }
    }

    private static void bfs(boolean [][] map, boolean [][] isVisited, Point pos){
        Queue<Point> que = new LinkedList<>();
        que.add(pos);
        isVisited[pos.r][pos.c] = true;

        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0, -1, 0};
        int size = map.length;

        while(!que.isEmpty()){
            Point cur = que.poll();

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR <0 || nextR >=size || nextC <0 || nextC >=size){
                    continue;
                }
                // 침수가 됨
                if(map[nextR][nextC] || isVisited[nextR][nextC]){
                    continue;
                }

                que.add(new Point(nextR, nextC));
                isVisited[nextR][nextC] = true;
            }
        }
    }

    private static boolean [][] rain(int [][] map, int h){
        boolean [][] rainMap = new boolean[map.length][map.length];

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j] <= h){
                    rainMap[i][j] = true;
                }
            }
        }
        return rainMap;
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