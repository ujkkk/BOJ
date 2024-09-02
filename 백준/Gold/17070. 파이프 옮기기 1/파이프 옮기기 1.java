
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

    public static int HORIZON = 0;
    public static int VERTICAL = 1;
    public static int DIAGONAL = 2;


    public void run () throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [][][] isVisited = new int[N][N][3];
        int [][] map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[0][1][HORIZON] = 1;

        for(int i=0; i<N; i++){
            for(int j=1; j<N; j++){
                if(i==0 && j<2)
                    continue;
                if(map[i][j] == 1)
                    continue;

                // 대각선
                if(i-1 >=0 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1){
                    isVisited[i][j][DIAGONAL] = isVisited[i-1][j-1][HORIZON]
                        + isVisited[i-1][j-1][VERTICAL]
                        + isVisited[i-1][j-1][DIAGONAL];
                }
                // 세로
                if(i-1 >=0 && map[i-1][j] !=1){
                    isVisited[i][j][VERTICAL] = isVisited[i-1][j][VERTICAL]
                        + isVisited[i-1][j][DIAGONAL];
                }

                // 가로
                if(map[i][j-1] != 1){
                    isVisited[i][j][HORIZON] = isVisited[i][j-1][HORIZON]
                        + isVisited[i][j-1][DIAGONAL];
                }
            }
        }
        System.out.println(isVisited[N-1][N-1][VERTICAL] + isVisited[N-1][N-1][HORIZON] + isVisited[N-1][N-1][DIAGONAL]);
    }


    public static void main(String[] args) throws IOException {

        new Main().run();
    }
}


