import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int R, C, T;
    static int [][] map;

    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};

    static int [] airPos = new int[2];
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int idx=0;

        for(int i=0;i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airPos[idx++]= i;
                }
            }
        }

        run();

        int sum =0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sum+= map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void run(){
        for(int t=0; t<T; t++){
            // 1. 미세먼지 확산
            spreadDust();

            // 2. 공기청정기 작동
            air();
            //printMap();
        }
    }

    public static void air(){
        int topR= airPos[0];
        int bottomR = airPos[1];

        int [][] temp = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                temp[i][j] = map[i][j];
            }
        }

        // ->
        map[topR][1] = 0;
        for(int c=2; c<C; c++){
            map[topR][c] = temp[topR][c-1];

        }
       // map[topR][C-1] = temp[topR][C-1];
        for(int r=topR-1; r>=0; r--){
            map[r][C-1] = temp[r+1][C-1];
        }
        // <-
        for(int c=C-2; c>=0; c--){
            map[0][c] = temp[0][c+1];
        }
        for(int r=1; r<topR; r++){
            map[r][0] = temp[r-1][0];
        }
        map[topR][0] = 0;

        // 아래 공기 청정기
        // ->
        map[bottomR][1] = 0;
        for(int c=2; c<C; c++){
            map[bottomR][c] = temp[bottomR][c-1];
        }
        for(int r=bottomR+1; r<R; r++){
            map[r][C-1] = temp[r-1][C-1];
        }
        // <-
        for(int c=C-2; c>=0; c--){
            map[R-1][c] = temp[R-1][c+1];
        }
        for(int r=R-2; r > bottomR; r--){
            map[r][0] = temp[r+1][0];
        }
        map[bottomR][0] = 0;
    }

    public static void printMap(){
        System.out.println("=====================");
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("=====================");
    }

    public static void spreadDust(){
        // 동시에 진행된다는 점을 고려해서 연산 결과를 따로 저장하고, 한 번에 반영함
        int [][] temp = new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 0) continue;
                int spread = map[i][j]/5;
                int count = 0;

                for(int d=0;d<4; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(nr < 0 || nr >=R || nc <0 || nc >=C){
                        continue;
                    }
                    if(map[nr][nc] == -1){
                        continue;
                    }
                    // 인접 칸들에 추가한다.
                    count++;
                    temp[nr][nc] += spread;
                }
                // 날아간 양만큼 빼줌
                temp[i][j] -= (count*spread);
            }
        }

        // 결과 반영
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] += temp[i][j];
            }
        }

    }

}