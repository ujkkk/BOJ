import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][] population;
    static boolean[][] isVisited;
    static Queue<Point> que;
    static Queue<Point> curQue;
    static int N, L, R;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        isVisited = new boolean[N][N];
        que = new LinkedList<>();
        curQue = new LinkedList<>();

        // 인구수 입력
        for (int i = 0; i < N; i++) {
            population[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean isChage = true;
        int result = 0;
        while (isChage) {
            // 한 주기
            isChage = false;
            isVisited = new boolean[N][N];
            result++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isVisited[i][j])
                        continue;
                    // 한 연합 시작
                    if(bfs(new Point(i,j))){
                        isChage = true;
                    }
                }
            }
        }
        System.out.println(result-1);

    }
    public static boolean bfs(Point start){
        boolean isChage = false;
        // 한 연합 탐색 시작
        int popul_sum = 0;
        que.add(start);
        isVisited[start.x][start.y] = true;

        while (!que.isEmpty()) {
            Point curPoint = que.poll();
            curQue.add(curPoint);
            popul_sum += population[curPoint.x][curPoint.y];

            // 사각지대 비교(차이가 L명이상이고 R명 이하이면 인구이동)
            for (int d = 0; d < 4; d++) {
                Point nextPoint = new Point(curPoint.x + dx[d], curPoint.y + dy[d]);
                if (compare(curPoint, nextPoint) && !isVisited[nextPoint.x][nextPoint.y] ) {
                    que.add(nextPoint);
                    isVisited[nextPoint.x][nextPoint.y] = true;
                    isChage = true;
                }
            }
        }  // 한 연합 탐색 끝

        // 인구 이동
        int curPopul = popul_sum / curQue.size();
        while (!curQue.isEmpty()) {
            Point pos = curQue.poll();
            population[pos.x][pos.y] = curPopul;
        }
        return isChage;
    }

    public static boolean compare(Point p1, Point p2) {
        if (p2.x >= 0 && p2.x < N && p2.y >= 0 && p2.y < N) {
            if ((Math.abs(population[p1.x][p1.y] - population[p2.x][p2.y]) >= L)
                    && Math.abs(population[p1.x][p1.y] - population[p2.x][p2.y]) <= R) {
                return true;
            }
        }
        return false;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}