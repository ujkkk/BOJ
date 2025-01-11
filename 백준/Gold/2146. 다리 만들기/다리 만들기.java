import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import jdk.nashorn.api.scripting.AbstractJSObject;


class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;
    static boolean [][] isLand;
    static int [][] lands;

    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        isLand = new boolean[N][N];
        lands = new int[N][N];

        for(int i=0 ;i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                if(Integer.parseInt(st.nextToken()) == 1)
                    isLand[i][j] = true;
            }
        }

        // 섬마다 번호 지정
        boolean [][] isVisited = new boolean[N][N];
        int landNumber = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(isLand[i][j] && !isVisited[i][j]){
                    numbering(i, j, landNumber, isVisited);
                    landNumber++;
                }
            }
        }

        // BFS
        Queue<LandPoint> que = new LinkedList<>();
        boolean [][][] check = new boolean[landNumber][N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(lands[i][j] != 0){
                    que.add(new LandPoint(lands[i][j], i,j, 0));
                }
            }
        }

        while(!que.isEmpty()){
            LandPoint cur = que.poll();

            if(check[cur.landNumber][cur.r][cur.c])
                continue;

            check[cur.landNumber][cur.r][cur.c] = true;

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= N || nc <0 || nc >=N){
                    continue;
                }
                if(check[cur.landNumber][nr][nc] || lands[nr][nc] ==cur.landNumber)
                    continue;

                // 다음 좌표가 0이 아니고, 다른 섬의 번호일 때 중단
                if(lands[nr][nc] != 0 && cur.landNumber != lands[nr][nc]){
                    System.out.println(cur.length);
                    return;
                }

                que.add(new LandPoint(cur.landNumber, nr,nc,cur.length+1));
            }
        }

        System.out.println();
    }

    private static void numbering(int r, int c, int number, boolean [][] isVisited){
        isVisited[r][c] = true;
        lands[r][c] = number;

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc <0 || nc >=N){
                continue;
            }
            if(isVisited[nr][nc] || !isLand[nr][nc])
                continue;

            numbering(nr, nc, number, isVisited);
        }
    }

}

class LandPoint{
    int landNumber;
    int r;
    int c;
    int length;

    public LandPoint(int landNumber, int r, int c, int length) {
        this.landNumber = landNumber;
        this.r = r;
        this.c = c;
        this.length = length;
    }
}


