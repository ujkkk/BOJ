import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N, M;
    public static int [][] map;
    public static List<Integer> groutCount;

    static int [] dr = {0, -1, 0, 1};
    static int [] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groutCount = new ArrayList<>();
        groutCount.add(0);

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹 번호 부여
        int number = 1;
        boolean [][] isVisited = new boolean[N][M];
        for(int i=0; i<N*M; i++){
            int r = i/M;
            int c = i%M;

            if(!isVisited[r][c] && map[r][c] == 1){
                int count = numbering(number++, r, c, isVisited);
                groutCount.add(count); // 1부터 시작
            }
        }

        // 개수 구하기
        for(int i=0; i<N*M; i++){
            int r = i/M;
            int c = i%M;

            if(map[r][c] != 0){
                combineShape(r, c, map[r][c]);
            }
        }

        System.out.println(ans);

    }

    private static void combineShape(int r, int c, int number){
        // 상하좌우에 모양 바꿔보기
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr <0 || nr >= N || nc <0 || nc >=M){
                continue;
            }
            // 빈 칸이 아닐 때
            if(map[nr][nc] != 0){
                continue;
            }

            // 상하좌우에 인접한 모양이 있는지 확인
            int count = groutCount.get(number);
            HashSet<Integer> contains = new HashSet<>();
            for(int j=0; j<4; j++){
                int nnr = nr + dr[j];
                int nnc = nc + dc[j];

                if(nnr <0 || nnr >= N || nnc <0 || nnc >=M){
                    continue;
                }
                // 빈 칸이 아니고 다른 그룹일 때
                int otherNumber = map[nnr][nnc];
                if(map[nnr][nnc] != 0 && otherNumber != map[r][c] && !contains.contains(otherNumber)){
                    contains.add(otherNumber);
                    count += groutCount.get(otherNumber);
                    ans = Math.max(ans, count);
                }
            }
            ans = Math.max(ans, count +1);
        }
    }

    private static int numbering(int number, int r, int c, boolean[][] isVisited){
        int count = 0;

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        isVisited[r][c] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();
            map[cur.r][cur.c] = number;
            count++;

            for(int i=0 ;i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr <0 || nr >= N || nc <0 || nc >=M){
                    continue;
                }
                if(isVisited[nr][nc] || map[nr][nc] == 0){
                    continue;
                }

                que.add(new Point(nr, nc));
                isVisited[nr][nc] = true;
            }
        }
        return count;
    }

}

class ShapePoint{
    Point pos;
    int groupNumber;

    public ShapePoint(Point pos, int groupNumber) {
        this.pos = pos;
        this.groupNumber = groupNumber;
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

