import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static boolean[][] isBomp;
    public static Queue<Point> isImminent;
    public static Queue<Point> que;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isBomp = new boolean[R][C];
        que = new LinkedList();
        isImminent = new LinkedList();

        // 0초
        for (int r = 0; r < R; r++) {
            String[] info = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                if (info[c].equals("O")) {
                    isBomp[r][c] = true;
                } else {
                    isBomp[r][c] = false;
                }
            }
        }
        // 폭탄이 0개인 경우도
        int count = 1;

        while (++count <= N) {
            // 2(짝수) 폭탄이 없는 곳에 폭탄 설치
            if (count % 2 == 0) {
                for (int r = 0; r < isBomp.length; r++) {
                    for (int c = 0; c < isBomp[0].length; c++) {
                        if (!isBomp[r][c]) { // 폭탄이 없으면 설치
                            isBomp[r][c] = true;
                        } else {
                            isImminent.add(new Point(r, c)); // 곧 터질 폭탄
                        }
                    }
                }
            } else { // 폭탄 터트리기
                while (!isImminent.isEmpty()) {
                    Point p = isImminent.poll();
                    isBomp[p.x][p.y] = false;

                    for (int i = 0; i < dx.length; i++) {
                        int curX = p.x + dx[i];
                        int curY = p.y + dy[i];
                        if (curX >= 0 && curX < R && curY >= 0 && curY < C)
                            isBomp[curX][curY] = false;
                    }
                }
            }
        }
        print();
    }

    public static void print() throws IOException {
        for (int r = 0; r < isBomp.length; r++) {
            for (int c = 0; c < isBomp[0].length; c++) {
                if (isBomp[r][c]) {
                    bw.write("O");
                } else {
                    bw.write(".");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
