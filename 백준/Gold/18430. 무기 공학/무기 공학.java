import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int max = 0;
    static int N, M;
    static int [][] map;
    static int dir [][][] = {
        { {0, 0, 1}, {0, 1, 1} },
        { {0, 0, -1}, {0, 1,1}},
        { {0, 1, 1}, {0, 0, 1} },
        { {0, 0, 1}, {0, -1,-1}}
    };

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean [][] isVisited = new boolean[N][M];
        createBumerang(isVisited, 0,0);

        System.out.println(max);
    }

    private static void createBumerang(boolean[][] isVisited, int pos, int sum){
        if(pos == N*M){
            max = Math.max(sum, max);
            return;
        }

        int r = pos/M;
        int c = pos%M;

        if(isVisited[r][c]){
            createBumerang(isVisited, pos+1, sum);
        }
        else{
            isVisited[r][c] = true;

            for(int k=0; k<4; k++){
                int nr = r + dir[k][0][1];
                int nc = c + dir[k][1][1];

                if(nr < 0 || nr >= N || nc <0 || nc >= M || isVisited[nr][nc])
                    continue;

                int nnr = r + dir[k][0][2];
                int nnc = c + dir[k][1][2];

                if(nnr < 0 || nnr >= N || nnc <0 || nnc >= M || isVisited[nnr][nnc])
                    continue;

                isVisited[nr][nc] = true;
                isVisited[nnr][nnc] = true;

                createBumerang(isVisited, pos +1, sum + map[r][c] + (map[nr][nc])*2 + map[nnr][nnc]);

                isVisited[nr][nc] = false;
                isVisited[nnr][nnc] = false;
            }

            isVisited[r][c] = false;
            createBumerang(isVisited, pos+1, sum);
        }

    }
}
