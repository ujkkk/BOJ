import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] array = new int[N + 2][N + 2];

        int d = 0;
        int num = N * N;
        int x = 1;
        int y = 1;

        int findX = 0; int findY = 0;
        while (num > 0) {
            // 한 방향에 대해서 전진
            while (true) {
                array[y][x] = num--;
                if(array[y][x] == M){
                    findX = x;
                    findY = y;
                }
                // 좌표 이동
                x = x + dx[d];
                y = y + dy[d];
                //  이미 채워진 곳이거나 배열의 범위 밖이면 방향 전환
                if (array[y + dy[d]][x + dx[d]] != 0 || !validRange(x + dx[d], y + dy[d], N)) {
                    d = (d + 1) % 4;
                    break;
                }
            }
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(array[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write( findY + " " + findX);
        bw.flush();

        bw.close();
        br.close();
    }

    public static boolean validRange(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }
}