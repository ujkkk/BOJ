import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static  int [][] map;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        String findStr = br.readLine();

        int [][][] dp = new int[findStr.length()+1][N][M];

        int first = findStr.charAt(0) - 'A';
        // 첫번째 알파벳으로 시작하는거 다 넣기
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == first){
                    dp[1][i][j] = 1;
                }
            }
        }

        int dr [] = {-1, 1, 0, 0};
        int dc [] = {0,0, 1, -1};

        for(int p=1; p<findStr.length(); p++) {
            int find = findStr.charAt(p) - 'A';

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dp[p][i][j] == 0) {
                        continue;
                    }

                    // 현재 위치에서 상하죄우 K만큼 이동
                    for(int dir=0; dir<dr.length; dir++){
                        for(int k=1; k<=K; k++){
                            int nextR = i + dr[dir]*k;
                            int nextC = j + dc[dir]*k;

                            if(nextR <0 || nextR >= N || nextC <0 || nextC >=M){
                                continue;
                            }

                            if(map[nextR][nextC] == find){
                                dp[p+1][nextR][nextC] = Math.max(dp[p][i][j], dp[p+1][nextR][nextC] + dp[p][i][j]);
                            }
                        }
                    }

                }
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(dp[findStr.length()][i][j] == 0){
                    continue;
                }
                result += dp[findStr.length()][i][j];
            }
        }

        System.out.println(result);
    }

}

class Point{
    int r;
    int c;
    int cnt;

    public Point(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }

    @Override
    public boolean equals(Object o){
        Point p = (Point) o;
        if(this.r == p.r && this.c == p.c){
            return true;
        }
        return false;
    }
}
